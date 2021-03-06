package com.contract.mybatis.dao;

import com.contract.mybatis.entity.Function;
import com.contract.mybatis.entity.FunctionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunctionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table function
     *
     * @mbggenerated
     */
    int countByExample(FunctionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table function
     *
     * @mbggenerated
     */
    int deleteByExample(FunctionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table function
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String num);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table function
     *
     * @mbggenerated
     */
    int insert(Function record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table function
     *
     * @mbggenerated
     */
    int insertSelective(Function record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table function
     *
     * @mbggenerated
     */
    List<Function> selectByExample(FunctionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table function
     *
     * @mbggenerated
     */
    Function selectByPrimaryKey(String num);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table function
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Function record, @Param("example") FunctionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table function
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Function record, @Param("example") FunctionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table function
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Function record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table function
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Function record);
}