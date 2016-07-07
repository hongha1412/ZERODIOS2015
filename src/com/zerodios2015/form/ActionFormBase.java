/**
 * Copyright(C) ZeroDios2015
 *
 * ActionFormBase.java, Nov 4, 2015 
 * @author: HaVH-PC
 *
 */
package com.zerodios2015.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.zerodios2015.DTO.ColumnDTO;
import com.zerodios2015.DTO.MenuDTO;

/**
 * 
 * @author HaVH-PC
 *
 */
public class ActionFormBase extends ActionForm {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

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
