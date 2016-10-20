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
import java.util.stream.Collectors;

import com.zerodios2015.DTO.NewsDTO;

/**
 * 
 * @author HaVH-PC
 *
 */
public class NewsDAO extends BaseDAO {

    public List<NewsDTO> getNews(NewsDTO newsDTO, String condition, int max, int offset) throws Exception {
        List<NewsDTO> lsNews = new ArrayList<>();

        sqlParameter = new ArrayList<Object>();
        sqlCommand = new StringBuilder();
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

        StringBuilder sqlCondition = new StringBuilder();
        sqlCondition.append(this.toConditionQuery(newsDTO, sqlParameter));
        sqlCommand.append(sqlCondition);
        sqlCommand.append("ORDER BY ID ASC ");
        if (max > 0 && offset > 0) {
            sqlCommand.append("LIMIT ").append(offset).append(", ").append(max).append(" ");
        }

        List<Map<String, Object>> result = getJdbcTemplate().queryForList(sqlCommand.toString(), sqlParameter.toArray());
        lsNews = result.stream().map(news -> {
            return new NewsDTO(
                    news.get("ID"),
                    news.get("CATEGORY"),
                    news.get("TITLE"),
                    news.get("DESCRIPTION"),
                    news.get("AUTHOR"),
                    news.get("DATE"),
                    news.get("REMARK"),
                    news.get("PIN"),
                    news.get("STATUS"),
                    news.get("VERSION"));
        }).collect(Collectors.toList());

        return lsNews;
    }
}
