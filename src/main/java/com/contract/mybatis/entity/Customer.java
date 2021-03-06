package com.contract.mybatis.entity;

import java.io.Serializable;

public class Customer implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.num
     *
     * @mbggenerated
     */
    private String num;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.address
     *
     * @mbggenerated
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.tel
     *
     * @mbggenerated
     */
    private String tel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.fax
     *
     * @mbggenerated
     */
    private String fax;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.code
     *
     * @mbggenerated
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.bank
     *
     * @mbggenerated
     */
    private String bank;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.account
     *
     * @mbggenerated
     */
    private String account;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.comment
     *
     * @mbggenerated
     */
    private String comment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table customer
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.num
     *
     * @return the value of customer.num
     *
     * @mbggenerated
     */
    public String getNum() {
        return num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.num
     *
     * @param num the value for customer.num
     *
     * @mbggenerated
     */
    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.name
     *
     * @return the value of customer.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.name
     *
     * @param name the value for customer.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.address
     *
     * @return the value of customer.address
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.address
     *
     * @param address the value for customer.address
     *
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.tel
     *
     * @return the value of customer.tel
     *
     * @mbggenerated
     */
    public String getTel() {
        return tel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.tel
     *
     * @param tel the value for customer.tel
     *
     * @mbggenerated
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.fax
     *
     * @return the value of customer.fax
     *
     * @mbggenerated
     */
    public String getFax() {
        return fax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.fax
     *
     * @param fax the value for customer.fax
     *
     * @mbggenerated
     */
    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.code
     *
     * @return the value of customer.code
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.code
     *
     * @param code the value for customer.code
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.bank
     *
     * @return the value of customer.bank
     *
     * @mbggenerated
     */
    public String getBank() {
        return bank;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.bank
     *
     * @param bank the value for customer.bank
     *
     * @mbggenerated
     */
    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.account
     *
     * @return the value of customer.account
     *
     * @mbggenerated
     */
    public String getAccount() {
        return account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.account
     *
     * @param account the value for customer.account
     *
     * @mbggenerated
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.comment
     *
     * @return the value of customer.comment
     *
     * @mbggenerated
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.comment
     *
     * @param comment the value for customer.comment
     *
     * @mbggenerated
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}