package com.cntytw.datapicker.dologalaxy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cntytw.datapicker.dologalaxy.dto.UserRankingDto;
import com.cntytw.datapicker.dologalaxy.entity.GameDataRanking;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GameDataRankingMapper extends BaseMapper<GameDataRanking> {
    /**
     * 获取分数排行前N名数据
     * */
    List<UserRankingDto> getUserRankingListTopN(Integer count);
    /**
     * 获取分数排行前N名数据
     * */
    UserRankingDto getUserRankingByMac(String userMac);
}
