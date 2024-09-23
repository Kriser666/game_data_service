package com.cntytw.datapicker.dologalaxy.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @apiNote 通用字段处理类
 * @author Kriser666
 */
@Slf4j
@Component
public class CommonFieldHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("开始插入数据....");
        log.debug(metaObject.toString());
        this.setFieldValByName("creationDate", LocalDateTime.now(), metaObject);
        this.setFieldValByName("lastUpdateDate", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("开始更新数据....");
        log.debug(metaObject.toString());
        this.setFieldValByName("lastUpdateDate", LocalDateTime.now(), metaObject);
    }
}