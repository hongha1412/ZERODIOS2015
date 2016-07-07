/**
 * Copyright(C) ZeroDios2015
 *
 * MenuDTO.java, Jun 30, 2016
 * @author: HaVH
 *
 */
package com.zerodios2015.DTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HaVH
 *
 */
public class MenuDTO {

    /**
     * id int
     */
    private int id;

    /**
     * name String
     */
    private String name;

    /**
     * int
     */
    private int parent;

    /**
     * link String
     */
    private String link;

    /**
     * level int
     */
    private int level;

    /**
     * status int
     */
    private int status;

    /**
     * version int
     */
    private long version;

    /**
     * List<MenuDTO>
     */
    private List<MenuDTO> lsChild;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the parent
     */
    public int getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(int parent) {
        this.parent = parent;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
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

    /**
     * @return the lsChild
     */
    public List<MenuDTO> getLsChild() {
        return lsChild;
    }

    /**
     * @param lsChild the lsChild to set
     */
    public void setLsChild(List<MenuDTO> lsChild) {
        this.lsChild = lsChild;
    }

    /**
     * Default Constructor
     */
    public MenuDTO() {
        this.id = -1;
        this.name = "";
        this.link = "#";
        this.status = 1;
        this.version = 0;
        this.lsChild = new ArrayList<>();
    }

    public MenuDTO(int id, String name, int parent, String link, int level, int status, long version) {
        this.id = id;
        this.name = name;
        this.parent = parent;
        this.link = link;
        this.level = level;
        this.status = status;
        this.version = version;
        this.lsChild = new ArrayList<>();
    }
}
