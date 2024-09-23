package com.cntytw.datapicker.dologalaxy.service;

import com.cntytw.datapicker.dologalaxy.vo.UserRankingNeeded;

/**
 * @apiNote 排行榜数据接口
 * @author Kriser666
 */
public interface RankingDataService {
    UserRankingNeeded getUserRankingListTopN(String userMac, Integer count);
}