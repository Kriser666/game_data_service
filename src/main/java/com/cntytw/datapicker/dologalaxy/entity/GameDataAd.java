package com.cntytw.datapicker.dologalaxy.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.cntytw.datapicker.common.tools.FieldDescription;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @apiNote 关于广告和商店的玩家数据
 * @author Kriser666
 * */
@Getter
@Setter
@TableName("dolo_galaxy_game_ad")
public class GameDataAd extends GameDataBase {

    @TableId
    @FieldDescription("ad表的主键")
    private Integer adPkId;

    @FieldDescription("玩家表的id")
    private Integer userInfoPkId;

    @JsonProperty("firstTimeAdEnded")
    @FieldDescription("首次观看广告是否结束")
    private Boolean firstTimeAdEnded;

    @JsonProperty("shopRewardClicks")
    @FieldDescription("首次是否点击猫老板的感叹号")
    private Boolean shopRewardClicks;

    @JsonProperty("buyVip")
    @FieldDescription("是否购买了VIP")
    private Boolean buyVip;

    @JsonProperty("buyAdToken")
    @FieldDescription("购买了多少个免广告卡")
    private Integer buyAdToken;

    @JsonProperty("clickAdTimes")
    @FieldDescription("广告点击次数")
    private Integer clickAdTimes;

    public GameDataAd(LocalDateTime creationDate, LocalDateTime lastUpdateDate, Integer adPkId, Integer userInfoPkId, Boolean firstTimeAdEnded, Boolean shopRewardClicks, Boolean buyVip, Integer buyAdToken, Integer clickAdTimes) {
        super(creationDate, lastUpdateDate);
        this.adPkId = adPkId;
        this.userInfoPkId = userInfoPkId;
        this.firstTimeAdEnded = firstTimeAdEnded;
        this.shopRewardClicks = shopRewardClicks;
        this.buyVip = buyVip;
        this.buyAdToken = buyAdToken;
        this.clickAdTimes = clickAdTimes;
    }
    public GameDataAd() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GameDataAd that = (GameDataAd) o;
        return Objects.equals(adPkId, that.adPkId) && Objects.equals(userInfoPkId, that.userInfoPkId) && Objects.equals(firstTimeAdEnded, that.firstTimeAdEnded) && Objects.equals(shopRewardClicks, that.shopRewardClicks) && Objects.equals(buyVip, that.buyVip) && Objects.equals(buyAdToken, that.buyAdToken) && Objects.equals(clickAdTimes, that.clickAdTimes);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(adPkId);
        result = 31 * result + Objects.hashCode(userInfoPkId);
        result = 31 * result + Objects.hashCode(firstTimeAdEnded);
        result = 31 * result + Objects.hashCode(shopRewardClicks);
        result = 31 * result + Objects.hashCode(buyVip);
        result = 31 * result + Objects.hashCode(buyAdToken);
        result = 31 * result + Objects.hashCode(clickAdTimes);
        return result;
    }

    @Override
    public String toString() {
        return "GameDataAd{" +
                "adPkId=" + adPkId +
                ", userInfoPkId=" + userInfoPkId +
                ", firstTimeAdEnded=" + firstTimeAdEnded +
                ", shopRewardClicks=" + shopRewardClicks +
                ", buyVip=" + buyVip +
                ", buyAdToken=" + buyAdToken +
                ", clickAdTimes=" + clickAdTimes +
                '}';
    }
}
