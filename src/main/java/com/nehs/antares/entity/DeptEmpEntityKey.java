package com.nehs.antares.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * dept_emp
 * @author 
 */
@Data
public class DeptEmpEntityKey implements Serializable {
    private Integer empNo;

    private String deptNo;

    private static final long serialVersionUID = 1L;
}