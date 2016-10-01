/**
 * Copyright(C) ZeroDios2015
 *
 * AdmLoginAction.java, 2016/09/29
 * @author: HaVH
 *
 */
package com.zerodios2015.action;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zerodios2015.DAO.AccountDAO;
import com.zerodios2015.DTO.AccountDTO;
import com.zerodios2015.DTO.MessageObject;
import com.zerodios2015.Utils.ControlName;
import com.zerodios2015.Utils.MessageProperties;
import com.zerodios2015.Utils.ZDLogUtils;
import com.zerodios2015.Utils.ZDStringUtils;
import com.zerodios2015.Utils.ZeroPasswordHash;
import com.zerodios2015.form.AdmLoginForm;

/**
 * @author HaVH
 *
 */
public class AdmLoginAction extends Action {

    private final String GET_METHOD = "GET";
    private final String ADM_LOGIN = "admLogin";
    private final String ADM_DASHBOARD = "admDashboard";

    // public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        String resultPage = ADM_LOGIN;
        List<MessageObject> messages = new ArrayList<>();
        if (GET_METHOD.equals(request.getMethod())) {
            if (request.getSession().getAttribute("accountInfo") != null &&
                    (!ZDStringUtils.isEmpty(((AccountDTO)request.getSession().getAttribute("accountInfo")).getId()))) {
                resultPage = ADM_DASHBOARD;
            }
            return mapping.findForward(resultPage);
        }

        AdmLoginForm loginForm = (AdmLoginForm) form;
        AccountDTO loginDetail = new AccountDTO();
        if (loginForm == null) {
            loginForm = new AdmLoginForm();
        }
        BeanUtils.copyProperties(loginForm, loginDetail);

        // Validate email
        if (ZDStringUtils.isEmpty(loginForm.getEmail())) {
            messages.add(new MessageObject(ZDStringUtils.formatMessageResource("adm.Email", "msg.empty"), ControlName.EMAIL));
        } else if (!ZDStringUtils.validateEmail(loginForm.getEmail())) {
            messages.add(new MessageObject(ZDStringUtils.formatMessageResource("adm.Email", "msg.formatinvalid"), ControlName.EMAIL));
        }
        // Validate password
        if (ZDStringUtils.isEmpty(loginForm.getPassword())) {
            messages.add(new MessageObject(ZDStringUtils.formatMessageResource("adm.Password", "msg.empty"), ControlName.PASSWORD));
        } else if (loginForm.getPassword().length() < 6 || 
                loginForm.getPassword().toString().length() > 15) {
            messages.add(new MessageObject(ZDStringUtils.formatMessageResource("adm.Password", "6", "15"), ControlName.PASSWORD));
        }

        if (messages.size() <= 0) {
            ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(((HttpServletRequest) request).getSession().getServletContext());
            AccountDAO dao = (AccountDAO) ctx.getBean("accountDAO");

            try {
                String userId = dao.checkLogin(loginForm.getEmail(), ZeroPasswordHash.encrypt(loginForm.getPassword()));
                if (ZDStringUtils.isEmpty(userId)) {
                    messages.add(new MessageObject(MessageProperties.getMessage("msg.loginfail"), ""));
                } else {
                    AccountDTO accountInfo = dao.getAccountInfo(userId);
                    if (accountInfo == null || ZDStringUtils.isEmpty(accountInfo.getId())) {
                        messages.add(new MessageObject(MessageProperties.getMessage("msg.accountfail"), ""));
                    } else {
                        request.getSession().setAttribute("accountInfo", accountInfo);
                        resultPage = ADM_DASHBOARD;
                    }
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                ZDLogUtils.log(Level.WARNING, this, e, e.getMessage());
                messages.add(new MessageObject(MessageProperties.getMessage("msg.unknowerror"), ""));
            }
        }

        request.setAttribute("messages", messages);

        return mapping.findForward(resultPage);
    }
}