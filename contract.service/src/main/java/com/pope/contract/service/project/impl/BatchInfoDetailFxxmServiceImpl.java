package com.pope.contract.service.project.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.contract.dao.project.extend.BatchInfoDetailFxxmExtendMapper;
import com.pope.contract.entity.project.BatchInfoDetailFxxm;
import com.pope.contract.entity.project.extend.BatchInfoDetailFxxmExtend;
import com.pope.contract.service.project.BatchInfoDetailFxxmService;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月26日 上午1:38:18
* 类说明
*/
@Service("batchInfoDetailFxxmService")
public class BatchInfoDetailFxxmServiceImpl implements BatchInfoDetailFxxmService{

	@Autowired
	private BatchInfoDetailFxxmExtendMapper batchInfoDetailFxxmExtendMapper;

	@Override
	public List<BatchInfoDetailFxxm> selectByCondition(BatchInfoDetailFxxm batchInfoFxxm) {
		return batchInfoDetailFxxmExtendMapper.selectByCondition(batchInfoFxxm);
	}

	@Override
	public void deleteByCondition(BatchInfoDetailFxxm batchInfoFxxm) {
		batchInfoDetailFxxmExtendMapper.deleteByCondition(batchInfoFxxm);
	}

	@Override
	public Integer selectFxxmCountByPcid(String pcid, String fxxm) {
		return batchInfoDetailFxxmExtendMapper.selectFxxmCountByPcid(pcid, fxxm);
	}

	@Override
	public List<BatchInfoDetailFxxmExtend> selectFxxmDisplayByPcid(String pcid, String fxxm) throws Exception {
		return batchInfoDetailFxxmExtendMapper.selectFxxmDisplayByPcid(pcid, fxxm);
	}
	

}
