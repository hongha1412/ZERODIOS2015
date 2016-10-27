/**
 * Copyright(C) ZeroDios2015
 *
 * NewsDTO.java, Nov 4, 2015 
 * @author: HaVH-PC
 *
 */
package com.zerodios2015.DTO;

import java.util.Date;

import com.zerodios2015.Utils.ZDStringUtils;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author HaVH-PC
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class NewsDTO extends BaseFormDTO {

    /**
     * News id int
     */
    private int id;

    /**
     * News category int
     */
    private int category;

    /**
     * News title String
     */
    private String title;

    /**
     * News content String
     */
    private String description;

    /**
     * Author String
     */
    private String author;

    /**
     * Posted date Date
     */
    private String date;

    /**
     * News remark int
     */
    private int remark;

    /**
     * Is this pin news int
     */
    private boolean pin;

    /**
     * Is this enws available int
     */
    private int status;

    /**
     * Version long
     */
    private long version;

    /**
     * Default constructor
     */
    public NewsDTO() {
        this.id = -1;
        this.author = "";
        this.category = -1;
        this.status = -1;
        this.remark = -1;
        this.version = -1;
    }

    /**
     * Constructor with status
     * 
     * @param status
     */
    public NewsDTO(int status) {
        this.id = -1;
        this.author = "";
        this.category = -1;
        this.status = status;
        this.remark = -1;
        this.version = -1;
    }

    /**
     * Constructor full parameter
     * 
     * @param id
     * @param category
     * @param title
     * @param description
     * @param author
     * @param date
     * @param remark
     * @param pin
     * @param status
     * @param version
     */
    public NewsDTO(int id, int category, String title, String description, String author, Date date, int remark, boolean pin,
            int status, long version) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.description = description;
        this.author = author;
        this.date = ZDStringUtils.formatDate(date);
        this.remark = remark;
        this.pin = pin;
        this.status = status;
        this.version = version;
    }

    /**
     * Constructor full object parameter
     * 
     * @param id
     * @param category
     * @param title
     * @param description
     * @param author
     * @param date
     * @param remark
     * @param pin
     * @param status
     * @param version
     */
    public NewsDTO(Object id, Object category, Object title, Object description, Object author, Object date,
            Object remark, Object pin, Object status, Object version) {
        this.id = Integer.parseInt(id.toString());
        this.category = Integer.parseInt(category.toString());
        this.title = title.toString();
        this.description = description.toString();
        this.author = author.toString();
        this.date = ZDStringUtils.formatDate(ZDStringUtils.toDate(date));
        this.remark = Integer.parseInt(remark.toString());
        this.pin = (boolean)pin;
        this.status = (int)status;
        this.version = Long.parseLong(version.toString());
    }
}
