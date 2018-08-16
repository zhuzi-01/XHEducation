package com.xh.entity;
///课程章节表
public class T_course_section {
    //
    private Integer id;

    //归属课程id
    private Integer courseId;

    //父章节id
    private Integer parentId;

    //章节名称
    private String name;

    //时长
    private String time;

    //课程章节表
    private String videoUrl;

    //
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_course_section.id
     *
     * @param id the value for t_course_section.id
     *
     * @mbg.generated Tue Aug 14 20:19:50 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_course_section.course_id
     *
     * @return the value of t_course_section.course_id
     *
     * @mbg.generated Tue Aug 14 20:19:50 CST 2018
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_course_section.course_id
     *
     * @param courseId the value for t_course_section.course_id
     *
     * @mbg.generated Tue Aug 14 20:19:50 CST 2018
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_course_section.parent_id
     *
     * @return the value of t_course_section.parent_id
     *
     * @mbg.generated Tue Aug 14 20:19:50 CST 2018
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_course_section.parent_id
     *
     * @param parentId the value for t_course_section.parent_id
     *
     * @mbg.generated Tue Aug 14 20:19:50 CST 2018
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_course_section.name
     *
     * @return the value of t_course_section.name
     *
     * @mbg.generated Tue Aug 14 20:19:50 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_course_section.name
     *
     * @param name the value for t_course_section.name
     *
     * @mbg.generated Tue Aug 14 20:19:50 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_course_section.time
     *
     * @return the value of t_course_section.time
     *
     * @mbg.generated Tue Aug 14 20:19:50 CST 2018
     */
    public String getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_course_section.time
     *
     * @param time the value for t_course_section.time
     *
     * @mbg.generated Tue Aug 14 20:19:50 CST 2018
     */
    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_course_section.video_url
     *
     * @return the value of t_course_section.video_url
     *
     * @mbg.generated Tue Aug 14 20:19:50 CST 2018
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_course_section.video_url
     *
     * @param videoUrl the value for t_course_section.video_url
     *
     * @mbg.generated Tue Aug 14 20:19:50 CST 2018
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }
}