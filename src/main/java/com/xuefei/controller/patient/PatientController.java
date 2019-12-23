package com.xuefei.controller.patient;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuefei.bean.Patient;
import com.xuefei.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class PatientController {

    @Autowired
    PatientService patientService;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    /**
     * 添加
     *
     * @param patient
     * @param attributes
     * @return
     */
    @PostMapping("/addPatient")
    public String addPatient(Patient patient, RedirectAttributes attributes) {
        patient.setId(UUID.randomUUID().toString().substring(0, 7));
        int status = patientService.savePatient(patient);
        if (status == 1) {
            attributes.addFlashAttribute("message", "添加成功！");
        } else {
            attributes.addFlashAttribute("message", "操作成功");
        }
        return "redirect:/patientList";
    }

    /**
     * 首页查询
     *
     * @param model
     * @return
     */
    @GetMapping("/patientList")
    public String patientList(@RequestParam(value = "pn", defaultValue = "1")
                                      Integer number, Model model) {
        //第几页开始查，每页几条
        PageHelper.startPage(number, 3);
        List<Patient> allPatients = patientService.findAllPatients();
        //用PageInfo对结果进行包装
        //PageInfo包含了非常全面的分页属性
        PageInfo page = new PageInfo(allPatients, 3);
        model.addAttribute("pageInfo", page);
        return "PatientList";
    }

    /**
     * 模糊查询
     * @param number
     * @param fuzzy
     * @param model
     * @return
     */
    @PostMapping("/fuzzyQuery")
    public String fuzzyQuery(@RequestParam(value = "pn", defaultValue = "1")
                                     Integer number, @RequestParam("fuzzy") String fuzzy, Model model) {
        //第几页开始查，每页几条
        PageHelper.startPage(number, 100);
        List<Patient> patients = null;
        patients = patientService.findPatientByName(fuzzy);
        if (patients.size() == 0) {
            patients = patientService.findPatientByMobile(fuzzy);
            if (patients.size() == 0) {
                patients = patientService.findPatientByNumber(fuzzy);
            }
        }
        PageInfo page = new PageInfo(patients, 3);
        model.addAttribute("pageInfo", page);
        return "PatientList";
    }

    /**
     * 删除操作
     *
     * @param id
     * @param attributes
     * @return
     */
    @GetMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable("id") String id,
                                RedirectAttributes attributes) {
        System.out.println(id);
        if (id.contains("-")) {
            List<String> del_ids = new ArrayList<>();
            String[] str_ids = id.split("-");
            for (String str_id : str_ids) {
                del_ids.add(str_id);
            }
            int i = patientService.deleteBatch(del_ids);
            if (i != 0) {
                attributes.addFlashAttribute("message", "批量删除成功");
            } else {
                attributes.addFlashAttribute("message", "删除失败");
            }
        } else {
            int i = patientService.deletePatient(id);
            if (i == 1) {
                attributes.addFlashAttribute("message", "删除成功");
            } else {
                attributes.addFlashAttribute("message", "删除失败");
            }
        }
        return "redirect:/patientList";
    }

    /**
     * 去添加页面，信息回显
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/patientUpdate/{id}")
    public String patientUpdate(@PathVariable("id") String id,
                                Model model) {
        Patient patient = patientService.findPatientById(id);
        if (patient != null) {
            model.addAttribute("patient", patient);
        } else {
            model.addAttribute("patient", "跳转失败");
        }
        return "PatientUpdate";
    }


    /**
     * 修改数据
     *
     * @param patient
     * @param attributes
     * @return
     */
    @PostMapping("/updatePatient")
    public String updatePatient(Patient patient,
                                RedirectAttributes attributes) {
        System.out.println(patient);
        int i = patientService.updatePatient(patient);
        if (i == 1) {
            attributes.addFlashAttribute("message", "更新成功");
        } else {
            attributes.addFlashAttribute("message", "更新失败");
        }
        return "redirect:/patientList";
    }

    @RequestMapping("/depart")
    public String departmentList() {
        return "DepartmentList";
    }

    @RequestMapping("/triageList")
    public String triageList() {
        return "TriageList";
    }

    /**
     * 点击去添加页面
     *
     * @return
     */
    @GetMapping("/patientAdd")
    public String getPatient(Model model) {
        Patient patient = patientService.findPatientById("1");
        System.out.println(patient);
        model.addAttribute("patient", patient);
        return "PatientAdd";
    }
}
