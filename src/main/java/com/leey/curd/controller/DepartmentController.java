package com.leey.curd.controller;

import com.leey.curd.bean.Department;
import com.leey.curd.bean.Msg;
import com.leey.curd.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 处理有关部门的请求
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/depts")
    @ResponseBody
    public Msg getDepts() {
        List<Department> list = departmentService.getDepts();
        return Msg.success().add("depts", list);
    }
}
