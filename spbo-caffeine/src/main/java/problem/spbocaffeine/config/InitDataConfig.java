package problem.spbocaffeine.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import problem.spbocaffeine.caffeinesimple.CacheData;
import problem.spbocaffeine.mapper.User;
import problem.spbocaffeine.mapper.UserMapper;

import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class InitDataConfig {

    private final UserMapper userMapper;

    @Bean
    public CacheData getCacheData() {
        return new CacheData();
    }

    @Bean
    public void initUserData() {
        CacheData cacheData = getCacheData();
        cacheData.init();
        cacheData.getUserdata().putAll(userMapper.selectList(null).stream().collect(Collectors.toMap(User::getId, Function.identity())));
    }
}
