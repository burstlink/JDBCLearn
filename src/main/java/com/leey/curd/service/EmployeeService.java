package com.leey.curd.service;

import com.leey.curd.bean.Employee;
import com.leey.curd.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> getAll() {
        return employeeMapper.selectByPrimaryKeyWithDept(null);
    }
}
