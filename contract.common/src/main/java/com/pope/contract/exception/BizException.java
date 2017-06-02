package com.pope.contract.exception;
/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年6月2日 下午10:16:30
* 类说明
*/
public class BizException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message,  cause);
    }
    
}
