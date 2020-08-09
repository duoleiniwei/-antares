package com.nehs.antares.controller.employees;

import com.nehs.antares.entity.Employees;
import com.nehs.antares.service.employees.EmployeesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class EmployeesController {

    @Resource
    private EmployeesService employeesService;

    /**
     * 根据empNo查询employees
     *
     * @param empNo
     * @return
     */
    @GetMapping("/employees/getEmployee")
    public Employees getEmployee(@RequestParam Long empNo) {
        log.info("============employees/getEmployee接口执行============");
        if (StringUtils.isEmpty(empNo)) {
            log.error("传入empNo为空！请重新输入");
            return null;
        }
        Employees employees = employeesService.getEmployeeByEmpNo(empNo);
        return employees;
    }

    @PostMapping("/employees/getEmployeeListByName")
    public List<Employees> getEmployeeListByName(String firstName, String lastName) {
        log.info("============employees/getEmployees接口执行============");
        if (StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName)) {
            log.error("请输入firstName或者lastName");
            return null;
        }
        List<Employees> employeesList = new ArrayList<>(16);
        employeesList = employeesService.getEmployeeListByName(firstName, lastName);
        return employeesList;
    }

}
