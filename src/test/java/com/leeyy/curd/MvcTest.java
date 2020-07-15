package com.leeyy.curd;

import com.github.pagehelper.PageInfo;
import com.leey.curd.bean.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/*
 * 测试请求功能
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "file:web/WEB-INF/dispatchServlet-servlet.xml"})
public class MvcTest {
    // 打桩测试,虚拟mvc请求，获取处理结果
    MockMvc mockMvc;
    // 传入spring mvc的ioc
    @Autowired
    WebApplicationContext context;

    @Before
    public void initMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

    }
    @Test
    public void testPage() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn","1")).andReturn();
        //取出page info
        MockHttpServletRequest request = result.getRequest();
        PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
        System.out.println("当前页码：" + pageInfo.getPageNum());
        System.out.println("总页码：" + pageInfo.getPages());
        System.out.println("总记录数：" + pageInfo.getTotal());
        System.out.println("再页面需要连续显示的页码");
        int[] nums = pageInfo.getNavigatepageNums();
        for (int i: nums
             ) {
            System.out.println(" " + i);
        }
        //员工数据
        List<Employee> list = pageInfo.getList();
        for (Employee employy: list
             ) {
            System.out.println("ID, " + employy.getEmpId()+"=====>name:"+ employy.getEmpName());
        }

    }
}
