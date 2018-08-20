package com.xh.entity;

public class T_course_classify {
    //
    private Integer id;

    //名称
    private String name;

    //级别
    private String code;

    //父级别，如果值为0则代表是一级分类
    private String parentCode;

    @Override
    public String toString() {
        return "T_course_classify{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", parentCode='" + parentCode + '\'' +
                '}';
    }

    //
    public Integer getId() {
        return id;
    }

    //
    public void setId(Integer id) {
        this.id = id;
    }

    //
    public String getName() {
        return name;
    }

    //
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    //
    public String getCode() {
        return code;
    }

    //
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    //
    public String getParentCode() {
        return parentCode;
    }

    //
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }
}