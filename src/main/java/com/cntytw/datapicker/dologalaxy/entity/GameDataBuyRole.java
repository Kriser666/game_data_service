package com.cntytw.datapicker.dologalaxy.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.cntytw.datapicker.tools.FieldDescription;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Kriser666
 * @apiNote 关于购买角色的玩家数据
 */
@Getter
@Setter
@TableName("dolo_galaxy_game_buy_role")
public class GameDataBuyRole extends GameDataBase {

    @TableId
    @FieldDescription("buy_role表的主键")
    private Integer buyRolePkId;

    @FieldDescription("玩家表的id")
    private Integer userInfoPkId;

    @JsonProperty("firstBuyCharacterName")
    @FieldDescription("首次购买角色名称")
    private String firstBuyCharacterName;

    @JsonProperty("onTuzayUnlock")
    @FieldDescription("是否购买角色Tuzay")
    private Boolean onTuzayUnlock;

    @JsonProperty("onXocUnlock")
    @FieldDescription("是否购买角色Xoc")
    private Boolean onXocUnlock;

    @JsonProperty("onBlueUnlock")
    @FieldDescription("是否购买角色Blue")
    private Boolean onBlueUnlock;

    @JsonProperty("onSaverUnlock")
    @FieldDescription("是否购买角色Saver")
    private Boolean onSaverUnlock;

    @JsonProperty("upLucyToThree")
    @FieldDescription("是否升级角色Lucy至3级")
    private Boolean upLucyToThree;

    @JsonProperty("upLucyToFive")
    @FieldDescription("是否升级角色Lucy至5级")
    private Boolean upLucyToFive;

    @JsonProperty("upTuzayToThree")
    @FieldDescription("是否升级角色Tuzay至3级")
    private Boolean upTuzayToThree;

    @JsonProperty("upTuzayToFive")
    @FieldDescription("是否升级角色Tuzay至5级")
    private Boolean upTuzayToFive;

    @JsonProperty("upXocToThree")
    @FieldDescription("是否升级角色Xoc至3级")
    private Boolean upXocToThree;

    @JsonProperty("upXocToFive")
    @FieldDescription("是否升级角色Xoc至5级")
    private Boolean upXocToFive;

    @JsonProperty("upBlueToThree")
    @FieldDescription("是否升级角色Blue至3级")
    private Boolean upBlueToThree;

    @JsonProperty("upBlueToFive")
    @FieldDescription("是否升级角色Blue至5级")
    private Boolean upBlueToFive;

    @JsonProperty("upSaverToThree")
    @FieldDescription("是否升级角色Saver至3级")
    private Boolean upSaverToThree;

    @JsonProperty("upSaverToFive")
    @FieldDescription("是否升级角色Saver至5级")
    private Boolean upSaverToFive;

