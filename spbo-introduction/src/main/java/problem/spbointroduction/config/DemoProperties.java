package problem.spbointroduction.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Data
@Configuration
@ConfigurationProperties(prefix = "young")
public class DemoProperties {

    private String port;

    private String name;

    private List<String> moneyLists;

    private Map<String, String> moneyMaps;

    private Map<String, List<String>> moneyListMaps;

}
