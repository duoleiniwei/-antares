package com.nehs.antares.controller.employees;

import com.nehs.antares.entity.Employees;
import com.nehs.antares.service.employees.EmployeesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class EmployeesController {

    @Resource
    private EmployeesService employeesService;

    @GetMapping("/employees/getEmployee")
    public Employees getEmployee(@RequestParam Long empNo) {
        if(StringUtils.isEmpty(empNo)){
            log.error("传入empNo为空！");
        }
        Employees employees = employeesService.getEmployeeByEmpNo(empNo);
        return employees;
    }
}
