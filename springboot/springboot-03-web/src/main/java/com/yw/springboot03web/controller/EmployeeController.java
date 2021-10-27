package com.yw.springboot03web.controller;

import com.yw.springboot03web.dao.DepartmentDao;
import com.yw.springboot03web.dao.EmployeeDao;
import com.yw.springboot03web.pojo.Department;
import com.yw.springboot03web.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    //@ResponseBody
    public String list(Model model){
        Collection<Employee> list=employeeDao.getEmployees();
        model.addAttribute("emps",list);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddpage(Model model){
        //查出所有部门信息
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String AddEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //去员工修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(Model model, @PathVariable("id")int id){
        Employee employee=employeeDao.getById(id);
        model.addAttribute("employee",employee);

        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("departments",departments);

        return "emp/update";
    }

    //updateEmp
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //delemp
    @RequestMapping("/delemp/{id}")
    //@ResponseBody
    public String delemp(@PathVariable("id")int id){
        employeeDao.deleteById(id);
        return "redirect:/emps";
    }

}
