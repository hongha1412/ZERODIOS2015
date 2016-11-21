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
import com.zerodios2015.Utils.ZDException;

/**
 * 
 * @author HaVH-PC
 *
 */
public class NewsDAO extends BaseDAO {

    public List<NewsDTO> getNews(NewsDTO newsDTO, String condition, int offset, int max) throws Exception {
        List<NewsDTO> lsNews = new ArrayList<>();

        sqlParameter = new ArrayList<Object>();
        sqlCommand = new StringBuilder();
        sqlCommand.append("SELECT ");
        sqlCommand.append("    N.ID ");
        sqlCommand.append("    , N.CATEGORY ");
        sqlCommand.append("    , N.TITLE ");
        sqlCommand.append("    , N.DESCRIPTION ");
        sqlCommand.append("    , N.AUTHOR AUTHORID ");
        sqlCommand.append("    , A.NAME AUTHOR ");
        sqlCommand.append("    , N.DATE ");
        sqlCommand.append("    , N.REMARK ");
        sqlCommand.append("    , N.PIN ");
        sqlCommand.append("    , N.STATUS ");
        sqlCommand.append("    , N.VERSION ");
        sqlCommand.append("FROM ");
        sqlCommand.append("    WEB_NEWS N ");
        sqlCommand.append("LEFT JOIN ");
        sqlCommand.append("    ACCOUNT A ");
        sqlCommand.append("ON ");
        sqlCommand.append("    N.AUTHOR = A.ID ");

        StringBuilder sqlCondition = new StringBuilder();
        sqlCondition.append(this.toConditionQuery(newsDTO, sqlParameter, "N"));
        sqlCommand.append(sqlCondition);
        sqlCommand.append("ORDER BY N.ID ASC ");
        if (max > 0 && offset >= 0) {
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

    public void addNews(NewsDTO newsDTO) throws Exception {
        if (findByPrimaryKey(newsDTO.getId()) != null) {
            throw new Exception(ZDException.ZDNEWSEXCEPTION003);
        }

        sqlParameter = new ArrayList<>();
        sqlCommand = new StringBuilder();
        sqlCommand.append("INSERT INTO ");
    }

    /**
     * Edit news information by news id
     * 
     * @param id News Id
     * @param newsDTO new value
     * @return Success: true - success / false - fail
     * @throws Exception
     */
    public boolean editNewsById(int id, NewsDTO newsDTO) throws Exception {
        if (this.findByPrimaryKey(id) == null) {
            return false;
        }

        sqlParameter = new ArrayList<>();
        sqlCommand = new StringBuilder();
        sqlCommand.append(" UPDATE WEB_NEWS ").append(this.toSetQuery(newsDTO, sqlParameter));
        sqlCommand.append(" WHERE ID = ? ");
        sqlParameter.add(id);

        int affRows = getJdbcTemplate().update(sqlCommand.toString(), sqlParameter.toArray());
        if (affRows > 0) {
            return true;
        }

        return false;
    }

    /**
     * Find news by id
     * 
     * @param id
     * @return Null if not found 
     * @throws Exception
     */
    public NewsDTO findByPrimaryKey(int id) throws Exception {
        NewsDTO result = new NewsDTO();
        result.setId(id);
        List<NewsDTO> lsNews = this.getNews(result, null, 0, 1);
        if (lsNews != null && !lsNews.isEmpty()) {
            return lsNews.get(0);
        }
        return null;
    }
}
