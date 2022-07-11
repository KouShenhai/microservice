package com.somnus.microservice.limit;

import java.util.concurrent.TimeUnit;

/**
 * @author Kevin
 * @packageName com.somnus.microservice.limit
 * @title: LimitExecutor
 * @description: TODO
 * @date 2019/7/10 16:28
 */
public interface LimitExecutor {
    /**
     * 在给定的时间段里最多的访问限制次数(超出次数返回false)；等下个时间段开始，才允许再次被访问(返回true)，周而复始
     * @param name 资源名字
     * @param key 资源Key
     * @param rateInterval 给定的时间段(单位秒)
     * @param rate 最多的访问限制次数
     * @return boolean
     */
    boolean tryAccess(String name, String key, int rate, int rateInterval, TimeUnit rateIntervalUnit);

    boolean tryAccess(String compositeKey, int rate, int rateInterval, TimeUnit rateIntervalUnit);
}