/**
 * Copyright(C) ZeroDios2015
 *
 * InformationDAO.java, Oct 8, 2015 
 * @author: HaVH-PC
 *
 */
package com.zerodios2015.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;

import com.zerodios2015.DTO.InformationDTO;

/**
 * 
 * @author HaVH-PC
 *
 */
public class InformationDAO extends BaseDAO {
    DataSource dataSource;

    public boolean addInformation(InformationDTO informationDTO) throws SQLException {
        String sql = "INSERT INTO information_table (`name`, age, address) values(?, ?, ?)";
        List<Object> params = new ArrayList<Object>();
        params.add(informationDTO.getName());
        params.add(informationDTO.getAge());
        params.add(informationDTO.getAddress());

        try {
            getJdbcTemplate().update(sql, params.toArray());
        }
        catch (DataAccessException dae) {
            dae.printStackTrace();
            return false;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateInformation(InformationDTO informationDTO) throws SQLException {
        return true;
    }

    public InformationDTO getInformationById(int id) {
        return null;
    }

    public boolean deleteInformationById(int id) {
        return true;
    }
}
