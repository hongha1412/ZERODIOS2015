/**
 * Copyright(C) ZeroDios2015
 *
 * AccountDAO.java, Sep 28, 2016
 * @author: hongha1412
 *
 */
package com.zerodios2015.DAO;

import java.util.ArrayList;
import java.util.List;

import com.zerodios2015.DTO.AccountDTO;

/**
 * @author HaVH-PC
 *
 */
public class AccountDAO extends BaseDAO {

    public boolean checkLogin(String userName, String password) {
        boolean rs = false;

        List<Object> sqlParameter = new ArrayList();
        StringBuilder sqlCommand = new StringBuilder();
        sqlCommand.append("SELECT ");
        sqlCommand.append("    ID ");
        sqlCommand.append("    , NAME ");
        sqlCommand.append("    , EMAIL ");
        sqlCommand.append("FROM ");
        sqlCommand.append("    ACCOUNT ");
        AccountDTO account = new AccountDTO();

        return rs;
    }
}
