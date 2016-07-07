/**
 * Copyright(C) ZeroDios2015
 *
 * InformationAction.java, Oct 8, 2015 
 * @author: HaVH-PC
 *
 */
package com.zerodios2015.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zerodios2015.DAO.InformationDAO;
import com.zerodios2015.DTO.InformationDTO;
import com.zerodios2015.form.InformationForm;

/**
 * 
 * @author HaVH-PC
 *
 */
public class InformationAction extends Action {
    public InformationAction() {
        super();
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        InformationForm inputForm = (InformationForm) form;
        InformationDTO informationDTO = new InformationDTO();
        BeanUtils.copyProperties(informationDTO, inputForm);
        if (addInformation(informationDTO, request)) {
            System.out.println("Name : " + inputForm.getName() + " Age : " + inputForm.getAge() + " Address : "
                    + inputForm.getAddress());
            return mapping.findForward("success");
        }

        return mapping.findForward("fail");
    }

    private boolean addInformation(InformationDTO informationDTO, HttpServletRequest request) {
        ApplicationContext ctx = WebApplicationContextUtils
                .getWebApplicationContext(((HttpServletRequest) request).getSession().getServletContext());
        InformationDAO informationDAO = (InformationDAO) ctx.getBean("infoDAO");
        try {
            if (!informationDAO.addInformation(informationDTO)) {
                System.out.println("Insert data fail");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        System.out.println("Insert data success");
        return true;
    }
}
