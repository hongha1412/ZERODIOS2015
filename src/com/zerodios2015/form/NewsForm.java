/**
 * Copyright(C) ZeroDios2015
 *
 * NewsForm.java, Nov 4, 2015 
 * @author: HaVH-PC
 *
 */
package com.zerodios2015.form;

import java.util.List;

import com.zerodios2015.DTO.MenuDTO;

/**
 * 
 * @author HaVH-PC
 *
 */
public class NewsForm extends ActionFormBase {

    /**
     * long
     */
    private static final long serialVersionUID = 1L;
    /**
     * List<MenuDTO>
     */
    List<MenuDTO> lsMenu;

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
}
