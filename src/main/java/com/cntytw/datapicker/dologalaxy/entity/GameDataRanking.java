package com.cntytw.datapicker.dologalaxy.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cntytw.datapicker.common.tools.FieldDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@TableName("dolo_galaxy_game_ranking")
public class GameDataRanking extends GameDataBase {

    @TableId
    @FieldDescription("ranking表的主键")
    private Integer rankingPkId;

    @FieldDescription("玩家表的id")
    private Integer userInfoPkId;

    @JsonProperty("userScore")
    @FieldDescription("分数")
    private Integer userScore;

    @JsonProperty("userFrom")
    @FieldDescription("从哪个平台来的")
    private String userFrom;

    public GameDataRanking(LocalDateTime creationDate, LocalDateTime lastUpdateDate, Integer rankingPkId, Integer userInfoPkId, Integer userScore, String userFrom) {
        super(creationDate, lastUpdateDate);
        this.rankingPkId = rankingPkId;
        this.userInfoPkId = userInfoPkId;
        this.userScore = userScore;
        this.userFrom = userFrom;
    }
    public GameDataRanking() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GameDataRanking that = (GameDataRanking) o;
        return Objects.equals(rankingPkId, that.rankingPkId) && Objects.equals(userInfoPkId, that.userInfoPkId) && Objects.equals(userScore, that.userScore) && Objects.equals(userFrom, that.userFrom);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(rankingPkId);
        result = 31 * result + Objects.hashCode(userInfoPkId);
        result = 31 * result + Objects.hashCode(userScore);
        result = 31 * result + Objects.hashCode(userFrom);
        return result;
    }
    @Override
    public String toString() {
        return "GameDataRanking{" +
                "rankingPkId=" + rankingPkId +
                ", userInfoPkId=" + userInfoPkId +
                ", userScore=" + userScore +
                ", userFrom='" + userFrom + '\'' +
                '}';
    }
}
