package com.nehs.antares.mapper.employees;


import com.nehs.antares.entity.Employees;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EmployeesMapper {
    Employees getEmployeesByEmpNo(@Param("empNo") Long empNo);
}
