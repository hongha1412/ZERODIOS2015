/**
 * Copyright(C) ZeroDios2015
 *
 * MenuDao.java, Jun 30, 2016
 * @author: HaVH
 *
 */
package com.zerodios2015.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import com.zerodios2015.DTO.MenuDTO;

/**
 * @author HaVH
 *
 */
public class MenuDAO extends BaseDao {

    DataSource dataSource;

    /**
     * @return List Menu
     */
    public List<MenuDTO> getAllMenu() throws Exception {
        String query = "SELECT * FROM WEB_MENU ORDER BY `PARENT`, `ID`";

        List<Map<String, Object>> collection = getJdbcTemplate().queryForList(query);
        List<MenuDTO> lsParent = new ArrayList<>();
        List<Map<String, Object>> partCollection = new ArrayList<>();

        for (Map<String, Object> map : collection) {
            if ((int) map.get("parent") == -1) {
                lsParent.add(new MenuDTO((int) map.get("id"), map.get("name").toString(), (int) map.get("parent"),
                        map.get("link").toString(), (int) map.get("level"), (int) map.get("status"),
                        Long.parseLong(map.get("version").toString())));
            } else {
                partCollection.add(map);
            }
        }

        for (Map<String, Object> map : partCollection) {
            lsParent = recursiveMenu(lsParent, map);
        }

        return lsParent;
    }

    private List<MenuDTO> recursiveMenu(List<MenuDTO> lsMenu, Map<String, Object> child) {
        List<MenuDTO> lsFound = lsMenu.stream().filter(menu -> menu.getId() == (int) child.get("parent"))
                .collect(Collectors.toList());

        if (lsFound.size() > 0) {
            lsFound.stream().forEach(menu -> {
                menu.getLsChild()
                        .add(new MenuDTO((int) child.get("id"), child.get("name").toString(), (int) child.get("parent"),
                                child.get("link").toString(), (int) child.get("level"), (int) child.get("status"),
                                Long.parseLong(child.get("version").toString())));
            });
        } else {
            lsMenu.stream().forEach(menu -> {
                if (menu.getLsChild().size() > 0) {
                    menu.setLsChild(recursiveMenu(menu.getLsChild(), child));
                }
            });
        }

        return lsMenu;
    }
}
