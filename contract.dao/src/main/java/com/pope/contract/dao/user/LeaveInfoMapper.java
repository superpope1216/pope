package com.pope.contract.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.user.LeaveInfo;

public interface LeaveInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(LeaveInfo record);

    int insertSelective(LeaveInfo record);

    LeaveInfo selectByPrimaryKey(String wid);
    
    List<LeaveInfo> selectByYhid(@Param(value="yhid") String yhid);
    
    List<LeaveInfo> selectLeaveInfoByStep(@Param(value="step")String step,@Param(value="shType") String shType,@Param(value="teamId") String teamId,
    		@Param(value="departmentId") String departmentId,@Param(value="taskStatus") List<String> taskStatus);

    int updateByPrimaryKeySelective(LeaveInfo record);

    int updateByPrimaryKey(LeaveInfo record);
}