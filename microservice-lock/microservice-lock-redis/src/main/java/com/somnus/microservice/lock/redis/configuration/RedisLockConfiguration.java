package com.somnus.microservice.lock.redis.configuration;

import com.somnus.microservice.commons.redis.handler.RedisHandler;
import com.somnus.microservice.commons.redis.handler.RedisHandlerImpl;
import com.somnus.microservice.lock.LockDelegate;
import com.somnus.microservice.lock.LockExecutor;
import com.somnus.microservice.lock.redis.condition.RedisLockCondition;
import com.somnus.microservice.lock.redis.impl.RedisLockDelegateImpl;
import com.somnus.microservice.lock.redis.impl.RedisLockExecutorImpl;
import org.redisson.api.RLock;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kevin
 * @packageName com.somnus.microservice.redis.configuration
 * @title: RedisLockConfiguration
 * @description: TODO
 * @date 2019/6/14 15:42
 */
@Configuration
public class RedisLockConfiguration {

    @Bean
    @Conditional(RedisLockCondition.class)
    public LockDelegate redisLockDelegate() {
        return new RedisLockDelegateImpl();
    }

    @Bean
    @Conditional(RedisLockCondition.class)
    public LockExecutor<RLock> redisLockExecutor() {
        return new RedisLockExecutorImpl();
    }

    @Bean
    @Conditional(RedisLockCondition.class)
    @ConditionalOnMissingBean(RedisHandler.class)
    public RedisHandler redisHandler() {
        return new RedisHandlerImpl();
    }

}