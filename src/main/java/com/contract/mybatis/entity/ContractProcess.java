package com.contract.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class ContractProcess implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_process.conNum
     *
     * @mbggenerated
     */
    private String connum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_process.type
     *
     * @mbggenerated
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_process.state
     *
     * @mbggenerated
     */
    private Integer state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_process.userName
     *
     * @mbggenerated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_process.time
     *
     * @mbggenerated
     */
    private Date time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contract_process.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table contract_process
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_process.conNum
     *
     * @return the value of contract_process.conNum
     *
     * @mbggenerated
     */
    public String getConnum() {
        return connum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_process.conNum
     *
     * @param connum the value for contract_process.conNum
     *
     * @mbggenerated
     */
    public void setConnum(String connum) {
        this.connum = connum == null ? null : connum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_process.type
     *
     * @return the value of contract_process.type
     *
     * @mbggenerated
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_process.type
     *
     * @param type the value for contract_process.type
     *
     * @mbggenerated
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_process.state
     *
     * @return the value of contract_process.state
     *
     * @mbggenerated
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_process.state
     *
     * @param state the value for contract_process.state
     *
     * @mbggenerated
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_process.userName
     *
     * @return the value of contract_process.userName
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_process.userName
     *
     * @param username the value for contract_process.userName
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_process.time
     *
     * @return the value of contract_process.time
     *
     * @mbggenerated
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_process.time
     *
     * @param time the value for contract_process.time
     *
     * @mbggenerated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contract_process.content
     *
     * @return the value of contract_process.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contract_process.content
     *
     * @param content the value for contract_process.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}