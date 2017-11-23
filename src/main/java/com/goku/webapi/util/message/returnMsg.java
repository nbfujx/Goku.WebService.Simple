package com.goku.webapi.util.message;

import com.goku.webapi.util.enums.returnCode;

/**
 * Created by nbfujx on 2017-11-07.
 */
public class returnMsg {

    private int code;
    private String desc;
    private Object Data;

    public returnMsg(returnCode Code)
    {
        this.code=Code.getCode();
        this.desc=Code.getDesc();
    }

    public returnMsg(returnCode Code,Object Data)
    {
        this.code=Code.getCode();
        this.desc=Code.getDesc();
        this.Data=Data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }


}
