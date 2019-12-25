package com.xuefei.controller.triage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuefei.bean.Department;
import com.xuefei.bean.Triage;
import com.xuefei.bean.TriagePatient;
import com.xuefei.service.TriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TriageController {

    @Autowired
    TriageService triageService;

    @GetMapping("/triageList")
    public String triageList(@RequestParam(value = "pn", defaultValue = "1")
                                         Integer number, Model model) {
        //第几页开始查，每页几条
        PageHelper.startPage(number, 3);
        List<TriagePatient> triages = triageService.findAllTriages();
        //用PageInfo对结果进行包装
        //PageInfo包含了非常全面的分页属性
        PageInfo page = new PageInfo(triages, 3);
        model.addAttribute("pageInfo", page);
        return "TriageList";
    }

}
