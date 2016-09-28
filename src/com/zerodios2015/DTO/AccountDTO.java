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
    private String ip;
    private String vip;
    private String superPass;
    private String email;
}
