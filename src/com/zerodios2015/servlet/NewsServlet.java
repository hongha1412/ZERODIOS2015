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

import org.json.JSONException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zerodios2015.DAO.NewsDAO;
import com.zerodios2015.DTO.NewsDTO;
import com.zerodios2015.Utils.MessageProperties;
import com.zerodios2015.Utils.ZDLogUtils;
import com.zerodios2015.Utils.ZDStringUtils;

/**
 * Servlet implementation class NewsServlet
 */
public class NewsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(((HttpServletRequest) request).getSession().getServletContext());
        NewsDAO newsDAO = (NewsDAO) ctx.getBean("newsDAO");
        NewsDTO condition = new NewsDTO();
        PrintWriter out = response.getWriter();

        if (!ZDStringUtils.isEmpty(request.getParameter("action"))) {
            if (request.getParameter("condition") == null || request.getParameter("newsid") == null) {
                return;
            }

            try {
                condition.loadFromJSON(request.getParameter("condition"));
            } catch (IllegalArgumentException | IllegalAccessException | JSONException e) {
                ZDLogUtils.log(Level.WARNING, this, e, e.getMessage());
            }

            if (request.getParameter("action").toLowerCase().equals("update")) {
                condition.setAuthor(null);
                condition.setId(null);
                condition.setVersion(condition.getVersion() + 1);
                out.println(this.editNews(newsDAO, Integer.parseInt(request.getParameter("newsid").trim()), condition));
            } else if (request.getParameter("action").toLowerCase().equals("add")) {
                out.println(this.addNews(newsDAO, condition));
            } else {
                response.sendRedirect("/error.do");
                return;
            }
            out.flush();
            return;
        }

        if (!ZDStringUtils.isEmpty(request.getParameter("condition"))) {
            try {
                condition.loadFromJSON(request.getParameter("condition"));
            } catch (IllegalArgumentException | IllegalAccessException | JSONException e) {
                ZDLogUtils.log(Level.WARNING, this, e, e.getMessage());
            }
        }

        List<NewsDTO> lsNews = new ArrayList<>();
        int limit = -1, offset = -1;

        limit = ZDStringUtils.isEmpty(request.getParameter("limit")) ? -1 : Integer.parseInt(request.getParameter("limit").toString());
        offset = ZDStringUtils.isEmpty(request.getParameter("offset")) ? -1 : Integer.parseInt(request.getParameter("offset").toString());

        try {
            lsNews = newsDAO.getNews(condition, ZDStringUtils.EMPTY, limit, offset);
        } catch (Exception e) {
            ZDLogUtils.log(Level.WARNING, this, e, e.getMessage());
            e.printStackTrace();
        }

        out.println(ZDStringUtils.toJSON(lsNews));
        out.flush();
    }

    /**
     * Update news information
     * 
     * @param newsDAO
     * @param id
     * @param object
     * @return Update result message
     */
    private String editNews(NewsDAO newsDAO, int id, NewsDTO object) {
        try {
            if (newsDAO.editNewsById(id, object)) {
                return MessageProperties.getMessage("global.success");
            }
            return MessageProperties.getMessage("news.updatenewsfail");
        } catch (Exception e) {
            ZDLogUtils.log(Level.WARNING, this, e, e.getCause().toString());
            return MessageProperties.getMessage("news.updatenewsfail");
        }
    }

    private String addNews(NewsDAO newsDAO, NewsDTO object) {
        return null;
    }

}
