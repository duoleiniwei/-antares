package com.nehs.antares.controller.employees;

import com.nehs.antares.BaseController;
import com.nehs.antares.bo.JsonResponse;
import com.nehs.antares.constant.CommonConstant;
import com.nehs.antares.entity.Employees;
import com.nehs.antares.service.employees.EmployeesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class EmployeesController extends BaseController {

    @Resource
    private EmployeesService employeesService;

    /**
     * 根据empNo查询employees
     *
     * @param empNo
     * @return
     */
    @GetMapping("/employees/getEmployee")
    public JsonResponse getEmployee(@RequestParam Long empNo) {
        log.info("============employees/getEmployee接口执行============");
        if (StringUtils.isEmpty(empNo)) {
            log.error("传入empNo为空！请重新输入");
            return null;
        }
        Employees employees = employeesService.getEmployeeByEmpNo(empNo);
        return succeed(employees);
    }

    /**
     * 根据名称模糊查询，返回employees
     *
     * @param firstName
     * @param lastName
     * @return
     */
    @PostMapping("/employees/getEmployeeListByName")
    public JsonResponse getEmployeeListByName(String firstName, String lastName) {
        log.info("============employees/getEmployees接口执行============");
        if (StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName)) {
            log.error("请输入firstName或者lastName");
            return failed(CommonConstant.failedCode, "请输入firstName或者lastName");
        }
        List<Employees> employeesList = employeesService.getEmployeeListByName(firstName, lastName);
        return succeed(employeesList);
    }

}
