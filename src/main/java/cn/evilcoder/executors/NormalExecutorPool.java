package cn.evilcoder.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * User: Huangshanqi
 * Date: 2016/9/9
 * Time: 10:04
 * 常用线程池
 */
public class NormalExecutorPool {

    /**
     *
     * @return
     */
    public static void show() {
        Executor singleThreadExecutor = Executors.newSingleThreadExecutor();
        Executor fixedThreadPool = Executors.newFixedThreadPool(100);
        Executor cachedThreadPool = Executors.newCachedThreadPool();
        Executor scheduledThreadPool = Executors.newScheduledThreadPool(50);
    }
    /**
     * Param:
     * corePoolSize - 池中所保存的线程数，包括空闲线程。
     * maximumPoolSize - 池中允许的最大线程数(采用LinkedBlockingQueue时没有作用)。
     * keepAliveTime -当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间，线程池维护线程所允许的空闲时间。
     * unit - keepAliveTime参数的时间单位，线程池维护线程所允许的空闲时间的单位:秒 。
     * workQueue - 执行前用于保持任务的队列（缓冲队列）。此队列仅保持由execute 方法提交的 Runnable 任务。
     * RejectedExecutionHandler -线程池对拒绝任务的处理策略(重试添加当前的任务，自动重复调用execute()方法)
     */
}
