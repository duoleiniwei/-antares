package com.nehs.antares.service.employees.impl;

import com.nehs.antares.entity.Employees;
import com.nehs.antares.mapper.employees.EmployeesMapper;
import com.nehs.antares.service.employees.EmployeesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author neHs
 */
@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Resource
    private EmployeesMapper employeesMapper;

    @Override
    public Employees getEmployeeByEmpNo(Long empNo) {
        return employeesMapper.getEmployeesByEmpNo(empNo);
    }

    @Override
    public List<Employees> getEmployeeListByName(String firstName, String lastName) {
        return employeesMapper.getEmployeeListByName(firstName, lastName);
    }
}
