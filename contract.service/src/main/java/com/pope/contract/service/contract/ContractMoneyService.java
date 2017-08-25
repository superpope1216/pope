package com.pope.contract.service.contract;

import java.util.List;

import com.pope.contract.entity.contract.ContractMoney;
import com.pope.contract.entity.contract.extend.ContractMoneyExtend;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年8月26日 上午2:36:57 类说明
 */
public interface ContractMoneyService {

	List<ContractMoney> selectByCondition(ContractMoney contractMoney) throws Exception;

	ContractMoney selectSingleByCondition(ContractMoney contractMoney) throws Exception;

	ContractMoneyExtend selectSingleDispalyByCondition(ContractMoney contractMoney) throws Exception;

	List<ContractMoneyExtend> selectDispalyByCondition(ContractMoney contractMoney) throws Exception;
}
