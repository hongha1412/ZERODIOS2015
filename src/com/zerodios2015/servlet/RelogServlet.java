package com.zerodios2015.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zerodios2015.DAO.AccountDAO;
import com.zerodios2015.DTO.AccountDTO;
import com.zerodios2015.DTO.MessageObject;
import com.zerodios2015.Utils.ControlName;
import com.zerodios2015.Utils.MessageProperties;
import com.zerodios2015.Utils.ZDLogUtils;
import com.zerodios2015.Utils.ZDStringUtils;

/**
 * Servlet implementation class LogoutServlet
 */
public class RelogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String ERROR_PAGE = "/error.do";
    private final String LOGIN_PAGE = "/adm/Login.do";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelogServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountDTO accountInfo = (AccountDTO) request.getSession().getAttribute("accountInfo");
        if (accountInfo != null) {
            if (!ZDStringUtils.isEmpty(accountInfo.getEmail())) {
                if (request.getParameter("relogpassword") != null) {
                    String password = request.getParameter("relogpassword").toString();
                    List<MessageObject> messages = new ArrayList<>();

                    // validate password
                    if (ZDStringUtils.isEmpty(password)) {
                        messages.add(new MessageObject(ZDStringUtils.formatMessageResource("msg.empty", "adm.Password"), ControlName.PASSWORD));
                    } else if (password.length() < 6 || 
                            password.toString().length() > 15) {
                        messages.add(new MessageObject(ZDStringUtils.formatMessageResource("msg.lengthinvalid", "6", "15"), ControlName.PASSWORD));
                    }

                    
                    PrintWriter out = response.getWriter();
                    if (messages.size() <= 0) {
                        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
                        AccountDAO dao = (AccountDAO) ctx.getBean("accountDAO");
    
                        String userId = "";
                        try {
                            userId = dao.checkLogin(accountInfo.getEmail(), request.getParameter("relogpassword").toString());
                            if (!ZDStringUtils.isEmpty(userId)) {
                                accountInfo.setId(userId);
                                request.getSession().setAttribute("accountInfo", accountInfo);
                                out.println("success");
                                out.flush();
                                return;
                            } else {
                                messages.add(new MessageObject(MessageProperties.getMessage("msg.loginfail"), ZDStringUtils.EMPTY));
                            }
                        } catch (Exception e) {
                            ZDLogUtils.log(Level.WARNING, this, e, e.getMessage());
                        }
                    }

                    out.println(ZDStringUtils.toJSON(messages));
                    out.flush();
                    return;
                }
            }
            response.sendRedirect(ERROR_PAGE);
        } else {
            response.sendRedirect(LOGIN_PAGE);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
