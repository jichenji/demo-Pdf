package com.chenji.demo.pdf.api.common.utils;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by wangzhigang on 2017/4/24.
 */
public class ExecutorServiceUtil {
    public static final ListeningExecutorService executorService;

    static {
        final ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("ExecutorServiceUtil-%d")
                .setDaemon(true)
                .build();
        executorService = MoreExecutors
                .listeningDecorator(Executors.newFixedThreadPool(10, threadFactory));
    }
}
