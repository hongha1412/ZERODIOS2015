/**
 * Copyright(C) ZeroDios2015
 *
 * ZDException.java, Nov 7, 2015 
 * @author: HaVH-PC
 *
 */
package com.zerodios2015.Utils;

/**
 * 
 * @author HaVH-PC
 *
 */
public class ZDException extends Exception {
    /**
     * long
     */
    private static final long serialVersionUID = 1L;

    public ZDException() {
        super();
    }

    public ZDException(String message) {
        super(message);
    }

    public static final String ZD_DEFAULT_EXCEPTION = "{'message': '" + MessageProperties.getMessage("msg.unknowerror") + "', 'controlName' : ''}";
    public static final String ZDNEWSEXCEPTION001 = "Lỗi query database (getNews)";
    public static final String ZDNEWSEXCEPTION002 = "Lỗi database (getNews)";
    public static final String ZDNEWSEXCEPTION003 = "News Id exists";
}
