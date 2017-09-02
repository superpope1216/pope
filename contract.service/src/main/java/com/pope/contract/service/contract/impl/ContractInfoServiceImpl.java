package com.pope.contract.service.contract.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pope.contract.code.ContractStateEnum;
import com.pope.contract.code.DataStatus;
import com.pope.contract.code.FlowSetCode;
import com.pope.contract.code.FlowStateCode;
import com.pope.contract.code.Result;
import com.pope.contract.dao.contract.ContractAddMapper;
import com.pope.contract.dao.contract.ContractInfoMapper;
import com.pope.contract.dao.contract.ContractInfoRelMapper;
import com.pope.contract.dao.contract.ContractMoneyMapper;
import com.pope.contract.dao.contract.extend.ContractInfoExtendMapper;
import com.pope.contract.dao.contract.extend.ContractMoneyExtendMapper;
import com.pope.contract.dao.custom.CustomAccountMapper;
import com.pope.contract.dao.custom.CustomInfoMapper;
import com.pope.contract.dao.custom.CustomMoneyLogMapper;
import com.pope.contract.dao.custom.extend.CustomAccountExtendMapper;
import com.pope.contract.dao.custom.extend.CustomInfoExtendMapper;
import com.pope.contract.dao.project.BatchInfoMapper;
import com.pope.contract.dao.project.extend.BatchInfoDetailFxxmExtendMapper;
import com.pope.contract.dao.project.extend.BatchInfoExtendMapper;
import com.pope.contract.dao.system.FxxmInfoMapper;
import com.pope.contract.dao.system.extend.FxxmInfoExtendMapper;
import com.pope.contract.entity.contract.ContractAdd;
import com.pope.contract.entity.contract.ContractInfo;
import com.pope.contract.entity.contract.ContractInfoRel;
import com.pope.contract.entity.contract.ContractMoney;
import com.pope.contract.entity.contract.extend.ContractInfoExtend;
import com.pope.contract.entity.custom.CustomAccount;
import com.pope.contract.entity.custom.CustomInfo;
import com.pope.contract.entity.custom.CustomMoneyLog;
import com.pope.contract.entity.custom.extend.CustomAccountExtend;
import com.pope.contract.entity.custom.extend.CustomInfoExtend;
import com.pope.contract.entity.project.BatchInfo;
import com.pope.contract.entity.project.extend.BatchInfoExtend;
import com.pope.contract.entity.supply.GmbInfo;
import com.pope.contract.entity.supply.SupplyTotalInfo;
import com.pope.contract.entity.system.FlowSet;
import com.pope.contract.entity.system.FlowSetData;
import com.pope.contract.entity.system.FxxmInfo;
import com.pope.contract.exception.ServiceException;
import com.pope.contract.number.GenernalKey;
import com.pope.contract.service.BaseService;
import com.pope.contract.service.contract.ContractInfoService;
import com.pope.contract.service.system.FlowSetDataService;
import com.pope.contract.service.system.FlowSetService;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.DecimalUtil;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月22日 下午5:42:07
* 类说明
*/
@Service("contractInfoService")
@Transactional
public class ContractInfoServiceImpl extends BaseService implements ContractInfoService{

	@Autowired
	private ContractInfoMapper contractInfoMapper;
	@Autowired
	private ContractInfoExtendMapper contractInfoExtendMapper; 
	
	@Autowired
	private ContractInfoRelMapper contractInfoRelMapper;
	
	@Autowired
	private BatchInfoMapper batchInfoMappper;
	@Autowired
	private BatchInfoExtendMapper batchInfoExtendMapper;
	@Autowired
	private FxxmInfoMapper fxxmInfoMapper;
	@Autowired
	private FxxmInfoExtendMapper fxxmInfoExtendMapper;
	@Autowired
	private ContractAddMapper contractAddMapper;
	
