package com.xuefei.service;

import com.xuefei.bean.Triage;
import com.xuefei.bean.TriagePatient;

import java.util.List;

public interface TriageService {

    List<TriagePatient> findAllTriages();
}
