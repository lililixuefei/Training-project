package com.xuefei.mapper;

import com.xuefei.bean.Triage;
import com.xuefei.bean.TriageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TriageMapper {
    long countByExample(TriageExample example);

    int deleteByExample(TriageExample example);

    int deleteByPrimaryKey(String id);

    int insert(Triage record);

    int insertSelective(Triage record);

    List<Triage> selectByExample(TriageExample example);

    Triage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Triage record, @Param("example") TriageExample example);

    int updateByExample(@Param("record") Triage record, @Param("example") TriageExample example);

    int updateByPrimaryKeySelective(Triage record);

    int updateByPrimaryKey(Triage record);
}