package com.cntytw.datapicker.dologalaxy.vo;

import com.cntytw.datapicker.dologalaxy.dto.UserRankingDto;
import com.cntytw.datapicker.common.tools.FieldDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class UserRankingNeeded implements Serializable {
    @Serial
    private static final long serialVersionUID = -1840831686851699943L;
    @JsonProperty("userRankingDtoByMac")
    @FieldDescription("通过玩家mac查出来的玩家排名信息")
    private UserRankingDto userRankingDtoByMac;
    @JsonProperty("userRankingListTopN")
    @FieldDescription("前N名的玩家信息列表")
    private List<UserRankingDto> userRankingListTopN;
}
