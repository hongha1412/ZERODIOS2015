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

import com.zerodios2015.DAO.CategoryDAO;
import com.zerodios2015.DTO.CategoryDTO;
import com.zerodios2015.Utils.ZDLogUtils;
import com.zerodios2015.Utils.ZDUtils;

/**
 * Servlet implementation class CategoryServlet
 */
public class CategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(((HttpServletRequest) request).getSession().getServletContext());
        CategoryDAO cateDao = (CategoryDAO) ctx.getBean("categoryDAO");
        int limit = -1, offset = -1;
        PrintWriter out = response.getWriter();
        CategoryDTO cateDTO = new CategoryDTO();

        if (request.getParameter("condition") != null) {
            try {
                cateDTO.loadFromJSON(request.getParameter("condition"));
            } catch (IllegalArgumentException | IllegalAccessException | JSONException e) {
                ZDLogUtils.log(Level.WARNING, this, e, e.getMessage());
            }
        }

        limit = ZDUtils.isEmpty(request.getParameter("limit")) ? -1 : Integer.parseInt(request.getParameter("limit").toString());
        offset = ZDUtils.isEmpty(request.getParameter("offset")) ? -1 : Integer.parseInt(request.getParameter("offset").toString());

        List<CategoryDTO> categories = new ArrayList<>();
        try {
            categories = cateDao.getCategories(cateDTO, offset, limit);
        } catch (Exception e) {
            ZDLogUtils.log(Level.WARNING, this, e, e.getMessage());
        }

        out.print(ZDUtils.toJSON(categories));
        out.flush();
    }

}
