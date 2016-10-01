/**
 * Copyright(C) ZeroDios2015
 *
 * AdmLoginForm.java, Sep 28, 2016
 * @author: hongha1412
 *
 */
package com.zerodios2015.form;

import org.apache.struts.action.ActionForm;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author HaVH-PC
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class AdmLoginForm extends ActionForm {

    /**
     * long
     */
    private static final long serialVersionUID = 1L;

    public String email;

    public String password;
}
