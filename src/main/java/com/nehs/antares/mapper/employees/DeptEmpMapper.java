package com.nehs.antares.mapper.employees;

import com.nehs.antares.entity.DeptEmpEntity;
import com.nehs.antares.entity.DeptEmpEntityKey;

public interface DeptEmpMapper {
    int deleteByPrimaryKey(DeptEmpEntityKey key);

    int insert(DeptEmpEntity record);

    int insertSelective(DeptEmpEntity record);

    DeptEmpEntity selectByPrimaryKey(DeptEmpEntityKey key);

    int updateByPrimaryKeySelective(DeptEmpEntity record);

    int updateByPrimaryKey(DeptEmpEntity record);
}