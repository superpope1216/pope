package com.pope.contract.service.project.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.pope.contract.code.BatchStateEnum;
import com.pope.contract.dao.project.BatchInfoDetailMapper;
import com.pope.contract.dao.project.BatchInfoFxxmMapper;
import com.pope.contract.dao.project.BatchInfoMapper;
import com.pope.contract.dao.project.extend.BatchInfoDetailExtendMapper;
import com.pope.contract.dao.project.extend.BatchInfoExtendMapper;
import com.pope.contract.dao.project.extend.BatchInfoFxxmExtendMapper;
import com.pope.contract.entity.project.BatchInfo;
import com.pope.contract.entity.project.BatchInfoDetail;
import com.pope.contract.entity.project.BatchInfoFxxm;
import com.pope.contract.entity.project.extend.BatchInfoDetailExtend;
import com.pope.contract.entity.project.extend.BatchInfoExtend;
import com.pope.contract.service.project.BatchInfoService;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月13日 下午1:59:58
* 类说明
*/
@Service("batchInfoService")
public class BatchInfoServiceImpl implements BatchInfoService {
	
	@Autowired
	private BatchInfoExtendMapper batchInfoExtendMapper;
	
	@Autowired 
	private BatchInfoMapper batchInfoMapper;
	@Autowired
	private BatchInfoDetailMapper  batchInfoDetailMapper;
	@Autowired
	private BatchInfoDetailExtendMapper  batchInfoDetailExtendMapper;
	
	@Autowired
	private BatchInfoFxxmExtendMapper batchInfoFxxmExtendMapper;
	@Autowired
	private BatchInfoFxxmMapper batchInfoFxxmMapper;
	@Override
	public List<BatchInfo> selectByCondition(BatchInfo batchInfo){
		return batchInfoExtendMapper.selectByCondition(batchInfo);
	}
	
	public List<BatchInfoExtend> selectDisplayByCondition(BatchInfo batchInfo){
		return batchInfoExtendMapper.selectDisplayByCondition(batchInfo);
	}
	@Override
	public BatchInfo selectByPrimaryKey(String wid) {
		return batchInfoMapper.selectByPrimaryKey(wid);
	}
	
	
	@Override
	@Transactional
	public BatchInfo insertBatchInfo(BatchInfo batchInfo) throws Exception{
		BatchInfo query=new BatchInfo();
		query.setYpph(batchInfo.getYpph());
		List<BatchInfo> list=batchInfoExtendMapper.selectByCondition(query);
		if(CommonUtil.isNotEmptyList(list)){
			throw new Exception("该样品编号已存在，请重新确认！");
		}
		String wid=StringUtil.getUuId();
		batchInfo.setWid(wid);
		batchInfo.setPczt(StringUtil.toStr(BatchStateEnum.XJ.getCode()));
		batchInfoMapper.insert(batchInfo);
		String fxxm=batchInfo.getFxxm();
		if(!StringUtils.isEmpty(fxxm)){
			String[] aFxxm=fxxm.split(",");
			for(String s:aFxxm){
				BatchInfoFxxm batchInfoFxxm=new BatchInfoFxxm();
				batchInfoFxxm.setWid(StringUtil.getUuId());
				batchInfoFxxm.setPwid(wid);
				batchInfoFxxm.setFxxmbh(s);
				batchInfoFxxmMapper.insert(batchInfoFxxm);
			}
		}
		return batchInfo;
	}
	@Override
	public int updateBatchInfo(BatchInfo batchInfo) throws Exception{
		BatchInfoFxxm deleteBatchInfoFxxm=new BatchInfoFxxm();
		deleteBatchInfoFxxm.setPwid(batchInfo.getWid());
		batchInfoFxxmExtendMapper.deleteByCondition(deleteBatchInfoFxxm);
		String fxxm=batchInfo.getFxxm();
		if(!StringUtils.isEmpty(fxxm)){
			String[] aFxxm=fxxm.split(",");
			for(String s:aFxxm){
				BatchInfoFxxm batchInfoFxxm=new BatchInfoFxxm();
				batchInfoFxxm.setWid(StringUtil.getUuId());
				batchInfoFxxm.setPwid(batchInfo.getWid());
				batchInfoFxxm.setFxxmbh(s);
				batchInfoFxxmMapper.insert(batchInfoFxxm);
			}
		}
		return batchInfoMapper.updateByPrimaryKeySelective(batchInfo);
	}
	@Override
	@Transactional
	public void deleteBatchInfo(String wid)throws Exception {
		batchInfoMapper.deleteByPrimaryKey(wid);
		batchInfoDetailExtendMapper.deleteByPcid(wid);
		
	}
	@Override
	public String selectMax() throws Exception {
	
		Integer max=batchInfoExtendMapper.selectMaxDqbh();
		if(max==null){
			max=0;
		}
		max++;
		String sMax=String.format("%05d",max);
		return sMax;
	}
	@Override
	public String selectDetailMax() throws Exception{
		Integer max=batchInfoDetailExtendMapper.selectMaxDqbh();
		if(max==null){
			max=0;
		}
		max++;
		String sMax=String.format("%05d",max);
		return sMax;
	}
	@Override
	public void insertBatchInfoDetail(BatchInfoDetail batchInfoDetail) throws Exception {
		BatchInfoDetail query=new BatchInfoDetail();
		query.setYpbh(batchInfoDetail.getYpbh());
		List<BatchInfoDetail> list=batchInfoDetailExtendMapper.selectByCondition(query);
		if(CommonUtil.isNotEmptyList(list)){
			throw new Exception("该样品编号已存在，请重新确认！");
		}
		batchInfoDetail.setWid(StringUtil.getUuId());
		batchInfoDetailMapper.insert(batchInfoDetail);
		
	}
	@Override
	public void updateBatchInfoDetail(BatchInfoDetail batchInfo) throws Exception {
		batchInfoDetailMapper.updateByPrimaryKeySelective(batchInfo);
	}
	@Override
	public void deleteBatchInfoDetail(String wid) throws Exception {
		batchInfoDetailMapper.deleteByPrimaryKey(wid);
	}
	@Override
	public List<BatchInfoDetail> selectDetailByCondition(BatchInfoDetail batchInfoDetail) throws Exception{
		return batchInfoDetailExtendMapper.selectByCondition(batchInfoDetail);
	}
	@Override
	public List<BatchInfoDetailExtend> selectDetailDisplayByCondition(BatchInfoDetail batchInfoDetail) throws Exception{
		return batchInfoDetailExtendMapper.selectDisplayByCondition(batchInfoDetail);
	}

	@Override
	@Transactional
	public String copyBatchInfo(String wid) throws Exception {
		BatchInfo batchInfo=batchInfoMapper.selectByPrimaryKey(wid);
		String newWid=StringUtil.getUuId();
		if(batchInfo!=null){
			batchInfo.setWid(newWid);
			batchInfo.setPcmc(batchInfo.getPcmc());
			String max=this.selectMax();
			String month=DateUtil.format(DateUtil.getCurrentDate(),"yyyyMM");
			batchInfo.setDqbh(Integer.valueOf(max));
			String ypph=month+max.toString();
			batchInfo.setYpph(ypph);
			batchInfoMapper.insert(batchInfo);
			BatchInfoDetail batchInfoDetail=new BatchInfoDetail();
			batchInfoDetail.setPcwid(wid);
		}
		return newWid;
	}
}
