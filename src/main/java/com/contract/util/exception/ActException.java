package com.contract.util.exception;

import com.contract.util.emnu.ResultCode;

/**
 * 创建人:张思远
 * 日期: 2020/5/27 上午10:22
 * 描述：业务异常
 */
public class ActException extends RuntimeException {

    private static final long serialVersionUID = -418389432305176131L;
    private String retCode;


    public ActException() {
        // TODO Auto-generated constructor stub
    }

    public ActException(String retMsg) {//{errorCode:00001,retMsg:"kdjaeie"}
        super(retMsg);
    }

    public ActException(String retCode, String retMsg) {
        super(retMsg);
        this.retCode = retCode;
    }

    public ActException(ResultCode errorCode) {
        super(errorCode.getName());
        this.retCode = errorCode.getCode();
    }


    public ActException(String retMsg, Throwable e) {
        super(retMsg, e);
        // TODO Auto-generated constructor stub
    }

    public ActException(String retCode, String retMsg, Throwable e) {
        super(retMsg, e);
        this.retCode = retCode;
    }

    public ActException(Throwable t) {
        super(t);
    }

    public String getCode() {
        return retCode;
    }

}