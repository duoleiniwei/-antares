package com.nehs.antares.service.employees;

import com.nehs.antares.entity.Employees;
import org.springframework.stereotype.Service;

@Service
public interface EmployeesService {

    Employees getEmployeeByEmpNo(Long empNo);
}
