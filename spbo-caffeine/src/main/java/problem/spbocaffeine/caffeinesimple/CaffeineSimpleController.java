package problem.spbocaffeine.caffeinesimple;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CaffeineSimpleController {

    private final CacheData cacheData;


    @GetMapping("/test1/{id}")
    public Object simpleCaffeine(@PathVariable Long id) {
//        LoadingCache<Long, List<User>> cache;
//        log.info("1:data:{}", cacheData.getUserdata().get(1L));
//        cache = Caffeine.newBuilder()
//                .expireAfterWrite(5, TimeUnit.MINUTES)
//                .build(id -> {
//                    log.info("initData2");
//                    List<User> result = new ArrayList<>();
//                    result.add(User.builder().id(1L).age(1).name("data2").build());
//                    return result;
//                });
//        cacheData.setUserdata(cache);
//        log.info("2:data:{}", cacheData.getUserdata().get(1L));
        return cacheData.getUserdata().asMap().get(id);
    }


}
