/**
 * Copyright(C) ZeroDios2015
 *
 * ActionBase.java, Nov 4, 2015 
 * @author: HaVH-PC
 *
 */
package com.zerodios2015.action;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.Action;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zerodios2015.DAO.MenuDAO;
import com.zerodios2015.DTO.ColumnDTO;
import com.zerodios2015.DTO.MenuDTO;

/**
 * 
 * @author HaVH-PC
 *
 */
public class ActionBase extends Action {

    /**
     * Get menu information
     * @param request HttpServletRequest
     * @return List<MenuDTO>
     * @throws Exception
     */
    public List<MenuDTO> getMenu(HttpServletRequest request) throws Exception {
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(((HttpServletRequest) request).getSession().getServletContext());
        MenuDAO menuDAO = (MenuDAO) ctx.getBean("menuDAO");
        List<MenuDTO> lsMenu = null;

        lsMenu = menuDAO.getAllMenu();

        return lsMenu;
    }

    /**
     * Get list column from DTO
     * @param o DTO
     * @return List<Column>
     */
    public List<ColumnDTO> convertToColumn(Object o) {
        List<ColumnDTO> lsColumn = new ArrayList<>();

        if (o == null) {
            return lsColumn; 
        }

        for (Field f : o.getClass().getDeclaredFields()) {

            // Set access permission for this field
            f.setAccessible(true);

            lsColumn.add(new ColumnDTO(f.getName().toUpperCase()));
        }

        return lsColumn;
    }
}
