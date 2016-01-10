package com.zxz.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 学智 on 2016-01-03.
 */
public class ThreadPool {

    private ExecutorService mExecutor = Executors.newCachedThreadPool();

    private static ThreadPool mInstance = new ThreadPool();

    private ThreadPool() {}

    private static ThreadPool getInstance() {
        return mInstance;
    }

    public static void execute(Runnable runnable) {
        ThreadPool.getInstance().mExecutor.execute(runnable);
    }

}
