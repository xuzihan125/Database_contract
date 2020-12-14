package com.contract.service.serviceImpl;

import com.contract.mybatis.dao.ContractProcessMapper;
import com.contract.mybatis.dao.LogMapper;
import com.contract.mybatis.dto.UsertoContractDTO;
import com.contract.mybatis.entity.ContractProcess;
import com.contract.mybatis.entity.Log;
import com.contract.mybatis.vo.RegisterVO;
import com.contract.service.DistributionService;
import com.contract.util.exception.ErrorCode;
import com.contract.util.tools.StringTools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DistributionServiceImpl implements DistributionService {
    @Resource
    private ContractProcessMapper contractProcessMapper;
    @Resource
    private LogMapper logMapper;
    @Override
    public RegisterVO usertocontract(UsertoContractDTO dto, String opnum) throws ParseException {
        RegisterVO vo = new RegisterVO();
        //验证是否为空
        if (dto == null || StringTools.isEmpty(dto.getConNum())||dto.getUserNum().isEmpty()||dto.getType().isEmpty()) {
            vo.setState(false);
            vo.setFeedBack(ErrorCode.PARAM_ERROR.getName());
            return vo;
        }
        if(dto.getType().size()!=dto.getUserNum().size()){
            vo.setState(false);
            vo.setFeedBack(ErrorCode.INVLID_INPUT.getName());
            return vo;
        }
        //将结果向process表插入
        for(int i=0;i<dto.getUserNum().size();i++) {
            ContractProcess contractProcess = new ContractProcess();
            contractProcess.setConnum(dto.getConNum());
            contractProcess.setUsernum(dto.getUserNum().get(i));
            contractProcess.setType(Integer.valueOf(dto.getType().get(i)));
            contractProcess.setState(0);
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s = df.format(date);
            Date d=df.parse(s);
            contractProcess.setTime(d);
            contractProcessMapper.insert(contractProcess);
        }
        vo.setState(true);
        vo.setFeedBack(ErrorCode.SUCCESS.getName());
        //写日志
        Log log = new Log();
        log.setUsernum(opnum);
        log.setTime(new Date());
        log.setContent("分配权限：" + dto.getConNum());
        logMapper.insert(log);

        return vo;
    }
}
