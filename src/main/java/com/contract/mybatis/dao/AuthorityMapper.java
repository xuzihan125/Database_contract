package com.contract.mybatis.dao;

import com.contract.mybatis.entity.Authority;
import com.contract.mybatis.entity.AuthorityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthorityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authority
     *
     * @mbggenerated
     */
    int countByExample(AuthorityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authority
     *
     * @mbggenerated
     */
    int deleteByExample(AuthorityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authority
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String usernum);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authority
     *
     * @mbggenerated
     */
    int insert(Authority record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authority
     *
     * @mbggenerated
     */
    int insertSelective(Authority record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authority
     *
     * @mbggenerated
     */
    List<Authority> selectByExample(AuthorityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authority
     *
     * @mbggenerated
     */
    Authority selectByPrimaryKey(String usernum);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authority
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Authority record, @Param("example") AuthorityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authority
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Authority record, @Param("example") AuthorityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authority
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Authority record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authority
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Authority record);
}