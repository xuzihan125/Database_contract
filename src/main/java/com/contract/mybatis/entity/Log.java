package com.contract.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column log.userNum
     *
     * @mbggenerated
     */
    private String usernum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column log.time
     *
     * @mbggenerated
     */
    private Date time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column log.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table log
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.userNum
     *
     * @return the value of log.userNum
     *
     * @mbggenerated
     */
    public String getUsernum() {
        return usernum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column log.userNum
     *
     * @param usernum the value for log.userNum
     *
     * @mbggenerated
     */
    public void setUsernum(String usernum) {
        this.usernum = usernum == null ? null : usernum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.time
     *
     * @return the value of log.time
     *
     * @mbggenerated
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column log.time
     *
     * @param time the value for log.time
     *
     * @mbggenerated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.content
     *
     * @return the value of log.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column log.content
     *
     * @param content the value for log.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}