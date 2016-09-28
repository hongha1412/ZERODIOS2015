/**
 * Copyright(C) ZeroDios2015
 *
 * BaseDTO.java, Jul 6, 2016
 * @author: HaVH
 *
 */
package com.zerodios2015.DTO;

import java.util.List;

import lombok.Data;

/**
 * @author HaVH
 *
 */
@Data
public class BaseFormDTO {

    /**
     * Menu list in database List<MenuDTO>
     */
    private List<MenuDTO> lsMenu;
}
