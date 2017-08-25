package com.pope.contract.service.project.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.pope.contract.code.BatchStateEnum;
import com.pope.contract.code.ContractStateEnum;
import com.pope.contract.code.Result;
import com.pope.contract.code.TaskStatusEnum;
import com.pope.contract.dao.contract.extend.ContractInfoExtendMapper;
import com.pope.contract.dao.contract.extend.ContractInfoRelExtendMapper;
import com.pope.contract.dao.project.BatchInfoDetailFxxmMapper;
import com.pope.contract.dao.project.BatchInfoDetailMapper;
import com.pope.contract.dao.project.BatchInfoFxxmMapper;
import com.pope.contract.dao.project.BatchInfoMapper;
import com.pope.contract.dao.project.extend.BatchInfoDetailExtendMapper;
import com.pope.contract.dao.project.extend.BatchInfoDetailFxxmExtendMapper;
import com.pope.contract.dao.project.extend.BatchInfoExtendMapper;
import com.pope.contract.dao.project.extend.BatchInfoFxxmExtendMapper;
import com.pope.contract.dao.system.FxxmInfoMapper;
import com.pope.contract.dao.task.extend.TaskInfoExtendMapper;
import com.pope.contract.entity.contract.ContractInfo;
import com.pope.contract.entity.contract.ContractInfoRel;
import com.pope.contract.entity.project.BatchInfo;
import com.pope.contract.entity.project.BatchInfoDetail;
import com.pope.contract.entity.project.BatchInfoDetailFxxm;
import com.pope.contract.entity.project.BatchInfoFxxm;
import com.pope.contract.entity.project.extend.BatchInfoDetailExtend;
import com.pope.contract.entity.project.extend.BatchInfoExtend;
import com.pope.contract.entity.system.FxxmInfo;
import com.pope.contract.entity.system.Sjzd;
import com.pope.contract.entity.task.TaskInfo;
import com.pope.contract.exception.ServiceException;
import com.pope.contract.service.project.BatchInfoService;
import com.pope.contract.service.system.SjzdService;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年8月13日 下午1:59:58 类说明
 */
@Service("batchInfoService")
public class BatchInfoServiceImpl implements BatchInfoService {

	@Autowired
	private BatchInfoExtendMapper batchInfoExtendMapper;

	@Autowired
	private BatchInfoMapper batchInfoMapper;
	@Autowired
	private BatchInfoDetailMapper batchInfoDetailMapper;
	@Autowired
	private BatchInfoDetailExtendMapper batchInfoDetailExtendMapper;

	@Autowired
	private BatchInfoFxxmExtendMapper batchInfoFxxmExtendMapper;
	@Autowired
	private BatchInfoDetailFxxmMapper batchInfoDetailFxxmMapper;
	@Autowired
	private BatchInfoDetailFxxmExtendMapper batchInfoDetailFxxmExtendMapper;
	@Autowired
	private BatchInfoFxxmMapper batchInfoFxxmMapper;
	
	@Autowired
	private TaskInfoExtendMapper taskInfoExtendMapper;
	@Autowired
	private ContractInfoExtendMapper contractInfoExtendMapper;
	@Autowired
	private ContractInfoRelExtendMapper contractInfoRelExtendMapper;

	@Autowired
	private SjzdService sjzdService;

	@Override
	public List<BatchInfo> selectByCondition(BatchInfo batchInfo) {
		return batchInfoExtendMapper.selectByCondition(batchInfo);
	}

	public List<BatchInfoExtend> selectDisplayByCondition(BatchInfoExtend batchInfo) {
		List<Sjzd> listFxxmInfo = sjzdService.selectAll("T_CONTRACT_SJZD_FXXM", null);
		Map<String, Object> mapFxxmInfo = new HashMap<String, Object>();
		if (CommonUtil.isNotEmptyList(listFxxmInfo)) {
			for (Sjzd sjzd : listFxxmInfo) {
				mapFxxmInfo.put(sjzd.getLbdm(), sjzd.getLbmc());
			}
		}
		List<BatchInfoExtend> list = batchInfoExtendMapper.selectDisplayByCondition(batchInfo);
		if (CommonUtil.isNotEmptyList(list)) {
			for (BatchInfoExtend batchInfoDetailExtend : list) {
				String fxxm = batchInfoDetailExtend.getFxxm();
				if (!StringUtils.isEmpty(fxxm)) {
					String[] arrayFxxm = fxxm.split(",");
					String fxxm_display = "";
					for (String s : arrayFxxm) {
						fxxm_display += "," + StringUtil.toStr(mapFxxmInfo.get(s));
					}
					if (!StringUtils.isEmpty(fxxm_display)) {
						fxxm_display = fxxm_display.substring(1);
					}
					batchInfoDetailExtend.setFxxm_display(fxxm_display);
				}
			}
		}
		return list;
	}

