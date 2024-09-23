package com.cntytw.datapicker.dologalaxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cntytw.datapicker.dologalaxy.entity.*;
import com.cntytw.datapicker.dologalaxy.mapper.*;
import com.cntytw.datapicker.dologalaxy.service.PickedDataService;
import com.cntytw.datapicker.dologalaxy.vo.GameDataTotal;
import com.cntytw.datapicker.tools.StringTools;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;

/**
 * @author Kriser666
 * @apiNote 跟踪数据的service实现
 */
@Slf4j
@Service
public class PickedDataServiceImpl implements PickedDataService {

    @Resource
    private GameDataUserInfoMapper gameDataUserInfoMapper;
    @Resource
    private GameDataAdMapper gameDataAdMapper;
    @Resource
    private GameDataBuyRoleMapper gameDataBuyRoleMapper;
    @Resource
    private GameDataInitMapper gameDataInitMapper;
    @Resource
    private GameDataLevelMapper gameDataLevelMapper;
    @Resource
    private GameDataRankingMapper gameDataRankingMapper;

    private final CrudServiceThreadPoolImpl CRUD_SERVICE_THREAD_POOL;

    @Autowired
    public PickedDataServiceImpl(CrudServiceThreadPoolImpl crudServiceThreadPool) {
        this.CRUD_SERVICE_THREAD_POOL = crudServiceThreadPool;
    }

    /**
     * @param gameDataTotal 玩家数据
     * @apiNote 保存追踪的数据
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveTrackData(final GameDataTotal gameDataTotal) {
        // 获取各个分量
        GameDataUserInfo userInfo = gameDataTotal.getUserInfo();
        GameDataAd gameDataAd = gameDataTotal.getGameDataAd();
        GameDataBuyRole gameDataBuyRole = gameDataTotal.getGameDataBuyRole();
        GameDataInit gameDataInit = gameDataTotal.getGameDataInit();
        GameDataLevel gameDataLevel = gameDataTotal.getGameDataLevel();
        GameDataRanking gameDataRanking = gameDataTotal.getGameDataRanking();

        try {
            // 先查找玩家表有没有数据
            GameDataUserInfo dbUserInfo = gameDataUserInfoMapper.selectByMac(userInfo.getUserMac());
            // 如果用户数据为空，就插入
            if (null == dbUserInfo) {
                // 先同步插入用户数据
                gameDataUserInfoMapper.insert(userInfo);
                // 由于主键自增，那么当前用户数据主键就是最大主键
                Integer curUserInfoPkId = gameDataUserInfoMapper.selectMaxId();

                CRUD_SERVICE_THREAD_POOL.run(() -> {
                    gameDataAd.setUserInfoPkId(curUserInfoPkId);
                    gameDataAdMapper.insert(gameDataAd);
                });
                CRUD_SERVICE_THREAD_POOL.run(() -> {
                    gameDataBuyRole.setUserInfoPkId(curUserInfoPkId);
                    gameDataBuyRoleMapper.insert(gameDataBuyRole);
                });
                CRUD_SERVICE_THREAD_POOL.run(() -> {
                    gameDataInit.setUserInfoPkId(curUserInfoPkId);
                    gameDataInitMapper.insert(gameDataInit);
                });
                CRUD_SERVICE_THREAD_POOL.run(() -> {
                    gameDataLevel.setUserInfoPkId(curUserInfoPkId);
                    gameDataLevelMapper.insert(gameDataLevel);
                });
                CRUD_SERVICE_THREAD_POOL.run(() -> {
                    gameDataRanking.setUserInfoPkId(curUserInfoPkId);
                    gameDataRankingMapper.insert(gameDataRanking);
                });
            } else {
                Integer userInfoPkId = dbUserInfo.getUserInfoPkId();

                CRUD_SERVICE_THREAD_POOL.run(() -> {
                    userInfo.setUserInfoPkId(userInfoPkId);
                    gameDataUserInfoMapper.updateById(userInfo);
                });
                CRUD_SERVICE_THREAD_POOL.run(() -> {
                    gameDataAd.setUserInfoPkId(userInfoPkId);
                    updateByColumn("user_info_pk_id", gameDataAd, gameDataAdMapper);
                });
                CRUD_SERVICE_THREAD_POOL.run(() -> {
                    gameDataBuyRole.setUserInfoPkId(userInfoPkId);
                    updateByColumn("user_info_pk_id", gameDataBuyRole, gameDataBuyRoleMapper);
                });
                CRUD_SERVICE_THREAD_POOL.run(() -> {
                    gameDataInit.setUserInfoPkId(userInfoPkId);
                    updateByColumn("user_info_pk_id", gameDataInit, gameDataInitMapper);
                });
                CRUD_SERVICE_THREAD_POOL.run(() -> {
                    gameDataLevel.setUserInfoPkId(userInfoPkId);
                    updateByColumn("user_info_pk_id", gameDataLevel, gameDataLevelMapper);
                });
                CRUD_SERVICE_THREAD_POOL.run(() -> {
                    gameDataRanking.setUserInfoPkId(userInfoPkId);
                    updateByColumn("user_info_pk_id", gameDataRanking, gameDataRankingMapper);
                });
            }
        }
        catch (Exception e) {
            log.error("保存用户数据失败: {}\n", e.getMessage(), e.fillInStackTrace());
            throw new RuntimeException(e);
        }

    }

    /**
     * @param column     数据库字段列名
     * @param value      要更新的实体对象
     * @param baseMapper 继承自baseMapper的类对象
     * @apiNote 更新baseMapper的数据
     */
    private <T> void updateByColumn(String column, T value, BaseMapper<T> baseMapper) {
        // 先将下划线命名转化为小驼峰，以匹配字段名称
        String fieldName = StringTools.convertSnakeToCamelCase(column);
        try {
            // 获取列名匹配的字段
            Field field = value.getClass().getDeclaredField(fieldName);
            // 确保可以访问私有字段
            field.setAccessible(true);
            // 获取字段的值
            Object fieldValue = field.get(value);
            Wrapper<T> updateWrapper = new UpdateWrapper<T>().eq(column, fieldValue);
            baseMapper.update(value, updateWrapper);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            log.error("根据字段值更新失败: {}", e.getMessage());
            throw new RuntimeException(e);
        } catch (Exception e) {
            log.error("出现异常: {}", e.getMessage());
            throw new RuntimeException(e);
        }

    }

}
