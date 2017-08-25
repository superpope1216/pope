package com.pope.contract.service.contract;

import java.util.List;

import com.pope.contract.entity.contract.ContractInfo;
import com.pope.contract.entity.contract.ContractInfoRel;
import com.pope.contract.entity.contract.extend.ContractInfoExtend;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年8月22日 下午5:41:22 类说明
 */
public interface ContractInfoRelService {
	List<ContractInfoRel> selectByCondition(ContractInfoRel contractInfoRel) throws Exception;
}