    public GameDataBuyRole(LocalDateTime creationDate, LocalDateTime lastUpdateDate, Integer buyRolePkId, Integer userInfoPkId, String firstBuyCharacterName, Boolean onTuzayUnlock, Boolean onXocUnlock, Boolean onBlueUnlock, Boolean onSaverUnlock, Boolean upLucyToThree, Boolean upLucyToFive, Boolean upTuzayToThree, Boolean upTuzayToFive, Boolean upXocToThree, Boolean upXocToFive, Boolean upBlueToThree, Boolean upBlueToFive, Boolean upSaverToThree, Boolean upSaverToFive) {
        super(creationDate, lastUpdateDate);
        this.buyRolePkId = buyRolePkId;
        this.userInfoPkId = userInfoPkId;
        this.firstBuyCharacterName = firstBuyCharacterName;
        this.onTuzayUnlock = onTuzayUnlock;
        this.onXocUnlock = onXocUnlock;
        this.onBlueUnlock = onBlueUnlock;
        this.onSaverUnlock = onSaverUnlock;
        this.upLucyToThree = upLucyToThree;
        this.upLucyToFive = upLucyToFive;
        this.upTuzayToThree = upTuzayToThree;
        this.upTuzayToFive = upTuzayToFive;
        this.upXocToThree = upXocToThree;
        this.upXocToFive = upXocToFive;
        this.upBlueToThree = upBlueToThree;
        this.upBlueToFive = upBlueToFive;
        this.upSaverToThree = upSaverToThree;
        this.upSaverToFive = upSaverToFive;
    }
    public GameDataBuyRole() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GameDataBuyRole that = (GameDataBuyRole) o;
        return Objects.equals(buyRolePkId, that.buyRolePkId) && Objects.equals(userInfoPkId, that.userInfoPkId) && Objects.equals(firstBuyCharacterName, that.firstBuyCharacterName) && Objects.equals(onTuzayUnlock, that.onTuzayUnlock) && Objects.equals(onXocUnlock, that.onXocUnlock) && Objects.equals(onBlueUnlock, that.onBlueUnlock) && Objects.equals(onSaverUnlock, that.onSaverUnlock) && Objects.equals(upLucyToThree, that.upLucyToThree) && Objects.equals(upLucyToFive, that.upLucyToFive) && Objects.equals(upTuzayToThree, that.upTuzayToThree) && Objects.equals(upTuzayToFive, that.upTuzayToFive) && Objects.equals(upXocToThree, that.upXocToThree) && Objects.equals(upXocToFive, that.upXocToFive) && Objects.equals(upBlueToThree, that.upBlueToThree) && Objects.equals(upBlueToFive, that.upBlueToFive) && Objects.equals(upSaverToThree, that.upSaverToThree) && Objects.equals(upSaverToFive, that.upSaverToFive);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(buyRolePkId);
        result = 31 * result + Objects.hashCode(userInfoPkId);
        result = 31 * result + Objects.hashCode(firstBuyCharacterName);
        result = 31 * result + Objects.hashCode(onTuzayUnlock);
        result = 31 * result + Objects.hashCode(onXocUnlock);
        result = 31 * result + Objects.hashCode(onBlueUnlock);
        result = 31 * result + Objects.hashCode(onSaverUnlock);
        result = 31 * result + Objects.hashCode(upLucyToThree);
        result = 31 * result + Objects.hashCode(upLucyToFive);
        result = 31 * result + Objects.hashCode(upTuzayToThree);
        result = 31 * result + Objects.hashCode(upTuzayToFive);
        result = 31 * result + Objects.hashCode(upXocToThree);
        result = 31 * result + Objects.hashCode(upXocToFive);
        result = 31 * result + Objects.hashCode(upBlueToThree);
        result = 31 * result + Objects.hashCode(upBlueToFive);
        result = 31 * result + Objects.hashCode(upSaverToThree);
        result = 31 * result + Objects.hashCode(upSaverToFive);
        return result;
    }

    @Override
    public String toString() {
        return "GameDataBuyRole{" +
                "buyRolePkId=" + buyRolePkId +
                ", userInfoPkId=" + userInfoPkId +
                ", firstBuyCharacterName='" + firstBuyCharacterName + '\'' +
                ", onTuzayUnlock=" + onTuzayUnlock +
                ", onXocUnlock=" + onXocUnlock +
                ", onBlueUnlock=" + onBlueUnlock +
                ", onSaverUnlock=" + onSaverUnlock +
                ", upLucyToThree=" + upLucyToThree +
                ", upLucyToFive=" + upLucyToFive +
                ", upTuzayToThree=" + upTuzayToThree +
                ", upTuzayToFive=" + upTuzayToFive +
                ", upXocToThree=" + upXocToThree +
                ", upXocToFive=" + upXocToFive +
                ", upBlueToThree=" + upBlueToThree +
                ", upBlueToFive=" + upBlueToFive +
                ", upSaverToThree=" + upSaverToThree +
                ", upSaverToFive=" + upSaverToFive +
                '}';
    }
}
