package com.xuefei.service.impl;

import com.xuefei.bean.Patient;
import com.xuefei.bean.PatientExample;
import com.xuefei.mapper.PatientMapper;
import com.xuefei.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientMapper patientMapper;

    @Override
    @Transactional
    public Patient findPatientById(String id) {
        Patient patient = patientMapper.selectByPrimaryKey(id);
        return patient;
    }

    @Override
    @Transactional
    public List<Patient> findAllPatients() {
        List<Patient> patients = patientMapper.selectByExample(null);
        return patients;
    }

    @Override
    @Transactional
    public List<Patient> findPatientByName(String name) {
        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria().andNameLike("%"+name+"%");
        List<Patient> patients = patientMapper.selectByExample(patientExample);
        return patients;
    }

    @Override
    public List<Patient> findPatientByMobile(String mobile) {
        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria().andMobileLike("%"+mobile+"%");
        List<Patient> patients = patientMapper.selectByExample(patientExample);
        return patients;
    }

    @Override
    @Transactional
    public List<Patient> findPatientByNumber(String fuzzy) {
        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria().andIdcardLike("%"+fuzzy+"%");
        List<Patient> patients = patientMapper.selectByExample(patientExample);
        return patients;
    }

    @Override
    @Transactional
    public int savePatient(Patient patient) {
        int insert = patientMapper.insert(patient);
        return insert;
    }

    @Override
    @Transactional
    public int deletePatient(String id) {
        int i = patientMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    @Transactional
    public int updatePatient(Patient patient) {
        int i = patientMapper.updateByPrimaryKeySelective(patient);
        return i;
    }

    @Override
    @Transactional
    public int deleteBatch(List<String> ids) {
        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria().andIdIn(ids);
        int i = patientMapper.deleteByExample(patientExample);
        return i;
    }

}
