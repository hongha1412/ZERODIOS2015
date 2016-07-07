/**
 * Copyright(C) ZeroDios2015
 *
 * InformationForm.java, Oct 8, 2015 
 * @author: HaVH-PC
 *
 */
package com.zerodios2015.form;

import org.apache.struts.action.ActionForm;

/**
 * 
 * @author HaVH-PC
 *
 */
public class InformationForm extends ActionForm {
    /**
     * 
     */
    private static final long serialVersionUID = -52927953770405444L;

    private String name;
    private String age;
    private String address;

    public InformationForm() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
