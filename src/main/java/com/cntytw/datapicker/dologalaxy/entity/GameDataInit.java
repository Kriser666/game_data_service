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
 * @apiNote 初始化阶段的玩家数据
 * @author Kriser666
* */
@Getter
@Setter
@TableName("dolo_galaxy_game_init")
public class GameDataInit extends GameDataBase {

    @TableId
    @FieldDescription("init表的主键")
    private Integer initPkId;

    @FieldDescription("玩家表的id")
    private Integer userInfoPkId;

    @JsonProperty("onGameLoaded")
    @FieldDescription("加载进度条结束，观看条漫前是否退出")
    private Boolean onGameLoaded;

    @JsonProperty("cartoonTime")
    @FieldDescription("结束条漫前待着的时间长度，单位秒")
    private Long cartoonTime;

    @JsonProperty("cartoonSkip")
    @FieldDescription("是否跳过开场条漫")
    private Boolean cartoonSkip;

    @JsonProperty("onTriggerTutorial")
    @FieldDescription("是否触发了新手教程提醒")
    private Boolean onTriggerTutorial;

    @JsonProperty("skipTutorial")
    @FieldDescription("触发新手教程后，是否点击了跳过")
    private Boolean skipTutorial;

    public GameDataInit(LocalDateTime creationDate, LocalDateTime lastUpdateDate, Integer initPkId, Integer userInfoPkId, Boolean onGameLoaded, Long cartoonTime, Boolean cartoonSkip, Boolean onTriggerTutorial, Boolean skipTutorial) {
        super(creationDate, lastUpdateDate);
        this.initPkId = initPkId;
        this.userInfoPkId = userInfoPkId;
        this.onGameLoaded = onGameLoaded;
        this.cartoonTime = cartoonTime;
        this.cartoonSkip = cartoonSkip;
        this.onTriggerTutorial = onTriggerTutorial;
        this.skipTutorial = skipTutorial;
    }
    public GameDataInit() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GameDataInit that = (GameDataInit) o;
        return Objects.equals(initPkId, that.initPkId) && Objects.equals(userInfoPkId, that.userInfoPkId) && Objects.equals(onGameLoaded, that.onGameLoaded) && Objects.equals(cartoonTime, that.cartoonTime) && Objects.equals(cartoonSkip, that.cartoonSkip) && Objects.equals(onTriggerTutorial, that.onTriggerTutorial) && Objects.equals(skipTutorial, that.skipTutorial);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(initPkId);
        result = 31 * result + Objects.hashCode(userInfoPkId);
        result = 31 * result + Objects.hashCode(onGameLoaded);
        result = 31 * result + Objects.hashCode(cartoonTime);
        result = 31 * result + Objects.hashCode(cartoonSkip);
        result = 31 * result + Objects.hashCode(onTriggerTutorial);
        result = 31 * result + Objects.hashCode(skipTutorial);
        return result;
    }

    @Override
    public String toString() {
        return "GameDataInit{" +
                "initPkId=" + initPkId +
                ", userInfoPkId=" + userInfoPkId +
                ", onGameLoaded=" + onGameLoaded +
                ", cartoonTime=" + cartoonTime +
                ", cartoonSkip=" + cartoonSkip +
                ", onTriggerTutorial=" + onTriggerTutorial +
                ", skipTutorial=" + skipTutorial +
                '}';
    }
}
