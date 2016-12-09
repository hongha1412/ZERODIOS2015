/**
 * Copyright(C) ZeroDios2015
 *
 * ActionBase.java, Nov 4, 2015 
 * @author: HaVH-PC
 *
 */
package com.zerodios2015.Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.Action;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zerodios2015.DAO.MenuDAO;
import com.zerodios2015.DTO.MenuDTO;

/**
 * 
 * @author HaVH-PC
 *
 */
public class ActionBase extends Action {

    /**
     * Default constructor
     */
    public ActionBase() {
        super();
    }

    /**
     * Get menu information
     * @param request HttpServletRequest
     * @return List<MenuDTO>
     * @throws Exception
     */
    public List<MenuDTO> getMenu(HttpServletRequest request) throws Exception {
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(((HttpServletRequest) request).getSession().getServletContext());
        MenuDAO menuDAO = (MenuDAO) ctx.getBean("menuDAO");
        List<MenuDTO> lsMenu = null;

        lsMenu = menuDAO.getAllMenu();

        return lsMenu;
    }
}
