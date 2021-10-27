package com.yw.springboot03web.dao;

import com.yw.springboot03web.pojo.Department;
import com.yw.springboot03web.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    //初始化数据
    private static Map<Integer, Employee> employees=null;

    @Autowired
    private DepartmentDao departmentDao;
    static{
        employees=new HashMap<Integer, Employee>();
        employees.put(1001,new Employee(1001,"AA","1617475688@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"AA","1617475688@qq.com",1,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"AA","1617475688@qq.com",0,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"AA","1617475688@qq.com",1,new Department(104,"运营部")));
        employees.put(1005,new Employee(1005,"AA","1617475688@qq.com",0,new Department(105,"后勤部")));
    }

    //主键自增
    private static Integer initId=1006;

    //增加员工
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);

    }

    public Collection<Employee> getEmployees(){
        return employees.values();
    }

    public Employee getById(Integer id){
        return employees.get(id);
    }

    public void deleteById(Integer id){
        employees.remove(id);
    }
}
