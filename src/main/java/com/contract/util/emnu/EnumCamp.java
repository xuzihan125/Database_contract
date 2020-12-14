package com.contract.util.emnu;

import java.text.SimpleDateFormat;

public class EnumCamp {
    public enum Number{
        ONE(1);

        private int num;
        private Number(int num){
            this.num = num;
        }

        public int getNum() {
            return num;
        }
    }

    public enum DateFormate{
        NORMAL("yyyy-MM-dd hh:mm:ss");
        private String type;
        private DateFormate(String type){
            this.type = type;
        }
        public SimpleDateFormat getFormate() {
            return new SimpleDateFormat(type);
        }
    }

    public enum Right{

        DRAFT_CONTRACT("1","起草合同"),
        FINAL_CONTRACT("2","定稿合同"),
        SELECT_CONTRACT("3","查询合同"),
        CHECK_LOG("33","查询日志"),
        ADD_ROLE("34","添加权限"),
        MODIFY_ROLE("35","修改权限"),
        GET_UNAUTHO_USER("35","获得未授权人列表"),
        ADD_AUTHO("36","配置权限"),
        SET_AUTHO("36","配置权限"),
        DEL_AUTHO("36","配置权限"),
        DOWNLOAD_FILE("39","下载文件"),
        UPLOAD_FILE("40","下载文件"),
        DEL_FILE("41","下载文件"),

        ;

        private String code;
        private String desc;
        private Right(String code,String desc){
            this.code = code;
            this.desc = desc;
        }
        public String getCode() {
            return code;
        }

    }

}
