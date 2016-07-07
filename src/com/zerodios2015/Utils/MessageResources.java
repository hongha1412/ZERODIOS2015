/**
 * Copyright(C) ZeroDios2015
 *
 * MessageResources.java, Jun 28, 2016
 * @author: HaVH
 *
 */
package com.zerodios2015.Utils;

import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 * @author HaVH
 *
 */
public class MessageResources extends ResourceBundle {

    /* (non-Javadoc)
     * @see java.util.ResourceBundle#getKeys()
     */
    @Override
    public Enumeration<String> getKeys() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /* (non-Javadoc)
     * @see java.util.ResourceBundle#handleGetObject(java.lang.String)
     */
    @Override
    protected Object handleGetObject(String key) {
        return MessageProperties.getMessage(key);
    }

}
