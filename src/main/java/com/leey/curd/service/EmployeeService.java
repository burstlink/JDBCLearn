package com.leey.curd.service;

import com.leey.curd.bean.Employee;
import com.leey.curd.bean.EmployeeExample;
import com.leey.curd.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    //查询所有员工
    public List<Employee> getAll() {
        return employeeMapper.selectByExampleWithDept(null);
    }

    public void saveEmp(Employee employee) {
        employeeMapper.insert(employee);
    }

    // 检查name是否重复
    public boolean checkUser(String empName) {
        EmployeeExample example = new EmployeeExample();
        // 创建查询条件(空壳子)
        EmployeeExample.Criteria criteria = example.createCriteria();
        // 添加条件
        criteria.andEmpNameEqualTo(empName);
        // 查找
        long count = employeeMapper.countByExample(example);
        return count == 0;
    }

    //通过id查询employee
    public Employee getEmp(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    //更新employee
    public int updateEmp(Employee employee) {
        // 会对字段进行判断再更新(如果为Null就忽略更新)
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    //通过id删除
    public int deleteEmp(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    //批量删除
    public int deleteBatch(List<Integer> ids) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmpIdIn(ids);
        return employeeMapper.deleteByExample(employeeExample);
    }
}
