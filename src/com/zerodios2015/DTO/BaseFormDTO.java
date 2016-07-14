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
