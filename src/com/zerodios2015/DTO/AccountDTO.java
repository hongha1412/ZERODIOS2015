/**
 * Copyright(C) ZeroDios2015
 *
 * AdmLoginDTO.java, Sep 28, 2016
 * @author: hongha1412
 *
 */
package com.zerodios2015.DTO;

import lombok.Data;

/**
 * @author hongha1412
 *
 */
@Data
public class AccountDTO {
    private String id;
    private String name;
    private String password;
    private String netbar_ip;
    private String vip;
    private String superPass;
    private String email;

    /**
     * Default constructor
     */
    public AccountDTO() {
        super();
        this.id = "";
        this.name = "";
    }

    public AccountDTO(Object name, Object email) {
        super();
        this.email = email.toString();
        this.name = name.toString();
    }

    /**
     * @param id
     * @param name
     * @param password
     * @param ip
     * @param vip
     * @param superPass
     * @param email
     */
    public AccountDTO(Object id, Object name, Object password, Object netbar_ip, Object vip, Object superPass, Object email) {
        super();
        this.id = id.toString();
        this.name = name.toString();
        this.password = password.toString();
        this.netbar_ip = netbar_ip.toString();
        this.vip = vip.toString();
        this.superPass = superPass.toString();
        this.email = email.toString();
    }
}
