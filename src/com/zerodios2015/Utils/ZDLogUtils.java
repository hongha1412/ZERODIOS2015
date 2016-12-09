/**
 * Copyright(C) ZeroDios2015
 *
 * ZDLogUtils.java, Jul 7, 2016
 * @author: HaVH
 *
 */
package com.zerodios2015.Utils;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author HaVH
 *
 */
public class ZDLogUtils {

    public ZDLogUtils() {
        super();
    }

    public static void log(Level level, Object o, Exception e, String message) {
        if (ZDUtils.isEmpty(message)) {
            Logger.getGlobal().log(level, ZDUtils.formatDate(new Date()) + " Exception occur at " + o.getClass().getName() + ": " + e.getMessage());
        } else {
            Logger.getGlobal().log(level, ZDUtils.formatDate(new Date()) + " Exception occur at " + o.getClass().getName() + ": " + message);
        }

        e.printStackTrace();
    }
}
