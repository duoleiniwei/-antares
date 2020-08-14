package com.nehs.antares.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * dept_emp
 * @author 
 */
@Data
public class DeptEmpEntity extends DeptEmpEntityKey implements Serializable {
    private Date fromDate;

    private Date toDate;

    private static final long serialVersionUID = 1L;
}