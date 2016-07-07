/**
 * Copyright(C) ZeroDios2015
 *
 * ZDStringUtils.java, Nov 7, 2015 
 * @author: HaVH-PC
 *
 */
package com.zerodios2015.Utils;

/**
 * 
 * @author HaVH-PC
 *
 */
public class ZDStringUtils {
    public static boolean isEmpty(Object str) {
        boolean result = false;

        if (str == null || str.toString().length() <= 0) {
            result = true;
        }

        return result;
    }

    public static boolean isNotEmpty(Object str) {
        return !isEmpty(str);
    }

    public static boolean isInteger(Object str) {
        if (isEmpty(str)) {
            return false;
        }

        try { 
            Integer.parseInt(str.toString()); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }

        return true;
    }

    public static boolean isNotInteger(Object str) {
        return !isInteger(str);
    }
}
