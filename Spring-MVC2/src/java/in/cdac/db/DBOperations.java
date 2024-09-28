/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.cdac.db;

import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author CDAC
 */

public class DBOperations {

    private JdbcTemplate jdbcTemplate;  
    String query = null;
    int rowsAffected = 0;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public boolean verifyUserDetails(String username, String password){
        query = "select username from userlogininfo where username=? and password=?";
        try {
            UserLoginInfo ul = jdbcTemplate.queryForObject(query,
                    new Object[]{username, password}, 
                    new BeanPropertyRowMapper<UserLoginInfo>(UserLoginInfo.class));
            if (ul != null) {
                return true;
            }
        } catch (EmptyResultDataAccessException ee) {

        }
        
        return false;
    }  
    
    public String saveUserDetails(UserLoginInfo uInfo){
        query = "insert into userlogininfo values(?,?)";
        try {
            rowsAffected
                    = jdbcTemplate.update(query, new Object[]{uInfo.getUsername(), uInfo.getPassword()});
            if (rowsAffected == 1) {
                return "success";
            }
        } catch (DuplicateKeyException sq) {
            return "exits";
        }
                
        return "fail";
    }
  
}
