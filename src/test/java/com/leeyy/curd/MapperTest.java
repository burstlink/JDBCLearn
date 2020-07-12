package com.leeyy.curd;

import com.leey.curd.dao.DepartmentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * 测试dao层工作
 * Spring单元测试可以自动注入所需的组件
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    /*
     * 测试DepartmentMapper
     */
    DepartmentMapper departmentMapper;

    @Test
    public void testCURD(){
        System.out.println(departmentMapper);
    }
}
