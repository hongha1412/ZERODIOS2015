/**
 * Copyright(C) ZeroDios2015
 *
 * NewsDTO.java, Nov 4, 2015 
 * @author: HaVH-PC
 *
 */
package com.zerodios2015.DTO;

import java.util.Date;

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
     * @param id the id to set
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
     * @param category the category to set
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
     * @param title the title to set
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
     * @param description the description to set
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
     * @param author the author to set
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
     * @param date the date to set
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
     * @param remark the remark to set
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
     * @param pin the pin to set
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
     * @param status the status to set
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
     * @param version the version to set
     */
    public void setVersion(long version) {
        this.version = version;
    }
}
