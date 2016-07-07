/**
 * Copyright(C) ZeroDios2015
 *
 * BaseOutVO.java, Nov 4, 2015 
 * @author: HaVH-PC
 *
 */
package com.zerodios2015.VO;

import java.util.List;

import com.zerodios2015.DTO.ColumnDTO;
import com.zerodios2015.DTO.MenuDTO;

/**
 * 
 * @author HaVH-PC
 *
 */
public class BaseOutVO {

    private String title;
    private List<MenuDTO> lsMenu;
    private List<ColumnDTO> lsColumn;

    /**
     * Default constructor
     */
    public BaseOutVO() {
        super();
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the lsMenu
     */
    public List<MenuDTO> getLsMenu() {
        return lsMenu;
    }

    /**
     * @param lsMenu the lsMenu to set
     */
    public void setLsMenu(List<MenuDTO> lsMenu) {
        this.lsMenu = lsMenu;
    }

    /**
     * @return the lsColumn
     */
    public List<ColumnDTO> getLsColumn() {
        return lsColumn;
    }

    /**
     * @param lsColumn the lsColumn to set
     */
    public void setLsColumn(List<ColumnDTO> lsColumn) {
        this.lsColumn = lsColumn;
    }
}
