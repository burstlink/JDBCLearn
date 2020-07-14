package com.leeyy.curd;

import com.leey.curd.bean.Department;
import com.leey.curd.bean.Employee;
import com.leey.curd.dao.DepartmentMapper;
import com.leey.curd.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/*
 * 测试dao层工作
 * Spring单元测试可以自动注入所需的组件
 * ContextConfiguration指定spring配置文件位置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    /*
     * 测试DepartmentMapper
     */
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;

    @Test
    public void testCURD(){
//        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//        DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);
        //插入部门
//        departmentMapper.insertSelective(new Department(null, "xx"));
        departmentMapper.insertSelective(new Department(null, "zz"));
        //插入员工
//        employeeMapper.insertSelective(new Employee(null, "leeyy", "M", "123@123.com",1));
        //批量插入
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i <10 ; i++) {
            String uuid = UUID.randomUUID().toString().substring(0,5) + i;
            mapper.insertSelective(new Employee(null, uuid, "M", "12@123.com",1));

        }
        System.out.println("批量完成");

    }
}
