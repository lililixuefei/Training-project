package com.xuefei.bean;

/**
 * 科室
 */
public class Department {
    private String id;

    private String name;

    private String telephone;

    private String area;

    public Department() {
    }

    public Department(String id, String name, String telephone, String area) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.area = area;
    }

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }
}