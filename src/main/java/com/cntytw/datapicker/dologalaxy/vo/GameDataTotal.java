package com.cntytw.datapicker.dologalaxy.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.cntytw.datapicker.dologalaxy.entity.*;
import com.cntytw.datapicker.common.tools.FieldDescription;
import lombok.Data;

/**
 * @apiNote 玩家的所有数据
 * @author Kriser666
 * */
@Data
public class GameDataTotal {

    @JsonProperty("userInfo")
    @FieldDescription("用户信息")
    private GameDataUserInfo userInfo;

    @JsonProperty("gameDataInit")
    @FieldDescription("初始化阶段的玩家数据")
    private GameDataInit gameDataInit;

    @JsonProperty("gameDataLevel")
    @FieldDescription("关于关卡的玩家数据")
    private GameDataLevel gameDataLevel;

    @JsonProperty("gameDataAd")
    @FieldDescription("关于广告和商店的玩家数据")
    private GameDataAd gameDataAd;

    @JsonProperty("gameDataBuyRole")
    @FieldDescription("关于购买角色的玩家数据")
    private GameDataBuyRole gameDataBuyRole;

    @JsonProperty("gameDataRanking")
    @FieldDescription("关于排行榜的玩家数据")
    private GameDataRanking gameDataRanking;

    @Override
    public String toString() {
        return "GameDataTotal{" +
                "userInfo=" + userInfo +
                "\n gameDataInit=" + gameDataInit +
                "\n gameDataLevel=" + gameDataLevel +
                "\n gameDataAd=" + gameDataAd +
                "\n gameDataBuyRole=" + gameDataBuyRole +
                "\n gameDataRanking=" + gameDataRanking +
                '}';
    }
}
