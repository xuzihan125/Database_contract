package com.contract.util.exception;

/**
 * 创建人:张思远
 * 日期: 2020/5/27 上午10:22
 * 描述：code
 */
public enum ErrorCode {

	SUCCESS("act0", "成功"),
	LIST_COPY_ERROR("act-1", "数据复制异常"),
	PARAM_ERROR("act-2", "输入参数不能为空"),
	INVALID_LOGIN("act-3", "账号或密码不正确"),
	INVALID_Registr("act4","工号已存在！")
	;


	private String code;
	private String name;

	private ErrorCode(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String getCode() {
		return this.code;
	}

	public ErrorCode getCode(String code) {
		ErrorCode[] opCodes = ErrorCode.values();
		for (ErrorCode opCode : opCodes) {
			if (opCode.code.equals(code))
				return opCode;
		}
		return SUCCESS;
	}

}
