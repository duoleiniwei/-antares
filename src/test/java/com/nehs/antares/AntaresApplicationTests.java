package com.nehs.antares;

import com.nehs.antares.entity.Employees;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class AntaresApplicationTests {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
    }

//    @Test
//    public void mysqlTestDemo() {
//        String sql = "SELECT * FROM employees.employees limit 1";
//        List<Employees> result = jdbcTemplate.query(sql, (RowMapper) (resultSet, i) -> {
//            Employees employees = new Employees();
//            employees.setEmpNo(resultSet.getLong("emp_no"));
//            employees.setBirthDate(resultSet.getDate("birth_date"));
//            employees.setFirstName(resultSet.getString("first_name"));
//            employees.setGender(resultSet.getString("gender"));
//            employees.setHireDate(resultSet.getDate("hire_date"));
//            employees.setLastName(resultSet.getString("last_name"));
//            return employees;
//        });
//        System.out.println(result.toString());
//    }

}
