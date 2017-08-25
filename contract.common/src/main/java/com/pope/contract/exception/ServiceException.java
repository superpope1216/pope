package com.pope.contract.exception;
/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月19日 上午1:12:38
* 类说明
*/
public class ServiceException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message,  cause);
    }
}
