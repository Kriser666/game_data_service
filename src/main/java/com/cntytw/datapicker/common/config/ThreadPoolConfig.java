package com.cntytw.datapicker.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @apiNote 线程池配置类
 * @author Kriser666
 */
@Configuration
public class ThreadPoolConfig {

    @Bean
    public ExecutorService crudThreadPool() {
        // 创建一个固定大小的线程池
        return Executors.newFixedThreadPool(4);
    }
}
