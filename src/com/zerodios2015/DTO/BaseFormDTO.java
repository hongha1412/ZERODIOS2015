/**
 * Copyright(C) ZeroDios2015
 *
 * BaseDTO.java, Jul 6, 2016
 * @author: HaVH
 *
 */
package com.zerodios2015.DTO;

import java.util.List;

/**
 * @author HaVH
 *
 */
public class BaseFormDTO {

    /**
     * Menu list in database List<MenuDTO>
     */
    private List<MenuDTO> lsMenu;

    /**
     * Column list of screen data List<ColumnDTO>
     */
    private List<ColumnDTO> lsColumn;

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
