package com.nehs.antares.service.employees;

import com.nehs.antares.entity.Employees;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author neHs
 */
@Service
public interface EmployeesService {

    Employees getEmployeeByEmpNo(Long empNo);

    List<Employees> getEmployeeListByName(String firstName, String lastName);
}
