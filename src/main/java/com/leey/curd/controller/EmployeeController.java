package com.leey.curd.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leey.curd.bean.Employee;
import com.leey.curd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeController employeeController;


    @RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn", defaultValue = "1")Integer pn) {
        /*
         * 查询员工数据（分页查询）
         */
        //引用pageHelper分页查找
        PageHelper.startPage(pn, 5);
        List<Employee> emps = EmployeeService.getAll();
        PageInfo pageInfo = new PageInfo(emps);
        return "list";
    }

}
