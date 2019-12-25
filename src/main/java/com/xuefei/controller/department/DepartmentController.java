package com.xuefei.controller.department;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuefei.bean.Department;
import com.xuefei.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    /**
     * 首页查询
     *
     * @param model
     * @return
     */
    @GetMapping("/depart")
    public String departmentList(@RequestParam(value = "pn", defaultValue = "1")
                                             Integer number, Model model) {
        //第几页开始查，每页几条
        PageHelper.startPage(number, 3);
        List<Department> allDepartments = departmentService.findAllDepartments();
        //用PageInfo对结果进行包装
        //PageInfo包含了非常全面的分页属性
        PageInfo page = new PageInfo(allDepartments, 3);
        model.addAttribute("pageInfo", page);
        return "DepartmentList";
    }

    /**
     * 删除操作
     * @param id
     * @param attributes
     * @return
     */
    @GetMapping("/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable("id") String id,
                                   RedirectAttributes attributes){
        System.out.println(id);
        if (id.contains("-")) {
            List<String> del_ids = new ArrayList<>();
            String[] str_ids = id.split("-");
            for (String str_id : str_ids) {
                del_ids.add(str_id);
            }
            int i = departmentService.deleteBatch(del_ids);
            if (i != 0) {
                attributes.addFlashAttribute("message", "批量删除成功");
            } else {
                attributes.addFlashAttribute("message", "删除失败");
            }
        } else {
            int i = departmentService.deleteDepartment(id);
            if (i == 1) {
                attributes.addFlashAttribute("message", "删除成功");
            } else {
                attributes.addFlashAttribute("message", "删除失败");
            }
        }
        return "redirect:/depart";
    }

    /**
     * 点击修改，拿到数据后去更新页面
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/departmentUpdate/{id}")
    public String departmentUpdate(@PathVariable("id") String id,
                                Model model) {
        Department department = departmentService.findDepartmentById(id);
        if (department != null) {
            model.addAttribute("department", department);
        } else {
            model.addAttribute("department", "跳转失败");
        }
        return "DepartmentUpdate";
    }

    /**
     * 修改数据
     *
     * @param department
     * @param attributes
     * @return
     */
    @PostMapping("/updateDepartment")
    public String updateDepartment(Department department,
                                RedirectAttributes attributes) {
        System.out.println(department);
        int i = departmentService.updateDepartment(department);
        if (i == 1) {
            attributes.addFlashAttribute("message", "更新成功");
        } else {
            attributes.addFlashAttribute("message", "更新失败");
        }
        return "redirect:/depart";
    }

    @PostMapping("/fuzzyQueryDepart")
    public String fuzzyQueryDepart(@RequestParam(value = "pn", defaultValue = "1")
                                               Integer number, @RequestParam("fuzzy") String fuzzy, Model model) {
        //第几页开始查，每页几条
        PageHelper.startPage(number, 100);
        List<Department> departments = null;
        departments = departmentService.findDepartmentByName(fuzzy);
        if (departments.size() == 0) {
            departments = departmentService.findDepartmentByMobile(fuzzy);
            if (departments.size() == 0) {
                departments = departmentService.findDepartmentByArea(fuzzy);
            }
        }
        PageInfo page = new PageInfo(departments, 3);
        model.addAttribute("pageInfo", page);
        return "DepartmentList";
    }


}
