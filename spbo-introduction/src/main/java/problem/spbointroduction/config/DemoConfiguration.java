package problem.spbointroduction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用@Bean的方式注入bean
 * 1.在类上添加@Configuration注解，声明这个是一个spring 的配置类
 * 2.通过方法上添加@Bean注解，声明该方法创建一个Spring Bean
 */
@Configuration
public class DemoConfiguration {

    @Bean
    public Object createObject() {
        return new Object();
    }
}
