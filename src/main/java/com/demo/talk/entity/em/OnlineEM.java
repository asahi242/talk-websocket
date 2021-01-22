package com.demo.talk.entity.em;

/**
 * 用户状态
 */
public enum OnlineEM {
    /**
     *离线
     */
    _0("0","离线"),
    /**
     * 在线
     */
    _1("1","在线"),
    /**
     * 隐身
     */
    _2("2","隐身");
    private String key;
    private  String val;

    OnlineEM(String key, String val){
        this.key = key;
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public String getKey(){
        return key;
    }
}
