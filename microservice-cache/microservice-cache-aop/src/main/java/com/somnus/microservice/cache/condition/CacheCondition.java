package com.somnus.microservice.cache.condition;

import com.somnus.microservice.autoconfigure.proxy.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.lang.NonNull;

/**
 * @author Kevin
 * @date 2019/6/14 16:43
 */
@AllArgsConstructor
public class CacheCondition implements Condition {

    private final String key;

    private final String value;

    @Override
    public boolean matches(ConditionContext context, @NonNull AnnotatedTypeMetadata metadata) {
        String beanName = context.getEnvironment().getProperty(key);

        return Objects.equals(beanName, value);
    }
}