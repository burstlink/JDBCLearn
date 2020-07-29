package com.leey.curd.service;

import com.leey.curd.bean.Department;
import com.leey.curd.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    // 查找全部部门
    public List<Department> getDepts() {
        // 传递参数null查询全部
        return departmentMapper.selectByExample(null);
    }
}