	@Autowired
	private ContractMoneyMapper contractMoneyMapper;
	@Autowired
	private ContractMoneyExtendMapper contractMoneyExtendMapper;
	@Autowired
	private BatchInfoDetailFxxmExtendMapper batchInfoDetailFxxmExtendMapper;
	@Autowired
	private CustomAccountExtendMapper customAccountExtendMapper;
	@Autowired
	private CustomAccountMapper customAccountInfoMapper;
	@Autowired
	private CustomInfoExtendMapper customInfoExtendMapper;
	@Autowired
	private CustomMoneyLogMapper customMoneyLogMapper;
	
	@Autowired
	private FlowSetDataService flowSetDataService;
	@Autowired
	private FlowSetService flowSetService;
	@Override
	public int deleteByPrimaryKey(String wid) throws Exception{
		return contractInfoMapper.deleteByPrimaryKey(wid);
	}

	@Override
	public String insert(ContractInfo record,String pcids,String userId) throws Exception{
		ContractInfoExtend queryContractInfo=new ContractInfoExtend();
		queryContractInfo.setHtbh(record.getHtbh());
		ContractInfo existContractInfo=contractInfoExtendMapper.selectSingleByCondition(queryContractInfo);
		if(existContractInfo!=null){
			throw new ServiceException("该合同编号已存在，请刷新页面重新确认！");
		}
		String wid=StringUtil.getUuId();
		record.setWid(wid);
		record.setDatastatus(StringUtil.toStr(DataStatus.normal.getCode()));
		record.setCreateTime(DateUtil.getCurrentDateTimeStr());
		record.setCreateMan(userId);
		record.setRwzt(ContractStateEnum.WFK.getCode());
		if(!StringUtils.isEmpty(pcids)){
			List<String> listPcid=StringUtil.str2List(pcids);
			for(String pcid:listPcid){
				ContractInfoRel contractInfoRel=new ContractInfoRel();
				contractInfoRel.setWid(StringUtil.getUuId());
				contractInfoRel.setHtid(wid);
				contractInfoRel.setPcid(pcid);
				contractInfoRelMapper.insert(contractInfoRel);
				BatchInfo batchInfo=new BatchInfo();
				batchInfo.setWid(pcid);
				batchInfo.setHth(record.getHtbh());
				batchInfoMappper.updateByPrimaryKeySelective(batchInfo);
			}
		}
		 contractInfoMapper.insert(record);
		 return wid;
	}

	

	@Override
	public ContractInfo selectByPrimaryKey(String wid) throws Exception{
		return contractInfoMapper.selectByPrimaryKey(wid);
	}

