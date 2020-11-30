package com.contract.util.emnu;

public class EnumCamp {
    public enum ResultCode{
        SUCCESS("0", "成功","success"),
        DEFAULT("-1","未知状态","unknown status")
        ;

        private String code;
        private String name;
        private String eName;

        private ResultCode(String code, String name,String eName) {
            this.code = code;
            this.name = name;
            this.eName = eName;
        }

        public String getName() {
            return this.name;
        }
        public String getEName() {
            return eName;
        }

        public static String getEName(String code) {
            ResultCode[] opCodes = ResultCode.values();
            for (ResultCode opCode : opCodes) {
                if (opCode.code.equals(code)) {
                    return opCode.getEName();
                }
            }
            return DEFAULT.getEName();
        }
        public String getCode() {
            return this.code;
        }

        public ResultCode getCode(String code) {
            ResultCode[] opCodes = ResultCode.values();
            for (ResultCode opCode : opCodes) {
                if (opCode.code.equals(code)) {
                    return opCode;
                }
            }
            return DEFAULT;
        }
    }
}
