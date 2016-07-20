/**
 * Copyright(C) ZeroDios2015
 *
 * FilterLogin.java, 2016/07/15
 * @author: HaVH
 *
 */
package com.zerodios2015.Utils;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author HaVH
 *
 */
public class FilterLog implements Filter {

    private ServletContext context;

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

        HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();
        if (requestURI.endsWith(".do") || !requestURI.substring(requestURI.lastIndexOf("/")).contains(".")) {
            this.context.log(new Date() + " " + req.getRemoteAddr() + " Requested to " + req.getRequestURI());
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