	@Override
	public BatchInfo selectByPrimaryKey(String wid) {
		return batchInfoMapper.selectByPrimaryKey(wid);
	}

	@Override
	@Transactional
	public BatchInfo insertBatchInfo(BatchInfo batchInfo, String userId) throws Exception {
		BatchInfo query = new BatchInfo();
		query.setYpph(batchInfo.getYpph());
		List<BatchInfo> list = batchInfoExtendMapper.selectByCondition(query);
		if (CommonUtil.isNotEmptyList(list)) {
			throw new Exception("该样品编号已存在，请重新确认！");
		}
		batchInfo.setCreateMan(userId);
		batchInfo.setCreateTime(DateUtil.getCurrentDateTimeStr());
		String wid = StringUtil.getUuId();
		batchInfo.setWid(wid);
		batchInfo.setPczt(StringUtil.toStr(BatchStateEnum.XJ.getCode()));
		batchInfoMapper.insert(batchInfo);

		String fxxm = batchInfo.getFxxm();
		if (!StringUtils.isEmpty(fxxm)) {
			String[] aFxxm = fxxm.split(",");
			for (String s : aFxxm) {
				BatchInfoFxxm batchInfoFxxm = new BatchInfoFxxm();
				batchInfoFxxm.setWid(StringUtil.getUuId());
				batchInfoFxxm.setPwid(wid);
				batchInfoFxxm.setFxxmbh(s);

				batchInfoFxxmMapper.insert(batchInfoFxxm);
			}
		}
		return batchInfo;
	}

