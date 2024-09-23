package com.cntytw.datapicker.dologalaxy.service;

import com.cntytw.datapicker.dologalaxy.dto.UserRankingNeededDto;

/**
 * @apiNote 排行榜数据接口
 * @author Kriser666
 */
public interface RankingDataService {
    UserRankingNeededDto getUserRankingListTopN(String userMac, Integer count);
}