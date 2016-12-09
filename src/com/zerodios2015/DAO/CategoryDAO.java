/**
 * Copyright(C) ZeroDios2015
 *
 * CategoryDAO.java, Nov 22, 2016
 * @author: HaVH
 *
 */
package com.zerodios2015.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.zerodios2015.DTO.CategoryDTO;
import com.zerodios2015.Utils.ZDUtils;

/**
 * @author HaVH
 *
 */
public class CategoryDAO extends BaseDAO {

    /**
     * Get list category
     * 
     * @param cateDTO
     * @param offset
     * @param max
     * @return List<CategoryDTO>
     * @throws Exception
     */
    public List<CategoryDTO> getCategories(CategoryDTO cateDTO, int offset, int max) throws Exception {
        List<CategoryDTO> lsCategory = new ArrayList<>();

        sqlCommand = new StringBuilder();
        sqlParameter = new ArrayList<>();
        sqlCommand.append("SELECT ");
        sqlCommand.append("    ID, ");
        sqlCommand.append("    NAME, ");
        sqlCommand.append("    PARENT, ");
        sqlCommand.append("    STATUS, ");
        sqlCommand.append("    VERSION ");
        sqlCommand.append("FROM ");
        sqlCommand.append("WEB_CATEGORY ");
        sqlCommand.append(this.toConditionQuery(cateDTO, sqlParameter));
        sqlCommand.append("ORDER BY ID ");
        if (max > 0 && offset >= 0) {
            sqlCommand.append("LIMIT ").append(offset).append(", ").append(max).append(" ");
        }

        List<Map<String, Object>> result = getJdbcTemplate().queryForList(sqlCommand.toString(), sqlParameter.toArray());
        lsCategory = result.stream().map(cate -> {
            return new CategoryDTO(
                    cate.get("ID"),
                    ZDUtils.unEscapeDB((String) cate.get("NAME")),
                    cate.get("PARENT"),
                    cate.get("STATUS"),
                    cate.get("VERSION"));
        }).collect(Collectors.toList());

        return lsCategory;
    }

    /**
     * Get category by primary key
     * 
     * @param id
     * @return
     * @throws Exception
     */
    public CategoryDTO findByPrimaryKey(int id) throws Exception {
        CategoryDTO cateDTO = new CategoryDTO();
        cateDTO.setId(id);
        List<CategoryDTO> categories = getCategories(cateDTO, 0, 1);
        if (categories != null && categories.size() > 0) {
            return categories.get(0);
        }
        return null;
    }
}
