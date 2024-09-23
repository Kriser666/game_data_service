package com.cntytw.datapicker.dologalaxy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cntytw.datapicker.dologalaxy.entity.GameDataUserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GameDataUserInfoMapper extends BaseMapper<GameDataUserInfo> {

    GameDataUserInfo selectByMac(String userMac);

    Integer selectMaxId();
}
