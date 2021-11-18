package problem.spbologlogback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestLogController {

    @GetMapping("/info")
    public void infoLog() {
        log.info("it is info log");
    }


    @GetMapping("/debug")
    public void debugLog() {
        log.debug("it is debug log");
    }

    @GetMapping("/error")
    public void errorLog() {
        log.error("it is error log");
    }
}
