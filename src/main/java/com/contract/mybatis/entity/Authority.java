package com.contract.mybatis.entity;

import java.io.Serializable;

public class Authority implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authority.userNum
     *
     * @mbggenerated
     */
    private String usernum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authority.roleName
     *
     * @mbggenerated
     */
    private String rolename;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authority.description
     *
     * @mbggenerated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authority.roleNum
     *
     * @mbggenerated
     */
    private String rolenum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table authority
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authority.userNum
     *
     * @return the value of authority.userNum
     *
     * @mbggenerated
     */
    public String getUsernum() {
        return usernum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authority.userNum
     *
     * @param usernum the value for authority.userNum
     *
     * @mbggenerated
     */
    public void setUsernum(String usernum) {
        this.usernum = usernum == null ? null : usernum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authority.roleName
     *
     * @return the value of authority.roleName
     *
     * @mbggenerated
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authority.roleName
     *
     * @param rolename the value for authority.roleName
     *
     * @mbggenerated
     */
    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authority.description
     *
     * @return the value of authority.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authority.description
     *
     * @param description the value for authority.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authority.roleNum
     *
     * @return the value of authority.roleNum
     *
     * @mbggenerated
     */
    public String getRolenum() {
        return rolenum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authority.roleNum
     *
     * @param rolenum the value for authority.roleNum
     *
     * @mbggenerated
     */
    public void setRolenum(String rolenum) {
        this.rolenum = rolenum == null ? null : rolenum.trim();
    }
}