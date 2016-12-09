/**
 * Copyright(C) ZeroDios2015
 *
 * NewsDTO.java, Nov 4, 2015 
 * @author: HaVH-PC
 *
 */
package com.zerodios2015.DTO;

import java.util.Date;

import com.zerodios2015.Utils.ZDUtils;

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
     * News id Integer
     */
    private Integer id;

    /**
     * News category Integer
     */
    private Integer category;

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
    private Date date;

    /**
     * News remark Integer
     */
    private Integer remark;

    /**
     * Is this pin news Integer
     */
    private Boolean pin;

    /**
     * Is this news available Boolean
     */
    private Boolean status;

    /**
     * Version long
     */
    private Long version;

    /**
     * Default constructor
     */
    public NewsDTO() {
        this.id = null;
        this.author = null;
        this.category = null;
        this.status = null;
        this.remark = null;
        this.version = null;
    }

    /**
     * Constructor with status
     * 
     * @param status
     */
    public NewsDTO(Boolean status) {
        this.id = null;
        this.author = null;
        this.category = null;
        this.status = status;
        this.remark = null;
        this.version = null;
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
            boolean status, long version) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.description = description;
        this.author = author;
        this.date = date;
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
        this.id = (Integer) id;
        this.category = (Integer) category;
        this.title = (String) title;
        this.description = (String) description;
        this.author = (String) author;
        this.date = ZDUtils.toDate(date);
        this.remark = (Integer) remark;
        this.pin = (Boolean) pin;
        this.status = (Boolean) status;
        this.version = (Long) version;
    }
}
