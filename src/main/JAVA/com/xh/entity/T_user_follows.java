package com.xh.entity;

import java.util.Date;
//用户关注表
public class T_user_follows {
    //
    private Integer id;

    //用户id
    private Integer userId;

    //关注的用户id
    private Integer followId;

    //创建时间
    private Date createTime;

    //关注用户名
    private String followName;

    @Override
    public String toString() {
        return "T_user_follows{" +
                "id=" + id +
                ", userId=" + userId +
                ", followId=" + followId +
                ", createTime=" + createTime +
                ", followName='" + followName + '\'' +
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
    public Integer getUserId() {
        return userId;
    }

    //
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    //
    public Integer getFollowId() {
        return followId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_follows.follow_id
     *
     * @param followId the value for t_user_follows.follow_id
     *
     * @mbg.generated Tue Aug 14 20:19:50 CST 2018
     */
    public void setFollowId(Integer followId) {
        this.followId = followId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_follows.create_time
     *
     * @return the value of t_user_follows.create_time
     *
     * @mbg.generated Tue Aug 14 20:19:50 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_follows.create_time
     *
     * @param createTime the value for t_user_follows.create_time
     *
     * @mbg.generated Tue Aug 14 20:19:50 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_follows.follow_name
     *
     * @return the value of t_user_follows.follow_name
     *
     * @mbg.generated Tue Aug 14 20:19:50 CST 2018
     */
    public String getFollowName() {
        return followName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_follows.follow_name
     *
     * @param followName the value for t_user_follows.follow_name
     *
     * @mbg.generated Tue Aug 14 20:19:50 CST 2018
     */
    public void setFollowName(String followName) {
        this.followName = followName == null ? null : followName.trim();
    }
}