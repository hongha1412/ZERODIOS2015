/**
 * Copyright(C) ZeroDios2015
 *
 * NewsDAO.java, Nov 4, 2015 
 * @author: HaVH-PC
 *
 */
package com.zerodios2015.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zerodios2015.DTO.NewsDTO;

/**
 * 
 * @author HaVH-PC
 *
 */
public class NewsDAO extends BaseDao {

    public List<NewsDTO> getNews(NewsDTO newsDTO, String condition, int max, int offset) throws Exception {
        List<NewsDTO> lsNews = new ArrayList<>();

        List<Object> sqlParameter = new ArrayList<Object>();
        StringBuilder sqlCommand = new StringBuilder();
        sqlCommand.append("SELECT ");
        sqlCommand.append("    ID ");
        sqlCommand.append("    , CATEGORY ");
        sqlCommand.append("    , TITLE ");
        sqlCommand.append("    , DESCRIPTION ");
        sqlCommand.append("    , AUTHOR ");
        sqlCommand.append("    , DATE ");
        sqlCommand.append("    , REMARK ");
        sqlCommand.append("    , PIN ");
        sqlCommand.append("    , STATUS ");
        sqlCommand.append("    , VERSION ");
        sqlCommand.append("FROM ");
        sqlCommand.append("    WEB_NEWS ");

        StringBuilder sqlCondition = new StringBuilder(this.toQuery(newsDTO, sqlParameter));
        sqlCommand.append(sqlCondition);
        sqlCommand.append("ORDER BY ID ASC");
        if (max != 0 && offset != 0) {
            sqlCommand.append("LIMIT ").append(offset).append(", ").append(max).append(" ");
        }

        List<Map<String, Object>> result = getJdbcTemplate().queryForList(sqlCommand.toString(), sqlParameter.toArray());

        return lsNews;
    }
}
