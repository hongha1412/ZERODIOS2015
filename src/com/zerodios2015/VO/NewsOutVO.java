/**
 * Copyright(C) ZeroDios2015
 *
 * NewsOutVO.java, Nov 4, 2015 
 * @author: HaVH-PC
 *
 */
package com.zerodios2015.VO;

import java.util.ArrayList;
import java.util.List;

import com.zerodios2015.DTO.NewsDTO;

/**
 * 
 * @author HaVH-PC
 *
 */
public class NewsOutVO extends BaseOutVO {
    private List<NewsDTO> lsNews;
    private String sortKey;
    private String sortOrder;
    private String max;
    private String offset;

    public NewsOutVO() {
        this.setTitle("web.title.news");
        this.lsNews = new ArrayList<>();
    }

    /**
     * @return the lsNews
     */
    public List<NewsDTO> getLsNews() {
        return lsNews;
    }

    /**
     * @param lsNews the lsNews to set
     */
    public void setLsNews(List<NewsDTO> lsNews) {
        this.lsNews = lsNews;
    }

    /**
     * @return the sortKey
     */
    public String getSortKey() {
        return sortKey;
    }

    /**
     * @param sortKey the sortKey to set
     */
    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    /**
     * @return the sortOrder
     */
    public String getSortOrder() {
        return sortOrder;
    }

    /**
     * @param sortOrder the sortOrder to set
     */
    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * @return the max
     */
    public String getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(String max) {
        this.max = max;
    }

    /**
     * @return the offset
     */
    public String getOffset() {
        return offset;
    }

    /**
     * @param offset the offset to set
     */
    public void setOffset(String offset) {
        this.offset = offset;
    }
}
