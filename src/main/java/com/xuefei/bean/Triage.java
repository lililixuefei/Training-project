package com.xuefei.bean;

/**
 * 分诊
 */
public class Triage {
    private String id;

    private Integer isemergency;

    private Integer status;

    private String pid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getIsemergency() {
        return isemergency;
    }

    public void setIsemergency(Integer isemergency) {
        this.isemergency = isemergency;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }
}