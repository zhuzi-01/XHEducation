package com.xh.entity;

//课程表
public class T_course {
    //
    private Integer id;

    //课程名称
    private String name;

    //一级分类
    private String classify;

    //一级分类名称
    private String classifyName;

    //二级分类
    private String subClassify;

    //二级分类名称
    private String subClassifyName;

    //归属人
    private String username;

    //课程级别：1-初级，2-中级，3-高级
    private Integer level;

    //时长
    private String duration;

    //学习人数
    private Integer studyCount;

    //权重
    private Integer weight;

    //课程描述
    private String brief;

    public T_course() {
    }

    public T_course(String classify, String subClassify) {
        this.classify = classify;
        this.subClassify = subClassify;
    }

    @Override
    public String toString() {
        return "T_course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classify='" + classify + '\'' +
                ", classifyName='" + classifyName + '\'' +
                ", subClassify='" + subClassify + '\'' +
                ", subClassifyName='" + subClassifyName + '\'' +
                ", username='" + username + '\'' +
                ", level=" + level +
                ", duration='" + duration + '\'' +
                ", studyCount=" + studyCount +
                ", weight=" + weight +
                ", brief='" + brief + '\'' +
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
    public String getClassify() {
        return classify;
    }

    //
    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }

    //
    public String getClassifyName() {
        return classifyName;
    }

    //
    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName == null ? null : classifyName.trim();
    }

    //
    public String getSubClassify() {
        return subClassify;
    }

    //
    public void setSubClassify(String subClassify) {
        this.subClassify = subClassify == null ? null : subClassify.trim();
    }

    //
    public String getSubClassifyName() {
        return subClassifyName;
    }

    //
    public void setSubClassifyName(String subClassifyName) {
        this.subClassifyName = subClassifyName == null ? null : subClassifyName.trim();
    }

    //
    public String getUsername() {
        return username;
    }

    //
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    //
    public Integer getLevel() {
        return level;
    }

    //
    public void setLevel(Integer level) {
        this.level = level;
    }

    //
    public String getDuration() {
        return duration;
    }

    //
    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    //
    public Integer getStudyCount() {
        return studyCount;
    }

    //
    public void setStudyCount(Integer studyCount) {
        this.studyCount = studyCount;
    }

    //
    public Integer getWeight() {
        return weight;
    }

    //
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    //
    public String getBrief() {
        return brief;
    }

    //
    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }
}