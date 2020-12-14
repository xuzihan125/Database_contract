package com.contract.service.serviceImpl;
import com.contract.mybatis.dao.*;
import com.contract.mybatis.dto.*;
import com.contract.mybatis.entity.*;
import com.contract.mybatis.vo.*;
import com.contract.service.SelectService;
import com.contract.util.exception.ErrorCode;
import com.contract.util.tools.SelectAuthorityTools;
import com.contract.util.tools.StringTools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SelectServiceImpl implements SelectService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private FunctionMapper functionMapper;
    @Resource
    private LogServiceImpl logService;
    @Resource
    private ContractMapper contractMapper;
    @Resource
    private ContractProcessMapper contractProcessMapper;
    @Resource
    private ContractStateMapper contractStateMapper;
    @Resource
    private SelectAuthorityTools right;
//---------------------------------------查询用户------------------------------------->
    @Override
    public SelectUserVO selectuser(SelectUserDTO dto,String opnum) {
        SelectUserVO vo = new SelectUserVO();
        //查权限

        boolean b=right.selectAuthority(opnum,"14");
        //没权限
        if(!b){
            vo.setState(false);
            vo.setFeedBack(ErrorCode.INVALID_OPERATION.getName());
        }
        //有权限
        else {
            //验证是否为空
            if (dto == null || StringTools.isEmpty(dto.getName())) {
                vo.setState(false);
                vo.setFeedBack(ErrorCode.PARAM_ERROR.getName());
                return vo;
            }
            //设置检索条件
            UserExample example = new UserExample();
            //函数没起作用，只能查一模一样的
            //显示全部用户
            if(StringTools.isEmpty(dto.getName())&&StringTools.isEmpty(dto.getNum())){
                example.createCriteria().andNameIsNotNull();
            }
            else {
                //根据工号查
                if (StringTools.isEmpty(dto.getName())){
                    example.createCriteria().andUsernumLike("%"+dto.getNum()+"%");
                }
                //根据名字查
                else if(StringTools.isEmpty(dto.getNum())){
                    example.createCriteria().andNameLike("%"+dto.getName()+"%");
                }
                //根据两者查
                else{
                    example.createCriteria().andNameLike("%"+dto.getName()+"%").andUsernumLike("%"+dto.getNum()+"%");
                }
            }
            //检索
            List<User> entityList = userMapper.selectByExample(example);
            //查询结果为空
            if (entityList.isEmpty()) {
                vo.setState(false);
                vo.setFeedBack(ErrorCode.INVALID_SELECT.getName());
            }
            //查询成功
            else {
                List<String> num = new ArrayList<>();
                List<String> name= new ArrayList<>();
                for (User user : entityList) {
                    num.add(user.getUsernum());
                    name.add(user.getName());
                }
                vo.setState(true);
                vo.setFeedBack(ErrorCode.SUCCESS.getName());
                vo.setName(name);
                vo.setNum(num);
                //写日志
                logService.saveLog(opnum,"查询用户："+dto.getName());
            }
        }
        return vo;
    }

