package com.xuefei.controller.patient;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PatientController {

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/patientList")
    public String patientList() {
        return "PatientList";
    }

    @RequestMapping("/depart")
    public String departmentList() {
        return "DepartmentList";
    }

    @RequestMapping("/triageList")
    public String triageList(){
        return "TriageList";
    }
}
