/**
 * Copyright(C) ZeroDios2015
 *
 * BaseDao.java, Oct 8, 2015 
 * @author: HaVH-PC
 *
 */
package com.zerodios2015.DAO;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.zerodios2015.Utils.ZDLogUtils;
import com.zerodios2015.Utils.ZDUtils;

/**
 * 
 * @author HaVH-PC
 *
 */
public class BaseDAO extends JdbcDaoSupport {

    List<Object> sqlParameter;
    StringBuilder sqlCommand;

    public BaseDAO() {
        super();
    }

    /**
     * Create where statement from object's property
     * 
     * @param o Object query condition
     * @param sqlParameter List<Object> query parameter
     * @param prefix alias of table
     * @return String query string
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public String toConditionQuery(Object o, List<Object> sqlParameter, String prefix) 
            throws IllegalArgumentException, IllegalAccessException {

        // Check null object
        if (o == null) {
            return ZDUtils.EMPTY;
        }

        StringBuilder query = new StringBuilder("WHERE ");
        // Loop in object's properties
        for(Field f : o.getClass().getDeclaredFields()) {

            // Set access permission for this field
            f.setAccessible(true);
            // If this property not empty or null
            // if (!ZDStringUtils.isEmpty(f.get(o)) && !f.getType().equals(boolean.class) && Integer.parseInt(f.get(o).toString()) != -1) {
            if (!ZDUtils.isEmpty(f.get(o))) {

                // Check for add comma
                if (!query.toString().trim().equals("WHERE")) {
                    query.append("AND ");
                }
                query.append("    ").append(ZDUtils.isEmpty(prefix) ? "" : prefix + ".").append(f.getName().toUpperCase());
                // Check type of property 
                if (String.class.isAssignableFrom(f.getType())) {
                    query.append(" LIKE '%?%' ");
                } else if (Integer.class.isAssignableFrom(f.getType()) || 
                        Date.class.isAssignableFrom(f.getType())) {
                    query.append(" = ? ");
                } else if (boolean.class.isAssignableFrom(f.getType())) {
                    continue;
                } else {
                    query.append(" = ? ");
                }
                // Add value to list parameter
                sqlParameter.add(f.get(o));
            }
        }

        // If query have no parameter
        if (query.toString().trim().equals("WHERE")) {
            query = new StringBuilder();
        }

        return query.toString();
    }

    /**
     * Create where statement from object's property<br/>
     * If object's property is null, skip that condition
     * 
     * @param o Object query condition
     * @param sqlParameter List<Object> query parameter
     * @param prefix alias of table
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public String toConditionQuery(Object o, List<Object> sqlParameter) throws IllegalArgumentException, IllegalAccessException {
        return toConditionQuery(o, sqlParameter, null);
    }

    /**
     * Create Set clause for update statement
     * 
     * @param Object
     * @param sqlParameter
     * @return Set clause for update
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     * @throws NumberFormatException 
     */
    public String toSetQuery(Object o, List<Object> sqlParameter) throws NumberFormatException, IllegalArgumentException, IllegalAccessException {

        StringBuilder query = new StringBuilder();
        for(Field f : o.getClass().getDeclaredFields()) {

            // Set access permission for this field
            f.setAccessible(true);
            // If this property not empty or null
            if (!ZDUtils.isEmpty(f.get(o))) {
                if (query.indexOf("SET") < 0) {
                    query.append("SET ");
                }
                query.append(f.getName().toUpperCase());
                query.append(" = ?, ");
                // Add value to list parameter
                sqlParameter.add(f.get(o));
            }
        }
        return query.substring(0, query.length() - 2).toString();
    }

    /**
     * Parse map to object 
     * 
     * @param data
     * @param object
     * @return Object
     */
    public Object parseObject(Map<String, Object> data, Object object) {
        Object rs = null;
        Class<?> c = object.getClass();

        try {
            rs = c.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            ZDLogUtils.log(Level.WARNING, this, ex, ex.getMessage());
            return rs;
        }

        for (String key : data.keySet()) {
            while (c != null) {
                try {
                    Field f = c.getDeclaredField(key.toLowerCase());
                    f.setAccessible(true);
                    f.set(rs, f.getType().cast(data.get(key).toString()));
                    break;
                } catch (NoSuchFieldException nsfe) {
                    // c = c.getSuperclass();
                    break;
                } catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
                    ZDLogUtils.log(Level.WARNING, this, e, e.getMessage());
                }
            }
        }
        return rs;
    }
}