//---------------------------------------查询客户------------------------------------->
    @Override
    public SelectCustomerVO selectcustomer(SelectCustomerDTO dto, String opnum) {
        SelectCustomerVO vo = new SelectCustomerVO();
        //查权限
        boolean b= right.selectAuthority(opnum,"14");
        //没权限
        if(!b){
            vo.setState(false);
            vo.setFeedBack(ErrorCode.INVALID_OPERATION.getName());
        }
        //有权限
        else {
            //验证是否为空
            if (dto == null) {
                vo.setState(false);
                vo.setFeedBack(ErrorCode.PARAM_ERROR.getName());
                return vo;
            }
            //设置检索条件
            CustomerExample example = new CustomerExample();

            //函数没起作用，只能查一模一样的
            //显示全部客户
            if(StringTools.isEmpty(dto.getName())&&StringTools.isEmpty(dto.getPhone())){
                example.createCriteria().andNameIsNotNull();
            }
            else {
                //根据号码查
                if (StringTools.isEmpty(dto.getName())){
                    example.createCriteria().andTelLike("%"+dto.getPhone()+"%");
                }
                //根据名字查
                else if(StringTools.isEmpty(dto.getPhone())){
                    example.createCriteria().andNameLike("%"+dto.getName()+"%");
                }
                //根据两者查
                else{
                    example.createCriteria().andNameLike("%"+dto.getName()+"%").andTelLike("%"+dto.getPhone()+"%");
                }
            }
            //检索
            List<Customer> entityList = customerMapper.selectByExample(example);
            //查询结果为空
            if (entityList.isEmpty()) {
                vo.setState(false);
                vo.setFeedBack(ErrorCode.INVALID_SELECT.getName());
            }
            //查询成功
            else {
                List<String> name = new ArrayList<>();
                List<String> phone= new ArrayList<>();
                List<String> address = new ArrayList<>();
                List<String> fax = new ArrayList<>();
                List<String> code = new ArrayList<>();
                List<String> bank = new ArrayList<>();
                List<String> account = new ArrayList<>();
               //List<String> comment = new ArrayList<>();
                for (Customer customer : entityList) {
                    phone.add(customer.getTel());
                    name.add(customer.getName());
                    address.add(customer.getAddress());
                    fax.add(customer.getFax());
                    code.add(customer.getCode());
                    bank.add(customer.getBank());
                    account.add(customer.getAccount());
                }
                vo.setState(true);
                vo.setFeedBack(ErrorCode.SUCCESS.getName());
                vo.setName(name);
                vo.setPhone(phone);
                vo.setAddress(address);
                vo.setFax(fax);
                vo.setCode(code);
                vo.setBank(bank);
                vo.setAccount(account);
                //写日志
                logService.saveLog(opnum,"查询客户："+dto.getName()+dto.getPhone());
            }
        }
        return vo;
    }

//---------------------------------------查询功能------------------------------------->
    @Override
    public SelectFunctionVO selectfunction(SelectFunctionDTO dto, String opnum) {
        SelectFunctionVO vo = new SelectFunctionVO();
        //查权限
        boolean b=right.selectAuthority(opnum,"22");
        //没权限
        if(!b){
            vo.setState(false);
            vo.setFeedBack(ErrorCode.INVALID_OPERATION.getName());
        }
        //有权限
        else {
            //验证是否为空
            if (dto == null) {
                vo.setState(false);
                vo.setFeedBack(ErrorCode.PARAM_ERROR.getName());
                return vo;
            }
            //设置检索条件
            FunctionExample example = new FunctionExample();
            //函数没起作用，只能查一模一样的
            //显示全部用户
            if(StringTools.isEmpty(dto.getFunname())){
                example.createCriteria().andNameIsNotNull();
            }
            else {
                example.createCriteria().andNameLike("%"+dto.getFunname()+"%");
            }
            //检索
            List<Function> entityList = functionMapper.selectByExample(example);
            //查询结果为空
            if (entityList.isEmpty()) {
                vo.setState(false);
                vo.setFeedBack(ErrorCode.INVALID_SELECT.getName());
            }
            //查询成功
            else {
                List<String> funnum = new ArrayList<>();
                List<String> funname= new ArrayList<>();
                List<String> funURL= new ArrayList<>();
                List<String> description= new ArrayList<>();

                for (Function function : entityList) {
                    funnum.add(function.getNum());
                    funname.add(function.getName());
                    funURL.add(function.getUrl());
                    description.add(function.getDescription());
                }

                vo.setState(true);
                vo.setFeedBack(ErrorCode.SUCCESS.getName());
                vo.setFunnum(funnum);
                vo.setFunname(funname);
                vo.setFunURL(funURL);
                vo.setDescription(description);
                //写日志
                logService.saveLog(opnum,"查询功能："+dto.getFunname());
            }
        }
        return vo;
    }

