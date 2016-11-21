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

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author HaVH
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class MenuDTO {

    /**
     * id int
     */
    private Integer id;

    /**
     * name String
     */
    private String name;

    /**
     * int
     */
    private Integer parent;

    /**
     * link String
     */
    private String link;

    /**
     * level int
     */
    private Integer level;

    /**
     * status int
     */
    private Integer status;

    /**
     * version int
     */
    private Long version;

    /**
     * List<MenuDTO>
     */
    private List<MenuDTO> lsChild;

    /**
     * Default Constructor
     */
    public MenuDTO() {
        this.id = -1;
        this.name = "";
        this.link = "#";
        this.status = 1;
        this.version = new Long(0);
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
