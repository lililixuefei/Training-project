package com.xuefei.bean;

import java.util.Date;

public class TriagePatient {
    private String id;

    private String name;

    private Integer sex;

    private Date birthday;

    private Integer isemergency;

    private Integer status;

    @Override
    public String toString() {
        return "TriagePatient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", isemergency=" + isemergency +
                ", status=" + status +
                '}';
    }

    public TriagePatient() {
    }

    public TriagePatient(String id, String name, Integer sex, Date birthday, Integer isemergency, Integer status) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.isemergency = isemergency;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
}
