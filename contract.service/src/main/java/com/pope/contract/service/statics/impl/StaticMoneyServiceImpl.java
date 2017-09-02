package com.pope.contract.service.statics.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pope.contract.code.ContractStateEnum;
import com.pope.contract.code.FlowStateCode;
import com.pope.contract.dao.statics.StaticMoneyInfoMapper;
import com.pope.contract.dao.statics.extend.StaticMoneyInfoExtendMapper;
import com.pope.contract.entity.statics.StaticMoneyInfo;
import com.pope.contract.entity.statics.extend.StaticMoneyInfoExtend;
import com.pope.contract.service.statics.StaticMoneyService;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.DecimalUtil;
import com.pope.contract.util.StringUtil;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年8月27日 下午7:31:31 类说明
 */
@Service("staticMoneyService")
@Transactional
public class StaticMoneyServiceImpl implements StaticMoneyService {

	@Autowired
	private StaticMoneyInfoExtendMapper staticMoneyInfoExtendMapper;

	@Autowired
	private StaticMoneyInfoMapper staticMoneyInfoMapper;

	@Override
	public void calcuMoney() throws Exception {
		String year = DateUtil.getCurrentYearStr();
		StaticMoneyInfoExtend deleteStaticMoneyInfoExtend = new StaticMoneyInfoExtend();
		deleteStaticMoneyInfoExtend.setDataYear(StringUtil.toInt(year));
		staticMoneyInfoExtendMapper.deleteByCondition(deleteStaticMoneyInfoExtend);
		// 获取预付款

		List<String> yfkRwzt = new ArrayList<String>();
		yfkRwzt.add(StringUtil.toStr(ContractStateEnum.WFK.getCode()));
		yfkRwzt.add(StringUtil.toStr(ContractStateEnum.DSH.getCode()));
		yfkRwzt.add(StringUtil.toStr(ContractStateEnum.JXZ.getCode()));
		List<Map<String, Object>> listYfk = staticMoneyInfoExtendMapper.selectContractStaticByRwzt(yfkRwzt,
				StringUtil.toInt(year));
		List<String> yskRwzt = new ArrayList<String>();
		yskRwzt.add(StringUtil.toStr(ContractStateEnum.YJS.getCode()));
		List<Map<String, Object>> listYsk = staticMoneyInfoExtendMapper.selectContractStaticByRwzt(yskRwzt,
				StringUtil.toInt(year));

		List<String> supplyRwzt = new ArrayList<String>();
		supplyRwzt.add(FlowStateCode.YJS.getCode());
		List<Map<String, Object>> listSupply = staticMoneyInfoExtendMapper.selectSupplyStaticByRwzt(supplyRwzt,
				StringUtil.toInt(year));
		for (int i = 1; i <= 12; i++) {
			String month = StringUtil.toStr(i);
			if (i < 10) {
				month = "0" + i;
			}
			StaticMoneyInfo staticMoneyInfo = new StaticMoneyInfo();
			staticMoneyInfo.setWid(StringUtil.getUuId());
			staticMoneyInfo.setDataYearMonth(year + "-" + month);
			staticMoneyInfo.setDataMonth(i);
			staticMoneyInfo.setDataYear(StringUtil.toInt(year));
			if (CommonUtil.isNotEmptyList(listYfk)) {
				for (Map<String, Object> yfk : listYfk) {
					if (StringUtil.toInt(yfk.get("m")) == i) {
						staticMoneyInfo.setWrz(DecimalUtil.toDecimal(StringUtil.toStr(yfk.get("je"))));
					}
				}
			}
			if (CommonUtil.isNotEmptyList(listYsk)) {
				for (Map<String, Object> ysk : listYsk) {
					if (StringUtil.toInt(ysk.get("m")) == i) {
						staticMoneyInfo.setWrz(DecimalUtil.toDecimal(StringUtil.toStr(ysk.get("je"))));
					}
				}
			}
			if (CommonUtil.isNotEmptyList(listSupply)) {
				for (Map<String, Object> ysk : listSupply) {
					if (StringUtil.toInt(ysk.get("m")) == i) {
						staticMoneyInfo.setZc(DecimalUtil.toDecimal(StringUtil.toStr(ysk.get("je"))));
					}
				}
			}
			staticMoneyInfoMapper.insert(staticMoneyInfo);
		}

	}

	@Override
	public List<StaticMoneyInfoExtend> selectByCondition(StaticMoneyInfoExtend staticMoneyInfoExtend) {
		return staticMoneyInfoExtendMapper.selectByCondition(staticMoneyInfoExtend);
	}

	@Override
	public StaticMoneyInfoExtend selectSingleByCondition(StaticMoneyInfoExtend staticMoneyInfoExtend) {
		return staticMoneyInfoExtendMapper.selectSingleByCondition(staticMoneyInfoExtend);
	}

}
