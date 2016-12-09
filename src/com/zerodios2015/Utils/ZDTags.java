/**
 * Copyright(C) ZeroDios2015
 *
 * ZDTags.java, 2016/07/11
 * @author: HaVH
 *
 */
package com.zerodios2015.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author HaVH
 *
 */
public class ZDTags extends SimpleTagSupport {

    private String tableName;

    /**
     * @param tableName the tableName to set
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    private String align;

    /**
     * @param align the align to set
     */
    public void setAlign(String align) {
        this.align = align;
    }

    /**
     * Default constructor
     */
    public ZDTags() {
        super();
    }

    @Override
    public void doTag() throws JspException, IOException {

        JspWriter out = getJspContext().getOut();
        String listHeader = TableProperties.getMessage(tableName);
        String listHidden = TableProperties.getMessage(tableName + ".hidden");

        if (ZDUtils.isNotEmpty(listHeader)) {
            List<String> lsHeader = Arrays.asList(listHeader.split(","));
            List<String> lsHidden = new ArrayList<>();

            if (ZDUtils.isNotEmpty(listHidden)) {
                lsHidden = Arrays.asList(listHidden.split(","));
            }

            StringBuilder headerStr = new StringBuilder();
            for (String header : lsHeader) {
                if (lsHidden.contains(header)) {
                    headerStr.append("<th class='hidden text-header dt-head-" + align + "'>");
                } else {
                    headerStr.append("<th class='text-header dt-head-" + align + "'>");
                }
                headerStr.append(header + "</th>");
            }
            out.println("<thead><tr>" + headerStr.toString() + "</tr></thead>");
            out.println("<tfoot><tr>" + headerStr.toString() + "</tr></tfoot>");
        }
    }
}
