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

import com.zerodios2015.DTO.MenuDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author HaVH-PC
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ActionFormBase extends ActionForm {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Menu list in database List<MenuDTO>
     */
    private List<MenuDTO> lsMenu;
}
