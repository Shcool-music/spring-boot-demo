package problem.spbocustomstarter.autoconfiguration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "young.money")
public class YoungMoneyProperties {

    private Integer port = 8848;

    private String name;

}
