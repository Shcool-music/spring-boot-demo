package problem.spbocaffeine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("problem.spbocaffeine.mapper")
public class SpboCaffeineApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpboCaffeineApplication.class, args);
    }

}
