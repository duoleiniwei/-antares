package com.nehs.antares.bo.request;

import lombok.Data;

@Data
public class DeptEmpReq {
    /**
     * 部门编号
     */
    String deptNo;
    /**
     * 开始时间
     */
    String fromDate;
    /**
     * 结束时间
     */
    String toDate;
}
