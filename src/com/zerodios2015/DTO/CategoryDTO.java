/**
 * Copyright(C) ZeroDios2015
 *
 * CategoryDTO.java, Nov 22, 2016
 * @author: HaVH
 *
 */
package com.zerodios2015.DTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author HaVH
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class CategoryDTO extends BaseFormDTO {
    private Integer id;
    private String name;
    private Integer parent;
    private Boolean status;
    private Long version;

    /**
     * Constructor without parameter
     */
    public CategoryDTO() {
        super();
        this.status = true;
    }

    /**
     * Constructor with object parameter
     * 
     * @param id
     * @param name
     * @param parent
     * @param status
     * @param version
     */
    public CategoryDTO(Object id, Object name, Object parent, Object status, Object version) {
        this.id = (Integer) id;
        this.name = (String) name;
        this.parent = (Integer) parent;
        this.status = (Boolean) status;
        this.version = (Long) version;
    }
}
