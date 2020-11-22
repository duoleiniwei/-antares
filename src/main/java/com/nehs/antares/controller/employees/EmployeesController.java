package com.nehs.antares.controller.employees;

import com.nehs.antares.BaseController;
import com.nehs.antares.bo.JsonResponse;
import com.nehs.antares.bo.request.DeptEmpReq;
import com.nehs.antares.constant.CommonConstant;
import com.nehs.antares.entity.Employees;
import com.nehs.antares.service.employees.EmployeesService;
import com.nehs.antares.utils.annotation.LoggerAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    @LoggerAnnotation
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
     * @return
     */
    @PostMapping("/employees/getEmployeeListByName")
    public JsonResponse getEmployeeListByName(@RequestBody Map<String, String> map) {
        log.info("============employees/getEmployees接口执行============");
        if (StringUtils.isEmpty(map.get("firstName")) && StringUtils.isEmpty(map.get("lastName"))) {
            log.error("请输入firstName或者lastName");
            return failed(CommonConstant.failedCode, "请输入firstName或者lastName");
        }
        List<Employees> employeesList = employeesService.getEmployeeListByName(map.get("firstName"), map.get("lastName"));
        return succeed(employeesList);
    }

    @PostMapping("/employees/insertDeptEmp")
    public JsonResponse insertDeptEmp(@Validated DeptEmpReq deptEmpReq) {
        Boolean a = ObjectUtils.isEmpty(deptEmpReq);
        Boolean b = StringUtils.isEmpty(deptEmpReq);
        Boolean c = Objects.nonNull(deptEmpReq);
        return null;
    }

}