	@Override
	public int updateByPrimaryKeySelective(ContractInfo record) throws Exception{
		return contractInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public ContractInfo selectSingleByCondition(ContractInfoExtend contractInfo) throws Exception{
		return contractInfoExtendMapper.selectSingleByCondition(contractInfo);
	}

	@Override
	public List<ContractInfo> selectByCondition(ContractInfoExtend contractInfo) throws Exception{
		return contractInfoExtendMapper.selectByCondition(contractInfo);
	}

	@Override
	public ContractInfoExtend selectSingleDisplayByCondition(ContractInfoExtend contractInfo) throws Exception{
		return contractInfoExtendMapper.selectSingleDisplayByCondition(contractInfo);
	}

	@Override
	public List<ContractInfoExtend> selectDisplayByCondition(ContractInfoExtend contractInfo) throws Exception{
		return contractInfoExtendMapper.selectDisplayByCondition(contractInfo);
	}
	@Override
	public Integer selectMaxDqbh() throws Exception{
		Integer max=contractInfoExtendMapper.selectMaxDqbh();
		if(max==null){
			max=0;
		}
		max++;
		return max;
	}
	
	@Override
	public void addFxxm(String htid,String pcid,String fxxms,String userId) throws Exception{
		if(StringUtils.isEmpty(fxxms)){
			throw new ServiceException("请至少选择一个分析项目");
		}
		ContractInfo contractInfo=contractInfoMapper.selectByPrimaryKey(htid);
		CustomInfo queryCustomInfo=new CustomInfo();
		queryCustomInfo.setCustomNumber(contractInfo.getHtjf());
		queryCustomInfo.setDatastatus(StringUtil.toStr(DataStatus.normal.getCode()));
		CustomInfo customInfo=customInfoExtendMapper.selectSingleByCondition(queryCustomInfo);
		if(customInfo==null){
			throw new ServiceException("合同的客户信息还没有建立，请确认！");
		}
		CustomAccountExtend queryCustomAccount=new CustomAccountExtend();
		queryCustomAccount.setCustomId(customInfo.getWid());
		queryCustomAccount.setDatastatus(StringUtil.toStr(DataStatus.normal.getCode()));
		CustomAccount customAccount=customAccountExtendMapper.selectSingleByCondition(queryCustomAccount);
		if(customAccount==null){
			throw new ServiceException("合同的客户还没有账户信息，请重新确认！");
		}
		List<String> listFxxmId=StringUtil.str2List(fxxms);
		BigDecimal totalJe=contractInfo.getHtje();
		for(String fxxm:listFxxmId){
			//查询分析项目
			FxxmInfo queryFxxmInfo=new FxxmInfo();
			queryFxxmInfo.setLbdm(fxxm);
			queryFxxmInfo.setStatus(DataStatus.normal.getCode());
			FxxmInfo fxxmInfo=fxxmInfoExtendMapper.selectSingleDisplayByCondition(queryFxxmInfo);
			BigDecimal fxdj=fxxmInfo.getFxdj()==null?new BigDecimal("0"):fxxmInfo.getFxdj();
			//查询批次对应的分析项个数
			Integer fxxmCount=batchInfoDetailFxxmExtendMapper.selectFxxmCountByPcid(pcid, fxxm);
			fxxmCount=fxxmCount==null?0:fxxmCount;
			//查询合同分析项信息
			ContractMoney queryContractMoney=new ContractMoney();
			queryContractMoney.setHtid(htid);
			queryContractMoney.setFxxm(fxxm);
			ContractMoney contractMoney=contractMoneyExtendMapper.selectSingleByCondition(queryContractMoney);
			//保存合同分析项目信息
			if(contractMoney==null){
				contractMoney=new ContractMoney();
			
				contractMoney.setCreateMan(userId);
				contractMoney.setCreateTime(DateUtil.getCurrentDateTimeStr());
				contractMoney.setFxxm(fxxm);
				contractMoney.setHtid(htid);
				contractMoney.setDj(fxxmInfo.getFxdj());
			}
			contractMoney.setSl((contractMoney.getSl()==null?0:contractMoney.getSl())+fxxmCount);
			BigDecimal zk=DecimalUtil.sub(DecimalUtil.toDecimal("1"), fxxmInfo.getZk());
			BigDecimal currentZkjg=DecimalUtil.mul(DecimalUtil.mul(fxdj, DecimalUtil.toDecimal(zk.toString())),DecimalUtil.toDecimal(contractMoney.getSl().toString()));
			contractMoney.setZkjg(currentZkjg);
			contractMoney.setZj(DecimalUtil.mul(fxdj, DecimalUtil.toDecimal(contractMoney.getSl().toString())));
			totalJe=DecimalUtil.sub(DecimalUtil.add(totalJe, contractMoney.getZj()),contractMoney.getZkjg());
			if(StringUtils.isEmpty(contractMoney.getWid())){
				contractMoney.setWid(StringUtil.getUuId());
				contractMoneyMapper.insert(contractMoney);
			}else{
				contractMoneyMapper.updateByPrimaryKeySelective(contractMoney);
			}
			//保存合同已添加的分析项目
			ContractAdd contractAdd=new ContractAdd();
			contractAdd.setWid(StringUtil.getUuId());
			contractAdd.setCreateMan(userId);
			contractAdd.setCreateTime(DateUtil.getCurrentDateTimeStr());
			contractAdd.setFxxm(fxxm);
			contractAdd.setHtid(htid);
			contractAdd.setPcid(pcid);
			contractAddMapper.insert(contractAdd);
		}
		
		
		contractInfo.setHtje(totalJe);
		
		BigDecimal money=DecimalUtil.mul(totalJe,contractInfo.getHtzk());
		contractInfo.setZzje(money);
		contractInfoMapper.updateByPrimaryKeySelective(contractInfo);
		
//		BigDecimal money=DecimalUtil.sub(totalJe, contractInfo.getHtzk());
//		
//		customAccount.setAccountMoney(DecimalUtil.sub(customAccount.getAccountMoney(),money));
//		
//		
//		CustomMoneyLog customMoneyLog=new CustomMoneyLog();
//		customMoneyLog.setWid(StringUtil.getUuId());
//		customMoneyLog.setAccountNumber(customAccount.getAccountNumber());
//		customMoneyLog.setBankAccount(customAccount.getBankAccount());
//		customMoneyLog.setBdMoney(DecimalUtil.sub(DecimalUtil.toDecimal("0"),money));
//		customMoneyLog.setCreateMan(userId);
//		customMoneyLog.setCreateTime(DateUtil.getCurrentDateTimeStr());
//		customMoneyLog.setCustomId(customInfo.getWid());
//		customMoneyLogMapper.insert(customMoneyLog);
		
	}

	@Override
	public void submitContract(String wids,String userId) throws Exception {
		if(StringUtils.isEmpty(wids)){
			throw new ServiceException("请至少选择一条合同提交审核！");
		}
		List<String> lstWid=StringUtil.str2List(wids);
		List<ContractInfo> list=new ArrayList<ContractInfo>();
		for(String wid:lstWid){
			ContractInfo contractInfo=contractInfoMapper.selectByPrimaryKey(wid);
			
			if(contractInfo.getRwzt()!=ContractStateEnum.WFK.getCode()){
				throw new ServiceException("存在在审核中的合同，请重新确认！");
			}
			list.add(contractInfo);
		}
		FlowSet flowSet=flowSetService.selectNextStep(FlowSetCode.CONTRACT.getCode(), 0);
		for(ContractInfo contractInfo:list){
			contractInfo.setCurrentstep(flowSet.getPx());
			contractInfo.setRwzt(StringUtil.toInt(FlowStateCode.DSH.getCode()));
			this.saveFlowSetData(flowSet.getPx(), contractInfo.getWid(), FlowStateCode.DSH, FlowSetCode.CONTRACT, userId, "提交审核");
			contractInfoMapper.updateByPrimaryKeySelective(contractInfo);
		}
		
	}

	@Override
	public List<ContractInfoExtend> selectWaitTaskInfoByStep(String roleId) throws Exception {
		FlowSet flowSet=flowSetService.selectByRoleAndType(roleId, FlowSetCode.CONTRACT.getCode());
		List<Integer> taskStatus=new ArrayList<Integer>();
		taskStatus.add(Integer.valueOf(FlowStateCode.DSH.getCode()));
		taskStatus.add(Integer.valueOf(FlowStateCode.JXZ.getCode()));
		return  contractInfoExtendMapper.selectDispalyInfoByStep(flowSet.getPx(), taskStatus);
	}

	@Override
	public void examinePass(String wid, String userid) throws Exception {
		// TODO Auto-generated method stub
				ContractInfo taskInfo=this.contractInfoMapper.selectByPrimaryKey(wid);
				FlowSet flowSet=flowSetService.selectNextStep(FlowSetCode.CONTRACT.getCode(), taskInfo.getCurrentstep());

				Integer currentStep=-1;
				if(flowSet==null || flowSet.getPx()==null){
					
					taskInfo.setRwzt(StringUtil.toInt(FlowStateCode.YJS.getCode()));
					saveFlowSetData(currentStep, wid, FlowStateCode.YJS, FlowSetCode.CONTRACT, userid,FlowStateCode.YJS.getMsg());
					
					//变更账户金额

					/**
					 * 折扣
					 */
					BigDecimal zk=DecimalUtil.sub(DecimalUtil.toDecimal("1"), taskInfo.getHtzk());
					BigDecimal money=DecimalUtil.mul(taskInfo.getHtje(),zk); 
					CustomAccountExtend queryCustomAccountExtend=new CustomAccountExtend();
					CustomInfo queryCustomInfo=new CustomInfo();
					queryCustomInfo.setCustomNumber(taskInfo.getHtjf());
					CustomInfo customInfo=customInfoExtendMapper.selectSingleDisplayByCondition(queryCustomInfo);
					
					queryCustomAccountExtend.setCustomId(customInfo.getWid());
					CustomAccount customAccount=customAccountExtendMapper.selectSingleByCondition(queryCustomAccountExtend);
					customAccount.setAccountMoney(DecimalUtil.sub(customAccount.getAccountMoney(),money));
					customAccountInfoMapper.updateByPrimaryKeySelective(customAccount);
					
					CustomMoneyLog customMoneyLog=new CustomMoneyLog();
					customMoneyLog.setWid(StringUtil.getUuId());
					customMoneyLog.setAccountNumber(customAccount.getAccountNumber());
					customMoneyLog.setBankAccount(customAccount.getBankAccount());
					customMoneyLog.setBdMoney(DecimalUtil.sub(DecimalUtil.toDecimal("0"),money));
					customMoneyLog.setCreateMan(userid);
					customMoneyLog.setCreateTime(DateUtil.getCurrentDateTimeStr());
					customMoneyLog.setCustomId(customInfo.getWid());
					customMoneyLogMapper.insert(customMoneyLog);
				}else{
					currentStep=flowSet.getPx();
					taskInfo.setRwzt(StringUtil.toInt(FlowStateCode.JXZ.getCode()));
					saveFlowSetData(currentStep, wid, FlowStateCode.JXZ, FlowSetCode.CONTRACT, userid,FlowStateCode.JXZ.getMsg());
				}
				taskInfo.setCurrentstep(currentStep);
				contractInfoMapper.updateByPrimaryKeySelective(taskInfo);
	}

	@Override
	public void examineNotPass(String wid, String userid) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ContractInfoExtend getNewContractinfo(String pcid, String pcids) throws Exception {
		BatchInfoExtend queryBatchInfo=new BatchInfoExtend();
		queryBatchInfo.setWid(pcid);
		List<BatchInfoExtend> list=batchInfoExtendMapper.selectDisplayByCondition(queryBatchInfo);
		BatchInfoExtend batchInfo=list.get(0);
		CustomInfo queryCustomInfo=new CustomInfo();
		//queryCustomInfo.setWid(batchInfo.getSydw());
		queryCustomInfo.setCustomNumber(batchInfo.getSydw());
	    CustomInfoExtend  customInfoExtend=customInfoExtendMapper.selectSingleDisplayByCondition(queryCustomInfo);
	    if(customInfoExtend==null){
	    	throw new ServiceException("该合同的甲方还没有客户信息，请先建立甲方对应的客户信息！");
	    }
	    Map<String,Object> map=new HashMap<String,Object>();
	    ContractInfoExtend contractInfoExtend=new ContractInfoExtend();
	    contractInfoExtend.setHtjf(batchInfo.getSydw());
	    contractInfoExtend.setHtjf_display(batchInfo.getSydw_display());
	    contractInfoExtend.setXmfzr(batchInfo.getSyxmfzr());
	    contractInfoExtend.setHtje(new BigDecimal("0"));
	    contractInfoExtend.setHtsj(batchInfo.getSysj());
	    CustomAccountExtend queryCustomAccountExtend=new CustomAccountExtend();
	    queryCustomAccountExtend.setCustomId(customInfoExtend.getWid());
	    CustomAccount customAccount= customAccountExtendMapper.selectSingleByCondition(queryCustomAccountExtend);
	    if(customAccount==null){
	    	throw new ServiceException("该合同的甲方还没有客户账户信息，请先建立甲方对应的客户账户信息！");
	    }
	    Integer max=contractInfoExtendMapper.selectMaxDqbh();
	    if(max==null){
	    	max=0;
	    }
	    max++;
	    contractInfoExtend.setDqbh(max);
	    contractInfoExtend.setHtbh(GenernalKey.getContractKey(max, ""));
	    contractInfoExtend.setXmfzr(contractInfoExtend.getXmfzr());
	    contractInfoExtend.setDfzh(customAccount.getBankAccount());
	    return contractInfoExtend;
	}
}
