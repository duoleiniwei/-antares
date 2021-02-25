package com.nehs.antares.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.nehs.antares.utils.annotation.DescAnnotation;
import lombok.Data;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;


/**
 * @author neHs
 */
@Data
public class Employees {
    @DescAnnotation("员工编码")
    private Integer empNo;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DescAnnotation("出生日期")
    private Date birthDate;
    @DescAnnotation("首名")
    private String firstName;
    @DescAnnotation("尾名")
    private String lastName;
    @DescAnnotation("性别")
    private String gender;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DescAnnotation("入职时间")
    private Date hireDate;

    public Employees(Integer empNo, String firstName, String lastName, String gender) {
        this.empNo = empNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Employees() {
    }

    public static void main(String[] args) {
        Employees employees = new Employees();
        Field[] fields = employees.getClass().getDeclaredFields();
        Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(DescAnnotation.class))
                .forEach(field -> {
                    System.out.println("desc:" + field.getDeclaredAnnotation(DescAnnotation.class).value());
                    System.out.println("name:" + field.getName());
                    System.out.println("===================");
                });
    }
}
