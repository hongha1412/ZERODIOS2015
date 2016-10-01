/**
 * Copyright(C) ZeroDios2015
 *
 * MessageObject.java, 2016/09/29
 * @author: HaVH
 *
 */
package com.zerodios2015.DTO;

import lombok.Data;

/**
 * @author HaVH
 *
 */
@Data
public class MessageObject {

    private String message;
    private String controlName;

    public MessageObject() {
        this.message = "";
        this.controlName = "";
    }

    /**
     * Contructor with param
     * 
     * @param message
     * @param controlName
     */
    public MessageObject(String message, String controlName) {
        this.message = message;
        this.controlName = controlName;
    }
}
