package problem.spbointroduction;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import problem.spbointroduction.config.DemoProperties;

@Slf4j
@SpringBootTest
public class YoungMoneyAllTest {

    @Autowired
    private DemoProperties demoProperties;

    @Test
    public void testProperties() {
        log.info(demoProperties.toString());
    }
}
