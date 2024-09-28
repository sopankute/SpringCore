/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.cdac;

import java.util.List;
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
    
    public void saveEmployeeDetails(Employee emp){
        query = "insert into employee (name, email, salary) values(?,?,?)";
//        String query = "insert into employee (name, email, salary)"
//                + " values('"+emp.getName()+"','"+emp.getEmail()+"','"+emp.getSalary()+"')";
//        jdbcTemplate.update(query);
        rowsAffected = 
          jdbcTemplate.update(query, new Object[]{emp.getName(), emp.getEmail(), emp.getSalary()});
        System.out.println("==="+rowsAffected);
    }
    
    public void updateEmployeeDetails(Employee emp){               

        query = "update employee set name=?,email=?,salary=? where id=?";
        rowsAffected =  jdbcTemplate.update(query,new Object[]{emp.getName(), 
            emp.getEmail(), emp.getSalary(), emp.getId()});
         System.out.println("==="+rowsAffected);
    }
    
    public void deleteEmployeeDetails(int empid){
        query = "delete from employee where id=?";
        rowsAffected =  jdbcTemplate.update(query,new Object[]{empid});
         System.out.println("==="+rowsAffected);
    }
    
    public void getAllEmployees(){
        query = "select * from employee";
        List<Employee> empList = 
                jdbcTemplate.query(query, new BeanPropertyRowMapper(Employee.class));
        for(Employee e : empList){
            System.out.println(e.getId()+"--"+e.getName());
        }
    }    
}
