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

import org.apache.commons.lang.StringEscapeUtils;

import com.zerodios2015.DTO.NewsDTO;
import com.zerodios2015.Utils.ZDException;
import com.zerodios2015.Utils.ZDUtils;

/**
 * 
 * @author HaVH-PC
 *
 */
public class NewsDAO extends BaseDAO {

    public List<NewsDTO> getNews(NewsDTO newsDTO, int offset, int max) throws Exception {
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
                    ZDUtils.unEscapeDB((String) news.get("TITLE")),
                    ZDUtils.unEscapeDB((String) news.get("DESCRIPTION")),
                    news.get("AUTHOR"),
                    news.get("DATE"),
                    news.get("REMARK"),
                    news.get("PIN"),
                    news.get("STATUS"),
                    news.get("VERSION"));
        }).collect(Collectors.toList());

        return lsNews;
    }

    /**
     * Add news information
     * 
     * @param newsDTO
     * @return true: success / false: fail
     * @throws Exception
     */
    public boolean addNews(NewsDTO newsDTO) throws ZDException {
        boolean rt = false;

        if (findByPrimaryKey(newsDTO.getId()) != null) {
            throw new ZDException(ZDException.ZDNEWSEXCEPTION003);
        }

        sqlParameter = new ArrayList<>();
        sqlCommand = new StringBuilder();
        sqlCommand.append("INSERT INTO WEB_NEWS VALUES (?, ?, ?, ?, ?, NOW(), ?, ?, ?, ?)");
        sqlParameter.add(newsDTO.getId());
        sqlParameter.add(newsDTO.getCategory());
        sqlParameter.add(newsDTO.getTitle());
        sqlParameter.add(StringEscapeUtils.escapeHtml(newsDTO.getDescription()));
        sqlParameter.add(Integer.parseInt(newsDTO.getAuthor()));
        sqlParameter.add(newsDTO.getRemark());
        sqlParameter.add(newsDTO.getPin() ? 1 : 0);
        sqlParameter.add(1);
        sqlParameter.add(1);

        int affRow = getJdbcTemplate().update(sqlCommand.toString(), sqlParameter.toArray());
        if (affRow > 0) {
            rt = true;
        }

        return rt;
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
        newsDTO.setDescription(StringEscapeUtils.escapeHtml(newsDTO.getDescription()));

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
    public NewsDTO findByPrimaryKey(int id) throws ZDException {
        NewsDTO result = new NewsDTO();
        result.setId(id);
        List<NewsDTO> lsNews;
        try {
            lsNews = this.getNews(result, 0, 1);
            if (lsNews != null && !lsNews.isEmpty()) {
                return lsNews.get(0);
            }
        } catch (Exception e) {
            throw new ZDException(e.getMessage());
        }
        return null;
    }

    /**
     * Get id for add news
     * 
     * @return id to add
     */
    public Integer getIdForAdd() {
        Integer rt = null;
        sqlCommand = new StringBuilder();
        sqlCommand.append("SELECT MAX(ID) ID FROM WEB_NEWS");

        List<Map<String, Object>> result = getJdbcTemplate().queryForList(sqlCommand.toString());
        if (result != null && result.size() > 0) {
            rt = Integer.valueOf(result.get(0).get("ID").toString());
        }

        return ++rt;
    }
}
