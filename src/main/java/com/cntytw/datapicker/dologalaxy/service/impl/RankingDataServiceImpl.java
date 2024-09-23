package com.cntytw.datapicker.dologalaxy.service.impl;

import com.cntytw.datapicker.dologalaxy.dto.UserRankingDto;
import com.cntytw.datapicker.dologalaxy.vo.UserRankingNeeded;
import com.cntytw.datapicker.dologalaxy.mapper.GameDataRankingMapper;
import com.cntytw.datapicker.dologalaxy.service.RankingDataService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class RankingDataServiceImpl implements RankingDataService {

    @Resource
    private GameDataRankingMapper gameDataRankingMapper;

    /**
     * @param count 前多少名
     * @apiNote 排行榜前多少名的数据
     */
    @Override
    public UserRankingNeeded getUserRankingListTopN(String userMac, Integer count) {

        List<UserRankingDto> userRankingListTopN;
        UserRankingDto userRankingDtoByMac = null;
        try {
            // 找到排行前N的信息
            userRankingListTopN = gameDataRankingMapper.getUserRankingListTopN(count);
            if (userRankingListTopN != null){
                // 对排行榜进行名次赋值
                for (int i = 0; i < userRankingListTopN.size(); ++i) {
                    userRankingListTopN.get(i).setUserRank(i + 1);
                }
                // 开始查特定玩家
                if (userMac != null && !userMac.isEmpty())
                {
                    // 查看该玩家是否位于排行榜前N名
                    for (UserRankingDto userRankingDto : userRankingListTopN) {
                        if (userRankingDto.getUserMac().equals(userMac)) {
                            userRankingDtoByMac = new UserRankingDto(userRankingDto);
                            break;
                        }
                    }
                    // 前N里面没找到，那就去查userMac的信息
                    if (userRankingDtoByMac == null)
                    {
                        userRankingDtoByMac = gameDataRankingMapper.getUserRankingByMac(userMac);
                    }
                }
            }

            UserRankingNeeded userRankingNeeded = new UserRankingNeeded();
            userRankingNeeded.setUserRankingListTopN(userRankingListTopN);
            userRankingNeeded.setUserRankingDtoByMac(userRankingDtoByMac);
            return userRankingNeeded;
        }catch (Exception e){
            log.error("getUserRankingListTopN 出错:{}",e.getMessage(), e.fillInStackTrace());
            throw new RuntimeException(e);
        }
    }
}
