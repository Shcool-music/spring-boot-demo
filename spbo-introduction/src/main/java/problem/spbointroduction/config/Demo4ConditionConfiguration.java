package problem.spbointroduction.config;

import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ConditionalOnBean：当容器里有指定 Bean 的条件下
 * @ConditionalOnMissingBean：当容器里没有指定 Bean 的情况下
 * @ConditionalOnSingleCandidate：当指定 Bean 在容器中只有一个，或者虽然有多个但是指定首选 Bean
 * @ConditionalOnClass：当类路径下有指定类的条件下
 * @ConditionalOnMissingClass：当类路径下没有指定类的条件下
 * @ConditionalOnProperty：指定的属性是否有指定的值
 * @ConditionalOnResource：类路径是否有指定的值
 * @ConditionalOnExpression：基于 SpEL 表达式作为判断条件
 * @ConditionalOnJava：基于 Java 版本作为判断条件
 * @ConditionalOnJndi：在 JNDI 存在的条件下差在指定的位置
 * @ConditionalOnNotWebApplication：当前项目不是 Web 项目的条件下
 * @ConditionalOnWebApplication：当前项目是 Web项 目的条件下
 */
@Configuration
public class Demo4ConditionConfiguration {

    /**
     * 开发环境 才加载
     *
     * @return
     */
    @Bean
    @Profile("dev")
    public Object devObject() {
        return new Object();
    }

    /**
     * 生成环境 才加载
     *
     * @return
     */
    @Bean
    @Profile("PROD")
    public Object prodObject() {
        return new Object();
    }

    /**
     * 满足条件才可以创建这个bean
     *
     * @return
     */
    @Bean
    @Conditional(ConditionClass.class)
    public Object conditionObject() {
        return new Object();
    }

    public static class ConditionClass implements Condition {

        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return false;
        }
    }
}


