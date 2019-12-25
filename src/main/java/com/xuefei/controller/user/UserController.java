package com.xuefei.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuefei.bean.Admin;
import com.xuefei.bean.Department;
import com.xuefei.bean.Patient;
import com.xuefei.bean.User;
import com.xuefei.service.DepartmentService;
import com.xuefei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/userList")
    public String userList(@RequestParam(value = "pn", defaultValue = "1")
                                       Integer number, Model model) {
        //第几页开始查，每页几条
        PageHelper.startPage(number, 3);
        List<Admin> users = userService.findAllUsers();
        //用PageInfo对结果进行包装
        //PageInfo包含了非常全面的分页属性
        PageInfo page = new PageInfo(users, 3);
        model.addAttribute("pageInfo", page);
        return "UserList";
    }

    /**
     * 点击修改，拿到数据后去更新页面
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/updateUser/{id}")
    public String departmentUpdate(@PathVariable("id") String id,
                                   Model model) {
        User user = userService.findDepartmentById(id);
        List<Department> depts = departmentService.findAllDepartments();
        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("depts",depts);
        } else {
            model.addAttribute("user", "跳转失败");
        }
        return "UserUpdate";
    }

    /**
     * 修改数据
     *
     * @param user
     * @param attributes
     * @return
     */
    @PostMapping("/UserUpdate")
    public String userUpdate(User user,
                                   RedirectAttributes attributes) {
        System.out.println(user);
        int i = userService.updateUser(user);
        if (i == 1) {
            attributes.addFlashAttribute("message", "更新成功");
        } else {
            attributes.addFlashAttribute("message", "更新失败");
        }
        return "redirect:/userList";
    }

    /**
     * 删除操作
     * @param id
     * @param attributes
     * @return
     */
    @GetMapping("/deleteUser/{id}")
    public String deleteDepartment(@PathVariable("id") String id,
                                   RedirectAttributes attributes){
        System.out.println(id);
        if (id.contains("-")) {
            List<String> del_ids = new ArrayList<>();
            String[] str_ids = id.split("-");
            for (String str_id : str_ids) {
                del_ids.add(str_id);
            }
            int i = userService.deleteBatch(del_ids);
            if (i != 0) {
                attributes.addFlashAttribute("message", "批量删除成功");
            } else {
                attributes.addFlashAttribute("message", "删除失败");
            }
        } else {
            int i = userService.deleteUser(id);
            if (i == 1) {
                attributes.addFlashAttribute("message", "删除成功");
            } else {
                attributes.addFlashAttribute("message", "删除失败");
            }
        }
        return "redirect:/userList";
    }

    @GetMapping("/addUser")
    public String toAddPage(Model model){
        List<Department> depts = departmentService.findAllDepartments();
        model.addAttribute("depts",depts);
        return "UserAdd";
    }
    /**
     * 添加
     *
     * @param user
     * @param attributes
     * @return
     */
    @PostMapping("/userAdd")
    public String addPatient(User user, RedirectAttributes attributes) {
        user.setId(UUID.randomUUID().toString().substring(0, 7));
        int status = userService.saveUser(user);
        if (status == 1) {
            attributes.addFlashAttribute("message", "添加成功！");
        } else {
            attributes.addFlashAttribute("message", "操作成功");
        }
        return "redirect:/userList";
    }



}
