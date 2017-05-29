package com.pope.contract.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 
 * @author yingjun
 *
 * ajax 请求的返回类型封装JSON结果
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResult<T> implements Serializable {


	private static final long serialVersionUID = -4185151304730685014L;

	private boolean success;

    private T data;

    private String msg;
    
    /**
     * 扩展标识，用于特殊判断
     */
    private Integer extFlag;

   
	public BaseResult(boolean success, String msg,T data) {
        this.success = success;
        this.msg = msg;
        this.data=data;
    }   
    public BaseResult(boolean success, String msg,T data,Integer extFalg) {
        this.success = success;
        this.msg = msg;
        this.data=data;
        this.extFlag=extFlag;
    } 
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Integer getExtFlag() {
		return extFlag;
	}
	public void setExtFlag(Integer extFlag) {
		this.extFlag = extFlag;
	}
	@Override
	public String toString() {
		return "BaseResult [success=" + success + ", data=" + data + ", msg=" + msg + "]";
	}

}
