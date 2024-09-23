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
 * @apiNote 关于关卡的玩家数据
 * @author Kriser666
 * */
@Setter
@Getter
@TableName("dolo_galaxy_game_level")
public class GameDataLevel extends GameDataBase {

    @TableId
    @FieldDescription("level表的主键")
    private Integer levelPkId;

    @FieldDescription("玩家表的id")
    private Integer userInfoPkId;

    @JsonProperty("reachMaxLv")
    @FieldDescription("最大通关的小关ID")
    private String reachMaxLv;

    @JsonProperty("onMaxMazeComplete")
    @FieldDescription("最大通关的大关ID")
    private String onMaxMazeComplete;

    @JsonProperty("onPlayerDieMazeId")
    @FieldDescription("玩家阵亡时所在大关卡ID")
    private String onPlayerDieMazeId;

    @JsonProperty("onPlayerDieLevelId")
    @FieldDescription("玩家阵亡时所在小关卡ID")
    private String onPlayerDieLevelId;

    @JsonProperty("onPlayerDieHp")
    @FieldDescription("玩家阵亡时的生命")
    private Integer onPlayerDieHp;

    @JsonProperty("onPlayerDieAtk")
    @FieldDescription("玩家阵亡时的攻击")
    private Integer onPlayerDieAtk;

    @JsonProperty("onLastLevelContinueTry")
    @FieldDescription("已通关噩梦难度-格利泽暖洋后,是否再次进入噩梦难度-格利泽暖洋")
    private Boolean onLastMazeContinueTry;

    public GameDataLevel(LocalDateTime creationDate, LocalDateTime lastUpdateDate, Integer levelPkId, Integer userInfoPkId, String reachMaxLv, String onMaxMazeComplete, String onPlayerDieMazeId, String onPlayerDieLevelId, Integer onPlayerDieHp, Integer onPlayerDieAtk, Boolean onLastMazeContinueTry) {
        super(creationDate, lastUpdateDate);
        this.levelPkId = levelPkId;
        this.userInfoPkId = userInfoPkId;
        this.reachMaxLv = reachMaxLv;
        this.onMaxMazeComplete = onMaxMazeComplete;
        this.onPlayerDieMazeId = onPlayerDieMazeId;
        this.onPlayerDieLevelId = onPlayerDieLevelId;
        this.onPlayerDieHp = onPlayerDieHp;
        this.onPlayerDieAtk = onPlayerDieAtk;
        this.onLastMazeContinueTry = onLastMazeContinueTry;
    }
    public GameDataLevel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GameDataLevel that = (GameDataLevel) o;
        return Objects.equals(levelPkId, that.levelPkId) && Objects.equals(userInfoPkId, that.userInfoPkId) && Objects.equals(reachMaxLv, that.reachMaxLv) && Objects.equals(onMaxMazeComplete, that.onMaxMazeComplete) && Objects.equals(onPlayerDieMazeId, that.onPlayerDieMazeId) && Objects.equals(onPlayerDieLevelId, that.onPlayerDieLevelId) && Objects.equals(onPlayerDieHp, that.onPlayerDieHp) && Objects.equals(onPlayerDieAtk, that.onPlayerDieAtk) && Objects.equals(onLastMazeContinueTry, that.onLastMazeContinueTry);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(levelPkId);
        result = 31 * result + Objects.hashCode(userInfoPkId);
        result = 31 * result + Objects.hashCode(reachMaxLv);
        result = 31 * result + Objects.hashCode(onMaxMazeComplete);
        result = 31 * result + Objects.hashCode(onPlayerDieMazeId);
        result = 31 * result + Objects.hashCode(onPlayerDieLevelId);
        result = 31 * result + Objects.hashCode(onPlayerDieHp);
        result = 31 * result + Objects.hashCode(onPlayerDieAtk);
        result = 31 * result + Objects.hashCode(onLastMazeContinueTry);
        return result;
    }

    @Override
    public String toString() {
        return "GameDataLevel{" +
                "levelPkId=" + levelPkId +
                ", userInfoPkId=" + userInfoPkId +
                ", reachMaxLv='" + reachMaxLv + '\'' +
                ", onMaxMazeComplete='" + onMaxMazeComplete + '\'' +
                ", onPlayerDieMazeId='" + onPlayerDieMazeId + '\'' +
                ", onPlayerDieLevelId='" + onPlayerDieLevelId + '\'' +
                ", onPlayerDieHp=" + onPlayerDieHp +
                ", onPlayerDieAtk=" + onPlayerDieAtk +
                ", onLastMazeContinueTry=" + onLastMazeContinueTry +
                '}';
    }
}
