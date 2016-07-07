/**
 * Copyright(C) ZeroDios2015
 *
 * ColumnDto.java, Jul 6, 2016
 * @author: HaVH
 *
 */
package com.zerodios2015.DTO;

/**
 * @author HaVH
 *
 */
public class ColumnDTO {

    /**
     * Coloumn name String
     */
    private String name;

    /**
     * Column sort boolean
     */
    private boolean sortAsc;

    /**
     * Column hidden boolean
     */
    private boolean hidden;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sortAsc
     */
    public boolean isSortAsc() {
        return sortAsc;
    }

    /**
     * @param sortAsc the sortAsc to set
     */
    public void setSortAsc(boolean sortAsc) {
        this.sortAsc = sortAsc;
    }

    /**
     * @return the hidden
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * @param hidden the hidden to set
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
