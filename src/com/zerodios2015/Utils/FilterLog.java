/**
 * Copyright(C) ZeroDios2015
 *
 * FilterLogin.java, 2016/07/15
 * @author: HaVH
 *
 */
package com.zerodios2015.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zerodios2015.DTO.AccountDTO;
import com.zerodios2015.DTO.MessageObject;

/**
 * @author HaVH
 *
 */
public class FilterLog implements Filter {

    private ServletContext context;
    private final String LOGIN_URL = "/adm/Login.do";
    private final String RELOG_URL = "/adm/relog";
    private final String LOGOUT_URL = "adm/Logout.do";

    /* (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        this.context = config.getServletContext();

        String testParam = config.getInitParameter("Test");
        this.context.log(testParam);
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();
        if (requestURI.toLowerCase().startsWith("/adm") && !requestURI.toLowerCase().contains(LOGIN_URL.toLowerCase()) &&
                !requestURI.toLowerCase().contains(RELOG_URL.toLowerCase()) && !requestURI.toLowerCase().contains(LOGOUT_URL.toLowerCase())) {
            HttpSession session = req.getSession();
            AccountDTO accountInfo = (AccountDTO) session.getAttribute("accountInfo");
            if (accountInfo == null || ZDUtils.isEmpty(accountInfo.getId())) {
                List<MessageObject> messages = new ArrayList<>();
                messages.add(new MessageObject("Please login first", ZDUtils.EMPTY));
                session.setAttribute("sessionMessage", messages);
                ((HttpServletResponse)response).sendRedirect(LOGIN_URL);
                // RequestDispatcher dispatcher = request.getRequestDispatcher(LOGIN_URL);
                // dispatcher.forward(request, response);
                return;
            }
        }
        if (requestURI.endsWith(".do") || !requestURI.substring(requestURI.lastIndexOf("/")).contains(".")) {
            this.context.log("[" + ZDUtils.formatDate(new Date()) + "] " + req.getRemoteAddr() + " Requested to " + req.getRequestURI());
        }

        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
    }
}
