package com.contract.Exception;

import com.contract.mybatis.vo.ErrorVO;
import com.contract.util.emnu.ResultCode;
import com.contract.util.exception.ActException;
import com.contract.util.exception.ErrorCode;
import com.contract.util.message.JsonMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ActExceptionHandler extends SimpleControllerHandlerAdapter {

    @ResponseBody
    @ExceptionHandler(ActException.class)
    public ErrorVO exceptionHandler(ActException e){
        ErrorVO errorVO = new ErrorVO();
        errorVO.setState(false);
        errorVO.setFeedBack(e.getMessage());
        return errorVO;
    }

//    @ResponseBody
//    @ExceptionHandler(value= Exception.class)
//    public JsonMessage<Object> exceptionHandler(HttpServletRequest req, Exception e){
//        return new JsonMessage<Object>(null,ErrorCode.DEFAULT.getCode(),e.getMessage());
//    }
}