//---------------------------------查询待分配的合同以及根据合同名模糊查询--------------------------------->
    @Override
    public SelectContractVO selectcontract(SelectContractOrStateDTO dto, String opnum) {
        SelectContractVO vo = new SelectContractVO();
        //查权限
        SelectAuthorityTools right=new SelectAuthorityTools();
        boolean b=right.selectAuthority(opnum,"3");//查看合同权限
        boolean b_1=right.selectAuthority(opnum,"8");//分配会签权限
        boolean b_2=right.selectAuthority(opnum,"9");//分配审批权限
        boolean b_3=right.selectAuthority(opnum,"10");//分配签订权

        //为空
        if (dto == null) {
            vo.setState(false);
            vo.setFeedBack(ErrorCode.PARAM_ERROR.getName());
            return vo;
        }
        else{
            //合同名为空，状态不是
            if(StringTools.isEmpty(dto.getConName())&&!StringTools.isEmpty(dto.getState())){
                //查待分配的合同,三种权限分别给显示待分配会签，待分配审批，待分配签订
                if(dto.getState().equals("0")) {

                    List<ContractProcess> entityList=new ArrayList<ContractProcess>();
                    List<ContractProcess> entityList1=new ArrayList<ContractProcess>();
                    List<ContractProcess> entityList2=new ArrayList<ContractProcess>();
                    ContractExample contractExample = new ContractExample();
                    contractExample.createCriteria().andNumIsNotNull();
                    List<Contract> entityList_1= contractMapper.selectByExample(contractExample);

                    if(b_1) {
                        ContractProcessExample contractProcessExample = new ContractProcessExample();
                        contractProcessExample.createCriteria().andTypeEqualTo(1);
                        entityList=contractProcessMapper.selectByExample(contractProcessExample);
                    }
                    if(b_2){
                        ContractProcessExample contractProcessExample = new ContractProcessExample();
                        contractProcessExample.createCriteria().andTypeEqualTo(2);
                        entityList1=contractProcessMapper.selectByExample(contractProcessExample);
                    }
                    if(b_3) {
                        ContractProcessExample contractProcessExample = new ContractProcessExample();
                        contractProcessExample.createCriteria().andTypeEqualTo(1);
                        entityList=contractProcessMapper.selectByExample(contractProcessExample);
                    }


                    List<String> num = new ArrayList<String>();
                    List<String> name = new ArrayList<String>();
                    List<Date> beginTime = new ArrayList<Date>();
                    //待分配会签
                    if(b_1) {
                        for (Contract contract : entityList_1) {
                            boolean c = false;
                            for (ContractProcess contract1 : entityList) {
                                if (contract.getNum().equals(contract1.getConnum()))
                                    c = true;
                            }
                            if (!c) {
                                num.add(contract.getNum());
                                name.add(contract.getName());
                                beginTime.add(contract.getBegintime());
                            }
                        }
                    }
                    //待分配审批
                    if(b_2) {
                        for (Contract contract : entityList_1) {
                            boolean c = false;
                            for (ContractProcess contract1 : entityList1) {
                                if (contract.getNum().equals(contract1.getConnum()))
                                    c = true;
                            }
                            if (!c) {
                                num.add(contract.getNum());
                                name.add(contract.getName());
                                beginTime.add(contract.getBegintime());
                            }
                        }
                    }
                    //待分配签订
                    if(b_1) {
                        for (Contract contract : entityList_1) {
                            boolean c = false;
                            for (ContractProcess contract1 : entityList2) {
                                if (contract.getNum().equals(contract1.getConnum()))
                                    c = true;
                            }
                            if (!c) {
                                num.add(contract.getNum());
                                name.add(contract.getName());
                                beginTime.add(contract.getBegintime());
                            }
                        }
                    }
                    //去掉重复的元素
                    for(int i=0;i<num.size()-1;i++){
                        for(int j=num.size()-1;j>i;j -- )  {
                            if  (num.get(j).equals(num.get(i)))  {
                                num.remove(j);
                                name.remove(j);
                                beginTime.remove(j);
                            }
                        }
                    }
                    vo.setState(true);
                    vo.setConNum(num);
                    vo.setConName(name);
                    vo.setBeginTime(beginTime);
                }
                //按流程查询合同
                else{
                    //有查询权限才可以
                    if(b){
                        ContractStateExample contractStateExample = new ContractStateExample();
                        contractStateExample.createCriteria().andTypeEqualTo(Integer.valueOf(dto.getState()));
                        List<ContractState> entityList = contractStateMapper.selectByExample(contractStateExample);

                        ContractExample contractExample = new ContractExample();
                        contractExample.createCriteria().andNumIsNotNull();
                        List<Contract> entityList_1 = contractMapper.selectByExample(contractExample);

                        List<String> num = new ArrayList<String>();
                        List<String> name = new ArrayList<String>();
                        List<Date> beginTime = new ArrayList<Date>();

                        for (Contract contract : entityList_1) {
                            boolean c = false;
                            for (ContractState contract1 : entityList) {
                                if (contract.getNum().equals(contract1.getConnum()))
                                    c = true;
                            }
                            if (c) {
                                num.add(contract.getNum());
                                name.add(contract.getName());
                                beginTime.add(contract.getBegintime());
                            }
                        }
                        vo.setState(true);
                        vo.setConNum(num);
                        vo.setConName(name);
                        vo.setBeginTime(beginTime);
                    }
                    else{
                        vo.setState(false);
                        vo.setFeedBack(ErrorCode.INVALID_OPERATION.getName());
                        return vo;
                    }
                }
            }
            else{
                //有查询权限才可以
                if(b) {
                    ContractExample contractExample = new ContractExample();
                    //查询全部合同，状态为空
                    if (StringTools.isEmpty(dto.getConName())) {
                        contractExample.createCriteria().andNumIsNotNull();
                    }
                    //按活动名模糊查询合同
                    else {
                        contractExample.createCriteria().andNameLike("%"+dto.getConName()+"%");
                    }
                    List<String> num = new ArrayList<String>();
                    List<String> name = new ArrayList<String>();
                    List<Date> beginTime = new ArrayList<Date>();
                    List<Contract> entityList = contractMapper.selectByExample(contractExample);
                    if (entityList.isEmpty()) {
                        vo.setState(true);
                    } else {
                        vo.setState(true);
                        for (Contract contract : entityList) {
                            num.add(contract.getNum());
                            name.add(contract.getName());
                            beginTime.add(contract.getBegintime());
                        }
                        vo.setFeedBack(ErrorCode.SUCCESS.getName());
                        vo.setConName(name);
                        vo.setConNum(num);
                        vo.setBeginTime(beginTime);
                    }
                }
                else{
                    vo.setState(false);
                    vo.setFeedBack(ErrorCode.INVALID_OPERATION.getName());
                    return vo;
                }
            }
            //写日志
            logService.saveLog(opnum,"查询合同："+dto.getState()+dto.getConName());
        }
        return vo;
    }

