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
import java.util.Map;

import com.zerodios2015.DTO.AccountDTO;

/**
 * @author HaVH-PC
 *
 */
public class AccountDAO extends BaseDAO {

    /**
     * Check Login
     * 
     * @param email email
     * @param password password
     * @return String userId
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public String checkLogin(String email, String password) throws IllegalArgumentException, IllegalAccessException, Exception {
        String rs = "";

        sqlCommand = new StringBuilder();
        sqlParameter = new ArrayList<>();
        sqlCommand.append("SELECT ");
        sqlCommand.append("    ID ");
        sqlCommand.append("FROM ");
        sqlCommand.append("    ACCOUNT ");
        sqlCommand.append("WHERE ");
        sqlCommand.append("    EMAIL = ? ");
        sqlCommand.append("    AND PASSWORD = ? ");
        sqlParameter.add(email);
        sqlParameter.add(password);

        List<Map<String, Object>> result = getJdbcTemplate().queryForList(sqlCommand.toString(), sqlParameter.toArray());
        if (result.size() > 0) {
            rs = result.get(0).get("ID").toString();
        }

        return rs;
    }

    public AccountDTO getAccountInfo(String id) throws IllegalArgumentException, IllegalAccessException {
        AccountDTO account = new AccountDTO();
        account.setId(id);

        sqlCommand = new StringBuilder();
        sqlParameter = new ArrayList<>();
        sqlCommand.append("SELECT ");
        sqlCommand.append("    NAME ");
        sqlCommand.append("    , TYPE ");
        sqlCommand.append("    , NETBAR_IP ");
        sqlCommand.append("    , VIP ");
        sqlCommand.append("    , SUPERPASS ");
        sqlCommand.append("    , QUESTION1 ");
        sqlCommand.append("    , ANSWER1 ");
        sqlCommand.append("    , EMAIL ");
        sqlCommand.append("FROM ");
        sqlCommand.append("ACCOUNT ");
        sqlCommand.append("WHERE ");
        sqlCommand.append("    ID = ").append(id);
        sqlParameter.add(id);

        // List<Map<String, Object>> result = getJdbcTemplate().queryForList(sqlCommand.toString(), sqlParameter);
        List<Map<String, Object>> result = getJdbcTemplate().queryForList(sqlCommand.toString());
        account = new AccountDTO();
        if (result.size() > 0) {
            account = (AccountDTO) parseObject(result.get(0), account);
        }
        account.setId(id);

        return account;
    }
}
