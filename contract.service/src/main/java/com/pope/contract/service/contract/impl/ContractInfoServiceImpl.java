package com.pope.contract.service.contract.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pope.contract.code.ContractStateEnum;
import com.pope.contract.code.DataStatus;
import com.pope.contract.dao.contract.ContractAddMapper;
import com.pope.contract.dao.contract.ContractInfoMapper;
import com.pope.contract.dao.contract.ContractInfoRelMapper;
import com.pope.contract.dao.contract.ContractMoneyMapper;
import com.pope.contract.dao.contract.extend.ContractInfoExtendMapper;
import com.pope.contract.dao.contract.extend.ContractMoneyExtendMapper;
import com.pope.contract.dao.project.BatchInfoMapper;
import com.pope.contract.dao.project.extend.BatchInfoDetailFxxmExtendMapper;
import com.pope.contract.dao.system.FxxmInfoMapper;
import com.pope.contract.dao.system.extend.FxxmInfoExtendMapper;
import com.pope.contract.entity.contract.ContractAdd;
import com.pope.contract.entity.contract.ContractInfo;
import com.pope.contract.entity.contract.ContractInfoRel;
import com.pope.contract.entity.contract.ContractMoney;
import com.pope.contract.entity.contract.extend.ContractInfoExtend;
import com.pope.contract.entity.project.BatchInfo;
import com.pope.contract.entity.system.FxxmInfo;
import com.pope.contract.exception.ServiceException;
import com.pope.contract.service.contract.ContractInfoService;
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
public class ContractInfoServiceImpl implements ContractInfoService{

	@Autowired
	private ContractInfoMapper contractInfoMapper;
	@Autowired
	private ContractInfoExtendMapper contractInfoExtendMapper; 
	
	@Autowired
	private ContractInfoRelMapper contractInfoRelMapper;
	
	@Autowired
	private BatchInfoMapper batchInfoMappper;
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
	@Override
	public int deleteByPrimaryKey(String wid) throws Exception{
		return contractInfoMapper.deleteByPrimaryKey(wid);
	}

	@Override
	public String insert(ContractInfo record,String pcids,String userId) throws Exception{
		ContractInfo queryContractInfo=new ContractInfo();
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
	public ContractInfo selectSingleByCondition(ContractInfo contractInfo) throws Exception{
		return contractInfoExtendMapper.selectSingleByCondition(contractInfo);
	}

	@Override
	public List<ContractInfo> selectByCondition(ContractInfo contractInfo) throws Exception{
		return contractInfoExtendMapper.selectByCondition(contractInfo);
	}

	@Override
	public ContractInfoExtend selectSingleDisplayByCondition(ContractInfo contractInfo) throws Exception{
		return contractInfoExtendMapper.selectSingleDisplayByCondition(contractInfo);
	}

	@Override
	public List<ContractInfoExtend> selectDisplayByCondition(ContractInfo contractInfo) throws Exception{
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
		List<String> listFxxmId=StringUtil.str2List(fxxms);
		BigDecimal totalJe=DecimalUtil.toDecimal("0");
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
		ContractInfo contractInfo=new ContractInfo();
		contractInfo.setWid(htid);
		contractInfo.setHtje(totalJe);
		contractInfoMapper.updateByPrimaryKeySelective(contractInfo);
	}
}