//---------------------------------------查询权限------------------------------------->
    @Override
    public SelectUserVO selectright(SelectRightDTO dto, String opnum) {
        SelectUserVO vo = new SelectUserVO();
        //查权限
        boolean b_1=right.selectAuthority(opnum,"8");//分配会签权限
        boolean b_2=right.selectAuthority(opnum,"9");//分配审批权限
        boolean b_3=right.selectAuthority(opnum,"10");//分配签订权限

        //为空
        if (dto == null||StringTools.isEmpty(dto.getRight())) {
            vo.setState(false);
            vo.setFeedBack(ErrorCode.PARAM_ERROR.getName());
            return  vo;
        }
        else {
            //判断合同是否存在
            ContractExample contractExample=new ContractExample();
            contractExample.createCriteria().andNumEqualTo(dto.getConNum());

            if(contractMapper.selectByExample(contractExample).isEmpty()){
                vo.setState(false);
                vo.setFeedBack(ErrorCode.INVLID_SELECTCONTRACT.getName());
                return vo;
            }
            //查有会签权限的操作员
            if (dto.getRight().equals("1")) {
                //该管理员有操作权限
                if (b_1) {
                    ContractProcessExample contractProcessExample = new ContractProcessExample();
                    contractProcessExample.createCriteria().andConnumEqualTo(dto.getConNum()).andTypeEqualTo(1);
                    List<ContractProcess> entityList = contractProcessMapper.selectByExample(contractProcessExample);
                    //可以查看
                    if (entityList.isEmpty()) {
                        List<String> num = new ArrayList<String>();
                        List<String> name = new ArrayList<String>();
                        UserExample example = new UserExample();
                        example.createCriteria().andUsernumIsNotNull();
                        List<User> userList = userMapper.selectByExample(example);
                        for (User user : userList) {
                            boolean d = right.selectAuthority(user.getUsernum(), "5");
                            if (d) {
                                num.add(user.getUsernum());
                                name.add(user.getName());
                            }
                        }
                        vo.setState(true);
                        vo.setFeedBack(ErrorCode.SUCCESS.getName());
                        vo.setNum(num);
                        vo.setName(name);
                    }
                    //已经分配过了
                    else {
                        vo.setState(false);
                        vo.setFeedBack(ErrorCode.INVLID_SELECTRIGHT.getName());
                    }
                } else {
                    vo.setState(false);
                    vo.setFeedBack(ErrorCode.INVALID_OPERATION.getName());
                }
            }

            //查有审批权限的操作员
            if (dto.getRight().equals("2")) {
                //该管理员有操作权限
                if (b_2) {

                    ContractProcessExample contractProcessExample = new ContractProcessExample();
                    contractProcessExample.createCriteria().andConnumEqualTo(dto.getConNum()).andTypeEqualTo(2);
                    List<ContractProcess> entityList = contractProcessMapper.selectByExample(contractProcessExample);
                    //可以查看
                    if (entityList.isEmpty()) {
                        List<String> num = new ArrayList<String>();
                        List<String> name = new ArrayList<String>();
                        UserExample example = new UserExample();
                        example.createCriteria().andUsernumIsNotNull();
                        List<User> userList = userMapper.selectByExample(example);
                        for (User user : userList) {
                            boolean d = right.selectAuthority(user.getUsernum(), "6");
                            if (d) {
                                num.add(user.getUsernum());
                                name.add(user.getName());
                            }
                        }
                        vo.setState(true);
                        vo.setFeedBack(ErrorCode.SUCCESS.getName());
                        vo.setNum(num);
                        vo.setName(name);
                    }
                    //已经分配过了
                    else {
                        vo.setState(false);
                        vo.setFeedBack(ErrorCode.INVLID_SELECTRIGHT.getName());
                    }
                } else {
                    vo.setState(false);
                    vo.setFeedBack(ErrorCode.INVALID_OPERATION.getName());
                }
            }

            //查有审批权限的操作员
            if (dto.getRight().equals("3")) {
                //该管理员有操作权限
                if (b_3) {

                    ContractProcessExample contractProcessExample = new ContractProcessExample();
                    contractProcessExample.createCriteria().andConnumEqualTo(dto.getConNum()).andTypeEqualTo(3);
                    List<ContractProcess> entityList = contractProcessMapper.selectByExample(contractProcessExample);
                    //可以查看
                    if (entityList.isEmpty()) {
                        List<String> num = new ArrayList<String>();
                        List<String> name = new ArrayList<String>();
                        UserExample example = new UserExample();
                        example.createCriteria().andUsernumIsNotNull();
                        List<User> userList = userMapper.selectByExample(example);
                        for (User user : userList) {
                            boolean d = right.selectAuthority(user.getUsernum(), "7");
                            if (d) {
                                num.add(user.getUsernum());
                                name.add(user.getName());
                            }
                        }
                        vo.setState(true);
                        vo.setFeedBack(ErrorCode.SUCCESS.getName());
                        vo.setNum(num);
                        vo.setName(name);
                    }
                    //已经分配过了
                    else {
                        vo.setState(false);
                        vo.setFeedBack(ErrorCode.INVLID_SELECTRIGHT.getName());
                    }
                } else {
                    vo.setState(false);
                    vo.setFeedBack(ErrorCode.INVALID_OPERATION.getName());
                }
            }
        }
        //写日志
        logService.saveLog(opnum,"查询操作员：合同号："+dto.getConNum()+"操作类型："+dto.getRight());
        return vo;
    }

