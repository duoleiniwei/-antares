package com.nehs.antares.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.nehs.antares.utils.annotation.UpperAnnotation;
import lombok.Data;
import org.apache.commons.lang3.AnnotationUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;


@Data
public class Employees {
    @UpperAnnotation("员工编码")
    private Integer empNo;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @UpperAnnotation("出生日期")
    private Date birthDate;
    @UpperAnnotation("首名")
    private String firstName;
    @UpperAnnotation("尾名")
    private String lastName;
    @UpperAnnotation("性别")
    private String gender;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @UpperAnnotation("入职时间")
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
                .filter(field -> field.isAnnotationPresent(UpperAnnotation.class))
                .forEach(field -> {
                    System.out.println(field.getName());
                    System.out.println(field.getDeclaredAnnotation(UpperAnnotation.class).value());
                });
    }
}
