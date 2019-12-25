package com.xuefei.service.impl;

import com.xuefei.bean.*;
import com.xuefei.exception.PageNotFoundException;
import com.xuefei.mapper.PatientMapper;
import com.xuefei.mapper.TriageMapper;
import com.xuefei.service.TriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TriageServiceImpl implements TriageService {

    @Autowired
    TriageMapper triageMapper;

    @Autowired
    PatientMapper patientMapper;

    @Override
    public List<TriagePatient> findAllTriages() {
        List<TriagePatient> triagePatients = new ArrayList<>();
        List<Triage> triages = triageMapper.selectByExample(null);
        for (Triage triage : triages) {
            TriagePatient triagePatient = new TriagePatient();
            Patient patient = patientMapper.selectByPrimaryKey(triage.getPid());
            if (patient == null) {
                throw new PageNotFoundException("对不起,有错误");
            }
            triagePatient.setId(patient.getId());
            triagePatient.setName(patient.getName());
            triagePatient.setSex(patient.getSex());
            triagePatient.setBirthday(patient.getBirthday());
            triagePatient.setIsemergency(triage.getIsemergency());
            triagePatient.setStatus(triage.getStatus());
            triagePatients.add(triagePatient);
        }
        return triagePatients;
    }
}
