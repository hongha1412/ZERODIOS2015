/**
 * Copyright(C) ZeroDios2015
 *
 * ActionBaseInterface.java, 2016/10/03
 * @author: HaVH
 *
 */
package com.zerodios2015.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author HaVH
 *
 */
public interface ActionBaseInterface {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response);
}
