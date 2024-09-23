package com.cntytw.datapicker.dologalaxy.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @apiNote MybatisPlus配置类
 * @author Kriser666
 */
@Configuration
@MapperScan(basePackages = {"com.cntytw.datapicker.dologalaxy.mapper"})
@EnableTransactionManagement
public class MybatisPlusConfig {
    /**
     * 添加各种拦截器
     */
    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        // 其他需要的拦截器

        return interceptor;
    }
}