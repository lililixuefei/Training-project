package com.xuefei.bean;

import java.util.Date;

/**
 * 患者
 */
public class Patient {
    private String id;

    private String name;

    private Integer sex;

    private Date birthday;

    private String idcard;

    private String address;

    private String mobile;

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();

    }

    public Patient() {
    }

    public Patient(String id, String name, Integer sex, Date birthday, String idcard, String address, String mobile, String description) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.idcard = idcard;
        this.address = address;
        this.mobile = mobile;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", idcard='" + idcard + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}