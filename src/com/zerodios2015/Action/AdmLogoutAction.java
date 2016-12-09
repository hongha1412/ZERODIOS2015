/**
 * Copyright(C) ZeroDios2015
 *
 * AdmLogoutAction.java, 2016/10/03
 * @author: HaVH
 *
 */
package com.zerodios2015.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zerodios2015.DTO.AccountDTO;
import com.zerodios2015.Utils.ZDUtils;

/**
 * @author HaVH
 *
 */
public class AdmLogoutAction extends Action implements ActionBaseInterface {

    private final String SUCCESS_PAGE = "success";
    private final String FAIL_PAGE = "fail";

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        String resultPage = FAIL_PAGE;

        AccountDTO accountInfo = (AccountDTO) request.getSession().getAttribute("accountInfo");
        if (accountInfo != null && !ZDUtils.isEmpty(accountInfo.getId())) {
            accountInfo = new AccountDTO(accountInfo.getName(), accountInfo.getEmail());
            request.getSession().setAttribute("accountInfo", accountInfo);
            resultPage = SUCCESS_PAGE;
        }

        return mapping.findForward(resultPage);
    }
}
