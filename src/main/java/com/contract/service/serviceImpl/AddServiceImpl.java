package com.contract.service.serviceImpl;

import com.contract.mybatis.dao.*;
import com.contract.mybatis.dto.AddContractDTO;
import com.contract.mybatis.dto.AddCustomerDTO;
import com.contract.mybatis.dto.CountersignDTO;
import com.contract.mybatis.entity.*;
import com.contract.mybatis.vo.RegisterVO;
import com.contract.service.AddService;
import com.contract.util.emnu.EnumCamp;
import com.contract.util.exception.ActException;
import com.contract.util.exception.ErrorCode;
import com.contract.util.tools.SelectAuthorityTools;
import com.contract.util.tools.StringTools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AddServiceImpl implements AddService {
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private LogMapper logMapper;
    @Resource
    private ContractMapper contractMapper;
    @Resource
    private ContractStateMapper contractStateMapper;
    @Resource
    private ContractAttachmentMapper contractAttachmentMapper;
    @Resource
    private ContractProcessMapper contractProcessMapper;
    @Resource
    private SelectAuthorityTools right;
//---------------------------------------添加客户------------------------------------->
    @Override
    public RegisterVO AddCustomer(AddCustomerDTO dto, String opnum) {
        RegisterVO vo = new RegisterVO();
        //查权限
        boolean b=true;
        right.selectAuthority(opnum,"25");
        //没权限
        if(!b){
            vo.setState(false);
            vo.setFeedBack(ErrorCode.INVALID_OPERATION.getName());
        }
        else {
            //验证是否为空
            if (dto == null || StringTools.isEmpty(dto.getName())||StringTools.isEmpty(dto.getPhone())||StringTools.isEmpty(dto.getAddress())) {
                vo.setState(false);
                vo.setFeedBack(ErrorCode.PARAM_ERROR.getName());
                return vo;
            }
            //客户名和电话都重复的话默认是一个人，不能再插入了
            CustomerExample example = new CustomerExample();
            example.createCriteria().andNameEqualTo(dto.getName()).andTelEqualTo(dto.getPhone());
            //检索
            List<Customer> entityList = customerMapper.selectByExample(example);
            //想要添加的客户不存在，可以插入该客户
            if (entityList.isEmpty()) {
                Customer customer=new Customer();
                customer.setName(dto.getName());
                customer.setTel(dto.getPhone());
                customer.setAddress(dto.getAddress());
                customer.setFax(dto.getFax());
                customer.setCode(dto.getCode());
                customer.setBank(dto.getBank());
                customer.setAccount(dto.getAccount());
                Date date=new Date();
                customer.setNum(date.toString());
                customerMapper.insert(customer);

                vo.setState(true);
                vo.setFeedBack(ErrorCode.SUCCESS.getName());
                //写日志
                Log log = new Log();
                log.setUsernum(opnum);
                log.setTime(new Date());
                log.setContent("添加客户：" + dto.getName());
                logMapper.insert(log);
            }
            else {
                vo.setState(false);
                vo.setFeedBack(ErrorCode.INVLID_ADDCUSTOMER.getName());
            }
        }
        return vo;
    }

//---------------------------------------起草合同------------------------------------->
    @Override
    public RegisterVO AddContract(AddContractDTO dto, String opnum) {
        RegisterVO vo = new RegisterVO();
        //查权限
        boolean b=true;
        right.selectAuthority(opnum,"1");
        //没权限
        if(!b){
            vo.setState(false);
            vo.setFeedBack(ErrorCode.INVALID_OPERATION.getName());
        }
        else {
            //验证是否为空，只有后两个可以空
            if (dto == null || StringTools.isEmpty(dto.getName())||StringTools.isEmpty(dto.getCustomer()) ||StringTools.isEmpty(dto.getBeginTime())||StringTools.isEmpty(dto.getEndTime())||StringTools.isEmpty(dto.getContent())) {
                vo.setState(false);
                vo.setFeedBack(ErrorCode.PARAM_ERROR.getName());
                return vo;
            }
            if((StringTools.isEmpty(dto.getFilename())&&!StringTools.isEmpty(dto.getType()))
                    ||(!StringTools.isEmpty(dto.getFilename())&&StringTools.isEmpty(dto.getType()))){
                vo.setState(false);
                vo.setFeedBack(ErrorCode.PARAM_ERROR.getName());
                return vo;
            }
            //假设合同名和客户名都重复就算是同一个合同
            ContractExample example = new ContractExample();
            example.createCriteria().andNameEqualTo(dto.getName()).andCustomerEqualTo(dto.getCustomer());
            //检索
            List<Contract> entityList = contractMapper.selectByExample(example);
            //想要添加的客户不存在，可以插入该客户
            if (entityList.isEmpty()) {
                Contract contract=new Contract();
                contract.setName(dto.getName());
                contract.setCustomer(dto.getCustomer());
                try{
                    contract.setBegintime(EnumCamp.DateFormate.NORMAL.getFormate().parse(dto.getBeginTime()));
                    contract.setEndtime(EnumCamp.DateFormate.NORMAL.getFormate().parse(dto.getBeginTime()));
                }
                catch(Exception e){
                    throw new ActException(ErrorCode.INVLID_TIME_FORMATE.getCode(),ErrorCode.INVLID_TIME_FORMATE.getName());
                }
                contract.setUsernum(opnum);
                contract.setContent(dto.getContent());

                Calendar cal = Calendar.getInstance();
                Date date=new Date();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH )+1;
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int minute = cal.get(Calendar.MINUTE);
                int second = cal.get(Calendar.SECOND);
                String num=year+"-"+month+"-"+day+"-"+hour+"-"+minute+"-"+second+"-"+opnum;
                contract.setNum(num);
                contractMapper.insert(contract);

                ContractState state=new ContractState();
                state.setConnum(num);
                state.setType(1);
                state.setTime(date);
                contractStateMapper.insert(state);

                //有附件
                if(!StringTools.isEmpty(dto.getFilename())&&!StringTools.isEmpty(dto.getType())){
                    ContractAttachment attachment=new ContractAttachment();
                    attachment.setConnum(num);
                    attachment.setFilename(dto.getFilename());
                    attachment.setType(dto.getType());
                    contractAttachmentMapper.insert(attachment);
                }

                vo.setState(true);
                vo.setFeedBack(ErrorCode.SUCCESS.getName());
                //写日志
                Log log = new Log();
                log.setUsernum(opnum);
                log.setTime(new Date());
                log.setContent("添加合同：" + dto.getName());
                logMapper.insert(log);
            }
            else {
                vo.setState(false);
                vo.setFeedBack(ErrorCode.INVLID_ADDCONTRACT.getName());
            }
        }
        return vo;
    }

