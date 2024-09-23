package com.cntytw.datapicker.dologalaxy.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.cntytw.datapicker.tools.FieldDescription;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@TableName("dolo_galaxy_game_user_info")
public class GameDataUserInfo extends GameDataBase {

    @TableId
    @FieldDescription("user_info表的主键")
    private Integer userInfoPkId;

    @JsonProperty("userMac")
    @FieldDescription("玩家mac地址")
    private String userMac;

    @JsonProperty("userNick")
    @FieldDescription("玩家昵称")
    private String userNick;

    public GameDataUserInfo(LocalDateTime creationDate, LocalDateTime lastUpdateDate, Integer userInfoPkId, String userMac, String userNick) {
        super(creationDate, lastUpdateDate);
        this.userInfoPkId = userInfoPkId;
        this.userMac = userMac;
        this.userNick = userNick;
    }
    public GameDataUserInfo() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GameDataUserInfo that = (GameDataUserInfo) o;
        return Objects.equals(userInfoPkId, that.userInfoPkId) && Objects.equals(userMac, that.userMac) && Objects.equals(userNick, that.userNick);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(userInfoPkId);
        result = 31 * result + Objects.hashCode(userMac);
        result = 31 * result + Objects.hashCode(userNick);
        return result;
    }

    @Override
    public String toString() {
        return "GameDataUserInfo{" +
                "userInfoPkId=" + userInfoPkId +
                ", userMac='" + userMac + '\'' +
                ", userNick='" + userNick + '\'' +
                '}';
    }
}
