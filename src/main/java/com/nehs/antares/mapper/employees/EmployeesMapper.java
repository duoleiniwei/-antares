package com.nehs.antares.mapper.employees;


import com.nehs.antares.entity.Employees;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeesMapper {
    Employees getEmployeesByEmpNo(@Param("empNo") Long empNo);

    List<Employees> getEmployeeListByName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
