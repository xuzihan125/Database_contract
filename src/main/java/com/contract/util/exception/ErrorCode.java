package com.contract.util.exception;

/**
 * 创建人:张思远
 * 日期: 2020/5/27 上午10:22
 * 描述：code
 */
public enum ErrorCode {

	DEFAULT("act-x","未知错误"),
	SUCCESS("act0", "成功"),
	LIST_COPY_ERROR("act-1", "数据复制异常"),
	PARAM_ERROR("act-2", "输入参数不能为空"),
	INVALID_LOGIN("act-3", "账号或密码不正确"),
	INVALID_Registr("act4","工号已存在！"),
	INVALID_CHANGEPASD("act5","工号不存在"),
	INVALID_OPERATION("act6","没有此操作权限，请联系管理员进行授权！"),
	INVALID_SELECT("act7","查询结果为空"),
	INVLID_ADDCUSTOMER("act8","客户已存在"),
	INVLID_DELETECUSTOMER("act9","客户不存在"),
	INVLID_ADDCONTRACT("act9","合同已存在"),
	INVLID_SELECTRIGHT("act10","合同已分配操作员"),
	INVLID_SELECTCONTRACT("act11","合同不存在"),
	INVLID_INPUT("act12","输入长度不相等"),
	INVLID_TIME_FORMATE("act13","输入时间格式错误"),
	LOG_ERROR("act14","日志记录错误"),
	MISSING_FILE("act15","文件不存在"),
	LOSS_FILE("act16","文件库缺失"),
	CONNECTION_ERROR("act17","连接错误"),
	DUPLICATE_FILE("act18","同名文件已存在"),
	ROLE_ALREADY_EXIST("act19","角色已存在"),
	ROLE_NOT_EXIST("act20","角色不存在"),
	AUTHO_ALREADY_EXIST("act21","授权已存在"),
	AUTHO_NOT_EXIST("act22","授权不存在"),
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