//---------------------------------------查询待**的合同------------------------------------->
    @Override
    public SelectContractVO selectcontracttouser(SelectContectToUserDTO dto, String opnum) {
        SelectContractVO vo = new SelectContractVO();
        if (dto.getType().isEmpty()) {
            vo.setState(false);
            vo.setFeedBack(ErrorCode.PARAM_ERROR.getName());
            return vo;
        } else {
            if (dto.getType().equals("1")) {
                ContractProcessExample contractProcessExample = new ContractProcessExample();
                contractProcessExample.createCriteria().andUsernumEqualTo(opnum).andTypeEqualTo(1).andStateEqualTo(0);
                List<ContractProcess> contractProcesses = contractProcessMapper.selectByExample(contractProcessExample);


                List<String> num = new ArrayList<String>();
                List<String> name = new ArrayList<String>();
                List<Date> beginTime = new ArrayList<Date>();
                for (ContractProcess contractProcess : contractProcesses) {
                    ContractStateExample contractStateExample = new ContractStateExample();
                    contractStateExample.createCriteria().andConnumEqualTo(contractProcess.getConnum()).andTypeEqualTo(1);
                    if (!contractStateMapper.selectByExample(contractStateExample).isEmpty()) {
                        ContractExample contractExample = new ContractExample();
                        contractExample.createCriteria().andNumEqualTo(contractProcess.getConnum());
                        Contract contract = contractMapper.selectByExample(contractExample).get(0);
                        num.add(contract.getNum());
                        name.add(contract.getName());
                        beginTime.add(contract.getBegintime());
                    }
                }
                vo.setState(true);
                vo.setFeedBack(ErrorCode.SUCCESS.getName());
                vo.setConNum(num);
                vo.setConName(name);
                vo.setBeginTime(beginTime);
            }
            else if (dto.getType().equals("2")) {
                ContractExample contractExample = new ContractExample();
                contractExample.createCriteria().andUsernumEqualTo(opnum);
                List<Contract> contracts = contractMapper.selectByExample(contractExample);
                List<String> num = new ArrayList<String>();
                List<String> name = new ArrayList<String>();
                List<Date> beginTime = new ArrayList<Date>();
                for (Contract contract : contracts) {
                    ContractStateExample contractStateExample = new ContractStateExample();
                    contractStateExample.createCriteria().andConnumEqualTo(contract.getNum()).andTypeEqualTo(2);
                    if (!contractStateMapper.selectByExample(contractStateExample).isEmpty()) {
                        num.add(contract.getNum());
                        name.add(contract.getName());
                        beginTime.add(contract.getBegintime());
                    }
                }
                vo.setState(true);
                vo.setFeedBack(ErrorCode.SUCCESS.getName());
                vo.setConNum(num);
                vo.setConName(name);
                vo.setBeginTime(beginTime);
            }
            else if (dto.getType().equals("3")) {
                ContractProcessExample contractProcessExample = new ContractProcessExample();
                contractProcessExample.createCriteria().andUsernumEqualTo(opnum).andTypeEqualTo(2).andStateEqualTo(0);
                List<ContractProcess> contractProcesses = contractProcessMapper.selectByExample(contractProcessExample);
                List<String> num = new ArrayList<String>();
                List<String> name = new ArrayList<String>();
                List<Date> beginTime = new ArrayList<Date>();
                for (ContractProcess contractProcess : contractProcesses) {
                    ContractStateExample contractStateExample = new ContractStateExample();
                    contractStateExample.createCriteria().andConnumEqualTo(contractProcess.getConnum()).andTypeEqualTo(3);
                    if (!contractStateMapper.selectByExample(contractStateExample).isEmpty()) {
                        ContractExample contractExample = new ContractExample();
                        contractExample.createCriteria().andNumEqualTo(contractProcess.getConnum());
                        Contract contract = contractMapper.selectByExample(contractExample).get(0);
                        num.add(contract.getNum());
                        name.add(contract.getName());
                        beginTime.add(contract.getBegintime());
                    }
                }
                vo.setState(true);
                vo.setFeedBack(ErrorCode.SUCCESS.getName());
                vo.setConNum(num);
                vo.setConName(name);
                vo.setBeginTime(beginTime);
            }
            else if (dto.getType().equals("4")) {
                ContractProcessExample contractProcessExample = new ContractProcessExample();
                contractProcessExample.createCriteria().andUsernumEqualTo(opnum).andTypeEqualTo(3).andStateEqualTo(0);
                List<ContractProcess> contractProcesses = contractProcessMapper.selectByExample(contractProcessExample);
                List<String> num = new ArrayList<String>();
                List<String> name = new ArrayList<String>();
                List<Date> beginTime = new ArrayList<Date>();
                for (ContractProcess contractProcess : contractProcesses) {
                    ContractStateExample contractStateExample = new ContractStateExample();
                    contractStateExample.createCriteria().andConnumEqualTo(contractProcess.getConnum()).andTypeEqualTo(4);
                    if (!contractStateMapper.selectByExample(contractStateExample).isEmpty()) {
                        ContractExample contractExample = new ContractExample();
                        contractExample.createCriteria().andNumEqualTo(contractProcess.getConnum());
                        Contract contract = contractMapper.selectByExample(contractExample).get(0);
                        num.add(contract.getNum());
                        name.add(contract.getName());
                        beginTime.add(contract.getBegintime());
                    }
                }
                vo.setState(true);
                vo.setFeedBack(ErrorCode.SUCCESS.getName());
                vo.setConNum(num);
                vo.setConName(name);
                vo.setBeginTime(beginTime);
            }
        }
        //写日志
        logService.saveLog(opnum,"查询待当前操作员操作的合同");
     return vo;
    }

