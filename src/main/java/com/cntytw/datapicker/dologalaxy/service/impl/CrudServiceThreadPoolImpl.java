package com.cntytw.datapicker.dologalaxy.service.impl;

import com.cntytw.datapicker.dologalaxy.service.CrudServiceThreadPool;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ExecutorService;

/**
 * @author Kriser666
 * @apiNote 线程池实现类
 */
@Getter
@Slf4j
@Service
public class CrudServiceThreadPoolImpl implements CrudServiceThreadPool {

    private final ExecutorService EXECUTOR_SERVICE;

    // 线程需要执行的函数
    private Runnable function;

    @Autowired
    public CrudServiceThreadPoolImpl(ExecutorService executorService) {
        this.EXECUTOR_SERVICE = executorService;
    }

    /**
     * @param func 线程需要执行的函数
     * @apiNote 启动线程函数
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void run(Runnable func) {
        EXECUTOR_SERVICE.submit(() -> {
            function = func;
            log.debug("当前线程: {}", Thread.currentThread().getName());
            function.run();
        });
    }
}
