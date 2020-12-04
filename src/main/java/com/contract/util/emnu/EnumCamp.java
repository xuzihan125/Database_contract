package com.contract.util.emnu;

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

}
