package com.zerodios2015.Servlet;

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
import com.zerodios2015.DTO.AccountDTO;
import com.zerodios2015.DTO.NewsDTO;
import com.zerodios2015.Enum.RequestAction;
import com.zerodios2015.Utils.MessageProperties;
import com.zerodios2015.Utils.ZDException;
import com.zerodios2015.Utils.ZDLogUtils;
import com.zerodios2015.Utils.ZDUtils;

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        long start = System.currentTimeMillis();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(((HttpServletRequest) request).getSession().getServletContext());
        NewsDAO newsDAO = (NewsDAO) ctx.getBean("newsDAO");
        NewsDTO condition = new NewsDTO();
        PrintWriter out = response.getWriter();
        request.getAttribute("action");

        if (!ZDUtils.isEmpty(request.getParameter("action"))) {
            if (request.getParameter("condition") == null || request.getParameter("newsid") == null) {
                return;
            }

            try {
                condition.loadFromJSON(request.getParameter("condition"));
            } catch (IllegalArgumentException | IllegalAccessException | JSONException e) {
                ZDLogUtils.log(Level.WARNING, this, e, e.getMessage());
            }

            if (Integer.valueOf(request.getParameter("action")) == RequestAction.UPDATE.value) {
                condition.setAuthor(null);
                condition.setId(null);
                condition.setVersion(condition.getVersion() + 1);
                out.print(this.editNews(newsDAO, Integer.parseInt(request.getParameter("newsid").trim()), condition));
            } else if (Integer.valueOf(request.getParameter("action")) == RequestAction.ADD.value) {
                condition.setAuthor(((AccountDTO) request.getSession().getAttribute("accountInfo")).getId());
                out.print(this.addNews(newsDAO, condition));
            } else {
                response.sendRedirect("/error.do");
                return;
            }
            out.flush();
//            System.out.println("Execute time branch 1: " + (System.currentTimeMillis() - start));
            return;
        }

        if (!ZDUtils.isEmpty(request.getParameter("condition"))) {
            try {
                condition.loadFromJSON(request.getParameter("condition"));
            } catch (IllegalArgumentException | IllegalAccessException | JSONException e) {
                ZDLogUtils.log(Level.WARNING, this, e, e.getMessage());
            }
        }

        List<NewsDTO> lsNews = new ArrayList<>();
        int limit = -1, offset = -1;

        limit = ZDUtils.isEmpty(request.getParameter("limit")) ? -1 : Integer.parseInt(request.getParameter("limit").toString());
        offset = ZDUtils.isEmpty(request.getParameter("offset")) ? -1 : Integer.parseInt(request.getParameter("offset").toString());

        try {
            lsNews = newsDAO.getNews(condition, limit, offset);
        } catch (Exception e) {
            ZDLogUtils.log(Level.WARNING, this, e, e.getMessage());
        }
//        System.out.println("Execute time branch 2: " + (System.currentTimeMillis() - start));

        out.print(ZDUtils.toJSON(lsNews));
        out.flush();
    }

    /**
     * Update news information
     * 
     * @param newsDAO
     * @param id
     * @param NewsDTO
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

    /**
     * Add news
     * 
     * @param newsDAO
     * @param NewsDTO
     * @return Add result message
     */
    private String addNews(NewsDAO newsDAO, NewsDTO object) {
        Integer id = newsDAO.getIdForAdd();
        String rt = MessageProperties.getMessage("news.updatenewsfail");

        if (id != null & id > 0) {
            object.setId(id);
            try {
                if (newsDAO.addNews(object)) {
                    rt = MessageProperties.getMessage("global.success");
                }
            } catch (ZDException e) {
                ZDLogUtils.log(Level.WARNING, this, e, e.getMessage().toString());
            } catch (Exception e) {
                ZDLogUtils.log(Level.WARNING, this, e, e.getCause().toString());
            }
        }

        return rt;
    }

}
