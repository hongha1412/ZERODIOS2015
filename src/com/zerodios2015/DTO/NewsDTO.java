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

/**
 * 
 * @author HaVH-PC
 *
 */
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
     * Author int
     */
    private int author;

    /**
     * Posted date Date
     */
    private Date date;

    /**
     * News remark int
     */
    private int remark;

    /**
     * Is this pin news boolean
     */
    private byte pin;

    /**
     * Is this enws available boolean
     */
    private byte status;

    /**
     * Version long
     */
    private long version;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the category
     */
    public int getCategory() {
        return category;
    }

    /**
     * @param category
     *            the category to set
     */
    public void setCategory(int category) {
        this.category = category;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the author
     */
    public int getAuthor() {
        return author;
    }

    /**
     * @param author
     *            the author to set
     */
    public void setAuthor(int author) {
        this.author = author;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the remark
     */
    public int getRemark() {
        return remark;
    }

    /**
     * @param remark
     *            the remark to set
     */
    public void setRemark(int remark) {
        this.remark = remark;
    }

    /**
     * @return the pin
     */
    public byte isPin() {
        return pin;
    }

    /**
     * @param pin
     *            the pin to set
     */
    public void setPin(byte pin) {
        this.pin = pin;
    }

    /**
     * @return the status
     */
    public byte isStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(byte status) {
        this.status = status;
    }

    /**
     * @return the version
     */
    public long getVersion() {
        return version;
    }

    /**
     * @param version
     *            the version to set
     */
    public void setVersion(long version) {
        this.version = version;
    }

    /**
     * Default constructor
     */
    public NewsDTO() {
        super();
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
    public NewsDTO(int id, int category, String title, String description, int author, Date date, int remark, byte pin,
            byte status, long version) {
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
        this.id = Integer.parseInt(id.toString());
        this.category = Integer.parseInt(category.toString());
        this.title = title.toString();
        this.description = description.toString();
        this.author = Integer.parseInt(author.toString());
        this.date = ZDStringUtils.toDate(date);
        this.remark = Integer.parseInt(remark.toString());
        this.pin = (byte)pin;
        this.status = (byte)status;
        this.version = Long.parseLong(version.toString());
    }
}