//---------------------------------------查询合同具体内容------------------------------------->
    @Override
    public SelectContentVO selectcontent(SelectContentDTO dto, String opnum) {
        SelectContentVO vo = new SelectContentVO();

        //验证是否为空
        if (dto == null ||StringTools.isEmpty(dto.getConNum())) {
            vo.setState(false);
            vo.setFeedBack(ErrorCode.PARAM_ERROR.getName());
            return vo;
        }

        //设置检索条件
        ContractExample example = new ContractExample();
        example.createCriteria().andNumEqualTo(dto.getConNum());
        List<Contract> contracts=contractMapper.selectByExampleWithBLOBs(example);
        if(contracts.isEmpty()) {
            vo.setState(false);
            vo.setFeedBack(ErrorCode.INVLID_SELECTCONTRACT.getName());
            return vo;
        }
        //查询成功
        else{
            vo.setState(true);
            vo.setFeedBack(ErrorCode.SUCCESS.getName());
            vo.setConNum(contracts.get(0).getNum());
            vo.setCustomer(contracts.get(0).getCustomer());
            vo.setContent(contracts.get(0).getContent());
            vo.setBeginTime(contracts.get(0).getBegintime());
            vo.setEndTime(contracts.get(0).getEndtime());
            vo.setUserNum(contracts.get(0).getUsernum());
            //写日志
            logService.saveLog(opnum,"查询合同详细内容：");
        }
        return vo;
    }
}


