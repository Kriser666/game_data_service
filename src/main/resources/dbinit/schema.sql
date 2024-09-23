use `game-data-picker`;
drop table if exists `dolo_galaxy_game_user_info`;
drop table if exists `dolo_galaxy_game_init`;
drop table if exists `dolo_galaxy_game_level`;
drop table if exists `dolo_galaxy_game_ad`;
drop table if exists `dolo_galaxy_game_buy_role`;
drop table if exists `dolo_galaxy_game_ranking`;

CREATE TABLE `dolo_galaxy_game_user_info`
(
    `user_info_pk_id`  int         NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_mac`         varchar(40) NOT NULL COMMENT '玩家mac地址',
    `user_nick`        varchar(20) NOT NULL COMMENT '用户昵称',
    `creation_date`    datetime    NOT NULL COMMENT '创建时间',
    `last_update_date` datetime    NOT NULL COMMENT '最后更新时间',
    PRIMARY KEY (`user_info_pk_id`),
    UNIQUE KEY `user_info_pk_id_UNIQUE` (`user_info_pk_id`),
    UNIQUE KEY `user_mac_UNIQUE` (`user_mac`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='用户信息';

CREATE TABLE `dolo_galaxy_game_init`
(
    `init_pk_id`          int      NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_info_pk_id`     int      NOT NULL COMMENT '用户信息表id',
    `on_game_loaded`      tinyint DEFAULT '1' COMMENT '加载进度条结束，观看条漫前是否退出',
    `cartoon_time`        bigint  DEFAULT '1' COMMENT '结束条漫前待着的时间长度，单位秒',
    `cartoon_skip`        tinyint DEFAULT '1' COMMENT '是否跳过开场条漫',
    `on_trigger_tutorial` tinyint DEFAULT '1' COMMENT '是否触发了新手教程提醒',
    `skip_tutorial`       tinyint DEFAULT '1' COMMENT '触发新手教程后，是否点击了跳过',
    `creation_date`       datetime NOT NULL COMMENT '创建时间',
    `last_update_date`    datetime NOT NULL COMMENT '最后更新时间',
    PRIMARY KEY (`init_pk_id`),
    FOREIGN KEY (`user_info_pk_id`)
        REFERENCES `game-data-picker`.`dolo_galaxy_game_user_info` (`user_info_pk_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='嘟噜一笔银河玩家数据采集表-初入游戏主界面';

CREATE TABLE `dolo_galaxy_game_level`
(
    `level_pk_id`               int      NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_info_pk_id`           int      NOT NULL COMMENT '用户信息表id',
    `reach_max_lv`              varchar(40) DEFAULT '1' COMMENT '最大通关的小关ID',
    `on_max_maze_complete`      varchar(40) DEFAULT '1' COMMENT '最大通关的大关ID',
    `on_player_die_maze_id`     varchar(40) DEFAULT '1' COMMENT '玩家阵亡时所在大关卡ID',
    `on_player_die_level_id`    varchar(40) DEFAULT '1' COMMENT '玩家阵亡时所在小关卡ID',
    `on_player_die_hp`          int         DEFAULT '1' COMMENT '玩家阵亡时的生命',
    `on_player_die_atk`         int         DEFAULT '1' COMMENT '玩家阵亡时的攻击',
    `on_last_maze_continue_try` tinyint     DEFAULT '1' COMMENT '已通关噩梦难度-格利泽暖洋后,是否再次进入噩梦难度-格利泽暖洋',
    `creation_date`             datetime NOT NULL COMMENT '创建时间',
    `last_update_date`          datetime NOT NULL COMMENT '最后更新时间',
    PRIMARY KEY (`level_pk_id`),
    FOREIGN KEY (`user_info_pk_id`)
        REFERENCES `game-data-picker`.`dolo_galaxy_game_user_info` (`user_info_pk_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='关于游戏关卡的玩家数据';

CREATE TABLE `dolo_galaxy_game_ad`
(
    `ad_pk_id`            int      NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_info_pk_id`     int      NOT NULL COMMENT '用户信息表id',
    `first_time_ad_ended` tinyint DEFAULT '1' COMMENT '首次观看广告是否结束',
    `shop_reward_clicks`  tinyint DEFAULT '1' COMMENT '首次是否点击猫老板的感叹号',
    `buy_vip`             tinyint DEFAULT '1' COMMENT '是否购买了VIP',
    `buy_ad_token`        int     DEFAULT '1' COMMENT '购买了多少个免广告卡',
    `click_ad_times`      int     DEFAULT '1' COMMENT '广告点击次数',
    `creation_date`       datetime NOT NULL COMMENT '创建时间',
    `last_update_date`    datetime NOT NULL COMMENT '最后更新时间',
    PRIMARY KEY (`ad_pk_id`),
    FOREIGN KEY (`user_info_pk_id`)
        REFERENCES `game-data-picker`.`dolo_galaxy_game_user_info` (`user_info_pk_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='关于游戏商店和广告的玩家数据';

CREATE TABLE `dolo_galaxy_game_buy_role`
(
    `buy_role_pk_id`           int      NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_info_pk_id`          int      NOT NULL COMMENT '用户信息表id',
    `first_buy_character_name` varchar(40) DEFAULT '1' COMMENT '首次购买角色名称',
    `on_tuzay_unlock`          tinyint     DEFAULT '1' COMMENT '是否购买角色Tuzay',
    `on_xoc_unlock`            tinyint     DEFAULT '1' COMMENT '是否购买角色Xoc',
    `on_blue_unlock`           tinyint     DEFAULT '1' COMMENT '是否购买角色Blue',
    `on_saver_unlock`          tinyint     DEFAULT '1' COMMENT '是否购买角色Saver',
    `up_lucy_to_three`         tinyint     DEFAULT '1' COMMENT '是否升级角色Lucy至3级',
    `up_lucy_to_five`          tinyint     DEFAULT '1' COMMENT '是否升级角色Lucy至5级',
    `up_tuzay_to_three`        tinyint     DEFAULT '1' COMMENT '是否升级角色Tuzay至3级',
    `up_tuzay_to_five`         tinyint     DEFAULT '1' COMMENT '是否升级角色Tuzay至5级',
    `up_xoc_to_three`          tinyint     DEFAULT '1' COMMENT '是否升级角色Xoc至3级',
    `up_xoc_to_five`           tinyint     DEFAULT '1' COMMENT '是否升级角色Xoc至5级',
    `up_blue_to_three`         tinyint     DEFAULT '1' COMMENT '是否升级角色Blue至3级',
    `up_blue_to_five`          tinyint     DEFAULT '1' COMMENT '是否升级角色Blue至5级',
    `up_saver_to_three`        tinyint     DEFAULT '1' COMMENT '是否升级角色Saver至3级',
    `up_saver_to_five`         tinyint     DEFAULT '1' COMMENT '是否升级角色Saver至5级',
    `creation_date`            datetime NOT NULL COMMENT '创建时间',
    `last_update_date`         datetime NOT NULL COMMENT '最后更新时间',
    PRIMARY KEY (`buy_role_pk_id`),
    FOREIGN KEY (`user_info_pk_id`)
        REFERENCES `game-data-picker`.`dolo_galaxy_game_user_info` (`user_info_pk_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='玩家对角色的购买行为';

CREATE TABLE `dolo_galaxy_game_ranking`
(
    `ranking_pk_id`    int      NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_info_pk_id`  int      NOT NULL COMMENT '用户信息表id',
    `user_score`       int default '0' comment '用户分数',
    `user_from`        varchar(20) comment '哪个平台的用户',
    `creation_date`    datetime NOT NULL COMMENT '创建时间',
    `last_update_date` datetime NOT NULL COMMENT '最后更新时间',
    PRIMARY KEY (`ranking_pk_id`),
    FOREIGN KEY (`user_info_pk_id`)
        REFERENCES `game-data-picker`.`dolo_galaxy_game_user_info` (`user_info_pk_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='排行榜数据';