/**
 * Copyright(C) ZeroDios2015
 *
 * ZDStringUtils.java, Nov 7, 2015 
 * @author: HaVH-PC
 *
 */
package com.zerodios2015.Utils;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.lang.StringEscapeUtils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author HaVH-PC
 *
 */
public class ZDUtils {

    public static final String EMPTY = "";

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

    /**
     * Convert mysql object date to java.util.Date
     * 
     * @param o Mysql Object Date
     * @return java.util.Date
     */
    public static Date toDate(Object o) {
        Date date = new Date();
        date = (java.sql.Timestamp) o;
        return date;
    }

    /**
     * Format java.util.Date to string yyyy/MM/dd hh:mm:ss
     * 
     * @param time
     * @return
     */
    public static String formatDate(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        return sdf.format(time);
    }

    /**
     * Validate string email format
     * 
     * @param email
     * @return <b>true</b>: email format valid / <b>false</b>: email format invalid
     */
    public static boolean validateEmail(String email) {
        boolean rs = true;
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
        } catch (AddressException e) {
            rs = false;
        }
        return rs;
    }

    /**
     * Create message string with resource text
     * 
     * @param resourceNameId
     * @param resourceMessageId
     * @return message string
     */
    public static String formatMessageResource(String resourceMessageIds, String... params) {
        List<String> messages = new ArrayList<>();
        for (String param : params) {
            if (param.startsWith("\\")) {
                messages.add(param.replace("\\", ""));
            } else {
                messages.add(MessageProperties.getMessage(param));
            }
        }
        return String.format(MessageProperties.getMessage(resourceMessageIds), messages.toArray());
    }
    
    /**
     * Convert object to JSON String
     * 
     * @param o Object to convert
     * @return JSON String
     * @throws IOException 
     */
    public static String toJSON(Object o) throws IOException {
        if (o == null ||
                (o.getClass().equals(ArrayList.class) && ((ArrayList<?>)o).size() <= 0)) {
            return null;
        }

        StringWriter writer = new StringWriter();
        JsonGenerator jgen = new JsonFactory().createGenerator(writer);
        jgen.setCodec(new ObjectMapper());
        jgen.writeObject(o);
        jgen.close();
        String rs = writer.toString().trim(); //.replace("\"", "\\\""); //.replace("\\", "\\\\");
        return rs.trim();
    }

    /**
     * Encode unicode string for save to database
     * 
     * @param str
     * @return
     */
    public static String escapeDB(String str) {
        return isEmpty(str) ? EMPTY : StringEscapeUtils.escapeJava(str);
    }

    /**
     * Decode unicode database string for view
     * 
     * @param str
     * @return
     */
    public static String unEscapeDB(String str) {
        return isEmpty(str) ? EMPTY : StringEscapeUtils.unescapeJava(str);
    }
}
