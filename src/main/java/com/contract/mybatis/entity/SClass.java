package com.contract.mybatis.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class SClass implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CLASS.CLASSNO
     *
     * @mbggenerated
     */
    private String classno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CLASS.CLASSNAME
     *
     * @mbggenerated
     */
    private String classname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CLASS.CLASSMAJOR
     *
     * @mbggenerated
     */
    private String classmajor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CLASS.CLASSDEPT
     *
     * @mbggenerated
     */
    private String classdept;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CLASS.STUDENTNUMBER
     *
     * @mbggenerated
     */
    private BigDecimal studentnumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table CLASS
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CLASS.CLASSNO
     *
     * @return the value of CLASS.CLASSNO
     *
     * @mbggenerated
     */
    public String getClassno() {
        return classno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CLASS.CLASSNO
     *
     * @param classno the value for CLASS.CLASSNO
     *
     * @mbggenerated
     */
    public void setClassno(String classno) {
        this.classno = classno == null ? null : classno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CLASS.CLASSNAME
     *
     * @return the value of CLASS.CLASSNAME
     *
     * @mbggenerated
     */
    public String getClassname() {
        return classname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CLASS.CLASSNAME
     *
     * @param classname the value for CLASS.CLASSNAME
     *
     * @mbggenerated
     */
    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CLASS.CLASSMAJOR
     *
     * @return the value of CLASS.CLASSMAJOR
     *
     * @mbggenerated
     */
    public String getClassmajor() {
        return classmajor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CLASS.CLASSMAJOR
     *
     * @param classmajor the value for CLASS.CLASSMAJOR
     *
     * @mbggenerated
     */
    public void setClassmajor(String classmajor) {
        this.classmajor = classmajor == null ? null : classmajor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CLASS.CLASSDEPT
     *
     * @return the value of CLASS.CLASSDEPT
     *
     * @mbggenerated
     */
    public String getClassdept() {
        return classdept;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CLASS.CLASSDEPT
     *
     * @param classdept the value for CLASS.CLASSDEPT
     *
     * @mbggenerated
     */
    public void setClassdept(String classdept) {
        this.classdept = classdept == null ? null : classdept.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CLASS.STUDENTNUMBER
     *
     * @return the value of CLASS.STUDENTNUMBER
     *
     * @mbggenerated
     */
    public BigDecimal getStudentnumber() {
        return studentnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CLASS.STUDENTNUMBER
     *
     * @param studentnumber the value for CLASS.STUDENTNUMBER
     *
     * @mbggenerated
     */
    public void setStudentnumber(BigDecimal studentnumber) {
        this.studentnumber = studentnumber;
    }
}