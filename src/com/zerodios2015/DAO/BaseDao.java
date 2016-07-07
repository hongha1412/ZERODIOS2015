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

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.zerodios2015.Utils.ZDStringUtils;

/**
 * 
 * @author HaVH-PC
 *
 */
public class BaseDao extends JdbcDaoSupport {
    public BaseDao() {
        super();
    }

    /**
     * Create where statement from object's property
     * 
     * @param o Object query condition
     * @param sqlParameter List<Object> query parameter
     * @return String query string
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public String toQuery(Object o, List<Object> sqlParameter) 
            throws IllegalArgumentException, IllegalAccessException {

        // Check null object
        if (o == null) {
            return "";
        }

        StringBuilder query = new StringBuilder("WHERE ");
        // Loop in object's properties
        for(Field f : o.getClass().getDeclaredFields()) {

            // Set access permission for this field
            f.setAccessible(true);
            // If this property not empty or null
            if (!ZDStringUtils.isEmpty(f.get(o))) {

                // Check for add comma
                if (!query.toString().trim().equals("WHERE")) {
                    query.append(",");
                }
                query.append("    ").append(f.getName().toUpperCase());
                // Check type of property 
                if (String.class.isAssignableFrom(f.getType())) {
                    query.append(" LIKE ? ");
                } else if (Integer.class.isAssignableFrom(f.getType()) || 
                        Date.class.isAssignableFrom(f.getType())) {
                    query.append(" = ? ");
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
}
