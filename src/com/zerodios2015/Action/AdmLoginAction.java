/**
 * Copyright(C) ZeroDios2015
 *
 * AdmLoginAction.java, 2016/09/29
 * @author: HaVH
 *
 */
package com.zerodios2015.Action;

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
import com.zerodios2015.Form.AdmLoginForm;
import com.zerodios2015.Utils.ControlName;
import com.zerodios2015.Utils.MessageProperties;
import com.zerodios2015.Utils.ZDLogUtils;
import com.zerodios2015.Utils.ZDUtils;

/**
 * @author HaVH
 *
 */
public class AdmLoginAction extends Action implements ActionBaseInterface {

    private final String GET_METHOD = "GET";
    private final String ADM_LOGIN = "admLogin";
    private final String ADM_DASHBOARD = "admDashboard";

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        String resultPage = ADM_LOGIN;
        // String msgJSON = ZDException.ZD_DEFAULT_EXCEPTION;

        List<MessageObject> messages = new ArrayList<>();
        if (GET_METHOD.equals(request.getMethod())) {
            if (request.getSession().getAttribute("accountInfo") != null &&
                    (!ZDUtils.isEmpty(((AccountDTO)request.getSession().getAttribute("accountInfo")).getId()))) {
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
        if (ZDUtils.isEmpty(loginForm.getEmail())) {
            messages.add(new MessageObject(ZDUtils.formatMessageResource("msg.empty", "adm.Email"), ControlName.EMAIL));
        } else if (!ZDUtils.validateEmail(loginForm.getEmail())) {
            messages.add(new MessageObject(ZDUtils.formatMessageResource("msg.formatinvalid", "adm.Email"), ControlName.EMAIL));
        }
        // Validate password
        if (ZDUtils.isEmpty(loginForm.getPassword())) {
            messages.add(new MessageObject(ZDUtils.formatMessageResource("msg.empty", "adm.Password"), ControlName.PASSWORD));
        } else if (loginForm.getPassword().length() < 6 || 
                loginForm.getPassword().toString().length() > 15) {
            messages.add(new MessageObject(ZDUtils.formatMessageResource("msg.lengthinvalid", "6", "15"), ControlName.PASSWORD));
        }

        if (messages.size() <= 0) {
            ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(((HttpServletRequest) request).getSession().getServletContext());
            AccountDAO dao = (AccountDAO) ctx.getBean("accountDAO");

            try {
                String userId = dao.checkLogin(loginForm.getEmail(), loginForm.getPassword());
                if (ZDUtils.isEmpty(userId)) {
                    messages.add(new MessageObject(MessageProperties.getMessage("msg.loginfail"), ZDUtils.EMPTY));
                } else {
                    AccountDTO accountInfo = dao.getAccountInfo(userId);
                    if (accountInfo == null || ZDUtils.isEmpty(accountInfo.getId())) {
                        messages.add(new MessageObject(MessageProperties.getMessage("msg.accountfail"), ZDUtils.EMPTY));
                    } else {
                        request.getSession().setAttribute("accountInfo", accountInfo);
                        resultPage = ADM_DASHBOARD;
                    }
                }
            } catch (Exception e) {
                ZDLogUtils.log(Level.WARNING, this, e, e.getMessage());
                messages.add(new MessageObject(MessageProperties.getMessage("msg.unknowerror"), ZDUtils.EMPTY));
            }
        }

//        try {
//            msgJSON = ZDStringUtils.toJSON(messages);
//        } catch (IOException e) {
//            ZDLogUtils.log(Level.WARNING, this, e, e.getMessage());
//        }
        request.setAttribute("messages", messages);

        return mapping.findForward(resultPage);
    }
}