//---------------------------------------添加会签------------------------------------->
    @Override
    public RegisterVO AddCountersign(CountersignDTO dto, String opnum) throws ParseException {
        RegisterVO vo = new RegisterVO();

        //验证是否为空
        if (dto == null || StringTools.isEmpty(dto.getContent())||StringTools.isEmpty(dto.getConNum())) {
            vo.setState(false);
            vo.setFeedBack(ErrorCode.PARAM_ERROR.getName());
            return vo;
        }
        //设置检索条件
        ContractProcessExample contractProcessExample=new ContractProcessExample();
        contractProcessExample.createCriteria().andConnumEqualTo(dto.getConNum()).andTypeEqualTo(1).andUsernumEqualTo(opnum).andStateEqualTo(1);
        //检索
        List<ContractProcess> entityList = contractProcessMapper.selectByExample(contractProcessExample);
        //不存在
        if (entityList.isEmpty()) {
            vo.setState(false);
            vo.setFeedBack(ErrorCode.INVLID_SELECTCONTRACT.getName());
        }
        else {
            ContractProcess old_con = entityList.get(0); //旧的
            ContractProcess new_con = new ContractProcess();
            new_con.setState(1);
            new_con.setConnum(old_con.getConnum());
            new_con.setContent(dto.getContent());
            new_con.setUsernum(old_con.getUsernum());
            new_con.setType(old_con.getType());
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s = df.format(date);
            Date d=df.parse(s);
            new_con.setTime(d);
            contractProcessMapper.updateByExampleWithBLOBs(new_con, contractProcessExample);
            vo.setState(true);
            vo.setFeedBack(ErrorCode.SUCCESS.getName());
            //写日志
            Log log = new Log();
            log.setUsernum(opnum);
            log.setTime(new Date());
            log.setContent("当前操作员完成会签：" + dto.getConNum());
            logMapper.insert(log);
        }
        return vo;
    }
}
