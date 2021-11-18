package problem.spbocustomstarter.autoconfiguration;

import com.sun.net.httpserver.HttpServer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.InetSocketAddress;


@Slf4j
@Data
@Configuration
@EnableConfigurationProperties(YoungMoneyProperties.class)
public class YoungMoneyConfiguration {

    @Bean // 声明创建 Bean
    @ConditionalOnClass(HttpServer.class) // 需要项目中存在 com.sun.net.httpserver.HttpServer 类。该类为 JDK 自带，所以一定成立。
    public HttpServer httpServer(YoungMoneyProperties youngMoneyProperties) throws IOException {
        // 创建 HttpServer 对象，并启动
        HttpServer server = HttpServer.create(new InetSocketAddress(youngMoneyProperties.getPort()), 0);
        server.start();
        log.info("[httpServer][启动服务器成功，端口为:{}]", youngMoneyProperties.getPort());
        // 返回
        return server;
    }
}
