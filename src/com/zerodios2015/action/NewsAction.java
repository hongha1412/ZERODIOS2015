/**
 * Copyright(C) ZeroDios2015
 *
 * NewsAction.java, Nov 4, 2015 
 * @author: HaVH-PC
 *
 */
package com.zerodios2015.action;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zerodios2015.DAO.NewsDAO;
import com.zerodios2015.DTO.NewsDTO;
import com.zerodios2015.Utils.ZDLogUtils;
import com.zerodios2015.Utils.ZDStringUtils;
import com.zerodios2015.VO.NewsOutVO;
import com.zerodios2015.form.NewsForm;

/**
 * 
 * @author HaVH-PC
 *
 */
public class NewsAction extends ActionBase {

    public NewsAction() {
        super();
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        NewsForm newsForm = (NewsForm) form;
        NewsDTO newsDTO = new NewsDTO();

        if (newsForm == null) {
            newsForm = new NewsForm();
        }
        try {
            BeanUtils.copyProperties(newsDTO, newsForm);
        } catch (IllegalAccessException e) {
            ZDLogUtils.log(Level.WARNING, this, e, ZDStringUtils.EMPTY);
        } catch (InvocationTargetException e) {
            ZDLogUtils.log(Level.WARNING, this, e, ZDStringUtils.EMPTY);
        }

        NewsOutVO outVO = new NewsOutVO();

        try {
            outVO.setLsMenu(getMenu(request));
            outVO.setLsNews(getNews(request));
        } catch (Exception e) {
            ZDLogUtils.log(Level.WARNING, this, e, ZDStringUtils.EMPTY);
        }
        request.setAttribute("outVO", outVO);

        return mapping.findForward("news");
    }

    public List<NewsDTO> getNews(HttpServletRequest request) throws Exception {
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(((HttpServletRequest) request).getSession().getServletContext());
        NewsDAO newsDAO = (NewsDAO) ctx.getBean("newsDAO");
        List<NewsDTO> lsNews = null;

        lsNews = newsDAO.getNews(null, ZDStringUtils.EMPTY, Integer.MAX_VALUE, 0);

        return lsNews;
    }
}
