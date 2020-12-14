package com.contract.util.BaseAction;

import com.contract.util.emnu.EnumCamp;
import com.contract.util.emnu.ResultCode;
import com.contract.util.message.JsonMessage;


public class BaseAction {

//    public static ThreadLocal<String> userId = new InheritableThreadLocal<>();
//
//    public Object buildClientResult(String text) {
//        JSONObject jsonObject = JSON.parseObject(text);
//        if (!jsonObject.containsKey("resCode")) {
//            throw new ActException(ErrorCode.PARAM_ERROR.getCode(), ErrorCode.PARAM_ERROR.getName());
//        } else if (!"0".equals(jsonObject.getString("resCode"))) {
//            throw new ActException(jsonObject.getString("resCode"), jsonObject.getString("resMsg"));
//        } else {
//            return jsonObject.get("data");
//        }
//    }
//    /**
//     * 初始化
//     * @param request
//     * @param response
//     */
//    public static void  init(HttpServletRequest request, HttpServletResponse response) {
//        userId.set(request.getAttribute(Constants.CURRENT_USER_KEY).toString());
//    }

//    /**
//     * 销毁
//     */
//    public static void destroy() {
//        userId.remove();
//    }

    public <T> JsonMessage<T> buildJsonMessage(T obj) {
        return new JsonMessage<T>(obj, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getName());
    }

    public <T> JsonMessage<T> buildJsonMessage() {
        return new JsonMessage(null, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getName());
    }
}