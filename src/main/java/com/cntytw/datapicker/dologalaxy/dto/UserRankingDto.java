package com.cntytw.datapicker.dologalaxy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.cntytw.datapicker.common.tools.FieldDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRankingDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -1840831686851699943L;

    @JsonProperty("userMac")
    @FieldDescription("玩家mac")
    private String userMac;

    @JsonProperty("userNick")
    @FieldDescription("玩家昵称")
    private String userNick;

    @JsonProperty("userScore")
    @FieldDescription("玩家分数")
    private Integer userScore;

    @JsonProperty("userRank")
    @FieldDescription("玩家排名")
    private Integer userRank;

    public UserRankingDto(final UserRankingDto userRankingDto) {
        this.userMac = userRankingDto.userMac;
        this.userNick = userRankingDto.userNick;
        this.userScore = userRankingDto.userScore;
        this.userRank = userRankingDto.userRank;
    }
}