	@Override
	@Transactional
	public int updateBatchInfo(BatchInfo batchInfo) throws Exception {
		BatchInfoFxxm deleteBatchInfoFxxm = new BatchInfoFxxm();
		deleteBatchInfoFxxm.setPwid(batchInfo.getWid());
		batchInfoFxxmExtendMapper.deleteByCondition(deleteBatchInfoFxxm);
		String fxxm = batchInfo.getFxxm();
		if (!StringUtils.isEmpty(fxxm)) {
			String[] aFxxm = fxxm.split(",");
			for (String s : aFxxm) {
				BatchInfoFxxm batchInfoFxxm = new BatchInfoFxxm();
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
	public void deleteBatchInfo(String wid) throws Exception {
		batchInfoMapper.deleteByPrimaryKey(wid);
		batchInfoDetailExtendMapper.deleteByPcid(wid);
		BatchInfoFxxm deleteBatchInfoFxxm = new BatchInfoFxxm();
		deleteBatchInfoFxxm.setPwid(wid);
		batchInfoFxxmExtendMapper.deleteByCondition(deleteBatchInfoFxxm);

	}

	@Override
	public String selectMax() throws Exception {

		Integer max = batchInfoExtendMapper.selectMaxDqbh();
		if (max == null) {
			max = 0;
		}
		max++;
		String sMax = String.format("%03d", max);
		return sMax;
	}

	@Override
	public String selectDetailMax() throws Exception {
		Integer max = batchInfoDetailExtendMapper.selectMaxDqbh();
		if (max == null) {
			max = 0;
		}
		max++;
		String sMax = String.format("%04d", max);
		return sMax;
	}

	@Override
	@Transactional
	public void insertBatchInfoDetail(BatchInfoDetail batchInfoDetail) throws Exception {
		BatchInfoDetail query = new BatchInfoDetail();
		query.setYpbh(batchInfoDetail.getYpbh());
		List<BatchInfoDetail> list = batchInfoDetailExtendMapper.selectByCondition(query);
		if (CommonUtil.isNotEmptyList(list)) {
			throw new Exception("该样品编号已存在，请重新确认！");
		}
		String wid = StringUtil.getUuId();
		batchInfoDetail.setWid(wid);
		batchInfoDetailMapper.insert(batchInfoDetail);
		String fxxm = batchInfoDetail.getFxxm();
		if (!StringUtils.isEmpty(fxxm)) {
			String[] aFxxm = fxxm.split(",");
			for (String s : aFxxm) {
				BatchInfoDetailFxxm batchInfoFxxm = new BatchInfoDetailFxxm();
				batchInfoFxxm.setWid(StringUtil.getUuId());
				batchInfoFxxm.setPwid(wid);
				batchInfoFxxm.setFxxmbh(s);

				batchInfoDetailFxxmMapper.insert(batchInfoFxxm);
			}
		}

	}

	@Override
	@Transactional
	public void updateBatchInfoDetail(BatchInfoDetail batchInfo) throws Exception {
		BatchInfoDetailFxxm deleteBatchInfoFxxm = new BatchInfoDetailFxxm();
		deleteBatchInfoFxxm.setPwid(batchInfo.getWid());
		batchInfoDetailFxxmExtendMapper.deleteByCondition(deleteBatchInfoFxxm);
		String fxxm = batchInfo.getFxxm();
		if (!StringUtils.isEmpty(fxxm)) {
			String[] aFxxm = fxxm.split(",");
			for (String s : aFxxm) {
				BatchInfoDetailFxxm batchInfoFxxm = new BatchInfoDetailFxxm();
				batchInfoFxxm.setWid(StringUtil.getUuId());
				batchInfoFxxm.setPwid(batchInfo.getWid());
				batchInfoFxxm.setFxxmbh(s);
				batchInfoDetailFxxmMapper.insert(batchInfoFxxm);
			}
		}
		batchInfoDetailMapper.updateByPrimaryKeySelective(batchInfo);
	}

	@Override
	@Transactional
	public void deleteBatchInfoDetail(String wid) throws Exception {
		batchInfoDetailMapper.deleteByPrimaryKey(wid);
		BatchInfoDetailFxxm deleteBatchInfoFxxm = new BatchInfoDetailFxxm();
		deleteBatchInfoFxxm.setPwid(wid);
		batchInfoDetailFxxmExtendMapper.deleteByCondition(deleteBatchInfoFxxm);
	}

	@Override
	public List<BatchInfoDetail> selectDetailByCondition(BatchInfoDetail batchInfoDetail) throws Exception {
		return batchInfoDetailExtendMapper.selectByCondition(batchInfoDetail);
	}

	@Override
	public List<BatchInfoDetailExtend> selectDetailDisplayByCondition(BatchInfoDetail batchInfoDetail)
			throws Exception {
		List<Sjzd> listFxxmInfo = sjzdService.selectAll("T_CONTRACT_SJZD_FXXM", null);
		Map<String, Object> mapFxxmInfo = new HashMap<String, Object>();
		if (CommonUtil.isNotEmptyList(listFxxmInfo)) {
			for (Sjzd sjzd : listFxxmInfo) {
				mapFxxmInfo.put(sjzd.getLbdm(), sjzd.getLbmc());
			}
		}
		List<BatchInfoDetailExtend> list = batchInfoDetailExtendMapper.selectDisplayByCondition(batchInfoDetail);
		if (CommonUtil.isNotEmptyList(list)) {
			for (BatchInfoDetailExtend batchInfoDetailExtend : list) {
				String fxxm = batchInfoDetailExtend.getFxxm();
				if (!StringUtils.isEmpty(fxxm)) {
					String[] arrayFxxm = fxxm.split(",");
					String fxxm_display = "";
					for (String s : arrayFxxm) {
						fxxm_display += "," + StringUtil.toStr(mapFxxmInfo.get(s));
					}
					if (!StringUtils.isEmpty(fxxm_display)) {
						fxxm_display = fxxm_display.substring(1);
					}
					batchInfoDetailExtend.setFxxm_display(fxxm_display);
				}
			}
		}
		return list;
	}

	@Override
	@Transactional
	public String copyBatchInfo(String wid) throws Exception {
		BatchInfo batchInfo = batchInfoMapper.selectByPrimaryKey(wid);
		String newWid = StringUtil.getUuId();
		if (batchInfo != null) {
			batchInfo.setWid(newWid);
			batchInfo.setPcmc(batchInfo.getPcmc());
			String max = this.selectMax();
			String month = DateUtil.format(DateUtil.getCurrentDate(), "yyyyMM");
			batchInfo.setDqbh(Integer.valueOf(max));
			String ypph = month + max.toString();
			batchInfo.setYpph(ypph);
			batchInfoMapper.insert(batchInfo);
			BatchInfoDetail batchInfoDetail = new BatchInfoDetail();
			batchInfoDetail.setPcwid(wid);
		}
		return newWid;
	}

	@Override
	public List<BatchInfoExtend> selectByWids(String wids) throws Exception{
		return batchInfoExtendMapper.selectByWids(StringUtil.str2List(wids));
	}
	@Override
	public BatchInfo checkCreateContract(String wids) throws Exception {
		if (StringUtils.isEmpty(wids)) {
			throw new ServiceException("请至少选择一条样品批次！");
		}
		List<BatchInfoExtend> datas = batchInfoExtendMapper.selectByWids(StringUtil.str2List(wids));
		if(CommonUtil.isNotEmptyList(datas)){
			String sydw=datas.get(0).getSydw();
			for(BatchInfo batchInfo:datas){
				if(BatchStateEnum.DC.getCode()!=StringUtil.toInt(batchInfo.getPczt())){
					throw new ServiceException("存在样品批次状态不是【待测】的记录，无法创建合同，请重新确认！");
				}
				if(!batchInfo.getSydw().equals(sydw)){
					throw new ServiceException("存在样品批次的送样单位不一致的情况，无法创建合同，请重新确认！");
				}
			}
		}
		return datas.get(0);
	}

	@Override
	public void guidang(String wid) throws Exception {
		BatchInfo batchInfo=batchInfoMapper.selectByPrimaryKey(wid);
		if(batchInfo.getPczt().equals(StringUtil.toStr(BatchStateEnum.XJ.getCode()))){
			throw new ServiceException("该样品批次状态为新建，无法进行归档！");
		}
		if(batchInfo.getPczt().equals(StringUtil.toStr(BatchStateEnum.DC.getCode()))){
			throw new ServiceException("该样品批次状态为待测，无法进行归档！");
		}
		TaskInfo taskInfo=new TaskInfo();
		taskInfo.setPcwid(wid);
		List<TaskInfo> listTask=	taskInfoExtendMapper.selectTaskInfoByCondition(taskInfo);
		if(CommonUtil.isNotEmptyList(listTask))
		for(TaskInfo t:listTask){
			if(t.getRwzt()!=TaskStatusEnum.SHTG.getCode() || t.getRwzt()!=TaskStatusEnum.SHBTG.getCode()){
				throw new ServiceException("该样品批次下的任务还没有审核结束，无法进行归档！");
			}
		}
		ContractInfoRel queryContractInfoRel=new ContractInfoRel();
		queryContractInfoRel.setPcid(wid);
		
		List<ContractInfoRel> listContractInfoRel=contractInfoRelExtendMapper.selectByCondition(queryContractInfoRel);
		if(CommonUtil.isNotEmptyList(listContractInfoRel)){
			ContractInfoRel contractInfoRel=listContractInfoRel.get(0);
			ContractInfo queryContractInfo=new ContractInfo();
			queryContractInfo.setWid(contractInfoRel.getHtid());
			List<ContractInfo> listContractInfo=contractInfoExtendMapper.selectByCondition(queryContractInfo);
			if(CommonUtil.isNotEmptyList(listContractInfo)){
				for(ContractInfo contractInfo:listContractInfo){
					if(contractInfo.getRwzt()!=ContractStateEnum.SHTG.getCode() ||contractInfo.getRwzt()!=ContractStateEnum.SHBTG.getCode()){
						throw new ServiceException("该样品批次下的合同还没有审核结束，无法进行归档！");
					}
				}
			}
			
		}
		batchInfo.setPczt(StringUtil.toStr(BatchStateEnum.YGD.getCode()));
		batchInfoMapper.updateByPrimaryKeySelective(batchInfo);
		
		
		
	}
}
