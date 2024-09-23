package com.cntytw.datapicker.dologalaxy.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.cntytw.datapicker.tools.FieldDescription;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import static com.baomidou.mybatisplus.annotation.FieldFill.INSERT;
import static com.baomidou.mybatisplus.annotation.FieldFill.INSERT_UPDATE;

/**
 * @apiNote 公共数据
 * @author Kriser666
 */
@Setter
@Getter
public class GameDataBase implements Serializable {

    @Serial
    private static final long serialVersionUID = -1840831686851699943L;

    @TableField(fill = INSERT)
    @FieldDescription("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime creationDate;

    @TableField(fill = INSERT_UPDATE)
    @FieldDescription("最后更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastUpdateDate;

    public GameDataBase(LocalDateTime creationDate, LocalDateTime lastUpdateDate) {
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
    }
    public GameDataBase() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameDataBase that = (GameDataBase) o;
        return Objects.equals(creationDate, that.creationDate) && Objects.equals(lastUpdateDate, that.lastUpdateDate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(creationDate);
        result = 31 * result + Objects.hashCode(lastUpdateDate);
        return result;
    }

    @Override
    public String toString() {
        return "GameDataBase{" +
                "creationDate=" + creationDate +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }
}
