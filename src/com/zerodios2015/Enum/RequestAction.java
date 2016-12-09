/**
 * Copyright(C) ZeroDios2015
 *
 * RequestAction.java, Nov 28, 2016
 * @author: HaVH
 *
 */
package com.zerodios2015.Enum;

/**
 * @author HaVH
 *
 */
public enum RequestAction {

    /**
     * Action add
     */
    ADD(0),
    /**
     * Action update
     */
    UPDATE(1),
    /**
     * Action delete
     */
    DELETE(2);

    public final int value;

    RequestAction(int value) {
        this.value = value;
    }
}
