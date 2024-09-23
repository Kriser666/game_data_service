package com.cntytw.datapicker.dologalaxy.controller;

import com.cntytw.datapicker.dologalaxy.dto.UserRankingNeededDto;
import com.cntytw.datapicker.dologalaxy.service.RankingDataService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kriser666
 * @apiNote 嘟噜一笔银河排行榜信息查询
 */
@Slf4j
@RestController
@RequestMapping("/dolodatapicker/api/")
public class RankingDataController {
    @Resource
    private RankingDataService rankingDataService;

    /**
     * @param count   查询条数
     * @param userMac 查询当前玩家的排名，和总体排名一并发送给调用者
     * @return 玩家分数数据
     * @apiNote 查询排行榜前N名的玩家的数据
     */
    @RequestMapping("/userranking")
    public ResponseEntity<UserRankingNeededDto> getUserRankingListTopN(String userMac, Integer count) {
        log.debug("两个参数为 => userMac:{}, count:{}", userMac, count);
        // 如果不传递参数，默认查100名
        if (count == null || count <= 0) {
            count = 100;
        }
        try {
            UserRankingNeededDto userRankingListTopN = rankingDataService.getUserRankingListTopN(userMac, count);
            return new ResponseEntity<>(userRankingListTopN, HttpStatus.OK);
        } catch (Exception e) {
            log.error("查询排行榜前{}名玩家的数据异常：", count, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
