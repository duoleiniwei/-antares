package com.nehs.antares.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class Employees {

    private Integer empNo;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date hireDate;


}
