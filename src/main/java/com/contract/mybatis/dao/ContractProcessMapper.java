package com.contract.mybatis.dao;

import com.contract.mybatis.entity.ContractProcess;
import com.contract.mybatis.entity.ContractProcessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractProcessMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_process
     *
     * @mbggenerated
     */
    int countByExample(ContractProcessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_process
     *
     * @mbggenerated
     */
    int deleteByExample(ContractProcessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_process
     *
     * @mbggenerated
     */
    int insert(ContractProcess record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_process
     *
     * @mbggenerated
     */
    int insertSelective(ContractProcess record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_process
     *
     * @mbggenerated
     */
    List<ContractProcess> selectByExampleWithBLOBs(ContractProcessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_process
     *
     * @mbggenerated
     */
    List<ContractProcess> selectByExample(ContractProcessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_process
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ContractProcess record, @Param("example") ContractProcessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_process
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") ContractProcess record, @Param("example") ContractProcessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_process
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ContractProcess record, @Param("example") ContractProcessExample example);
}