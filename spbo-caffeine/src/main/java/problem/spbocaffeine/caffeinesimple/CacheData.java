package problem.spbocaffeine.caffeinesimple;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Expiry;
import com.github.benmanes.caffeine.cache.LoadingCache;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.index.qual.NonNegative;
import org.checkerframework.checker.nullness.qual.NonNull;
import problem.spbocaffeine.mapper.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class CacheData {

    private Cache<Long, User> userdata;

    public void init() {
//        userdata = Caffeine.newBuilder()
//                .expireAfterWrite(10, TimeUnit.MINUTES)
//                .build(id -> {
//                    log.info("initData");
//                    List<User> result = new ArrayList<>();
//                    result.add(User.builder().id(1L).age(1).name("local").build());
//                    return result;
//                });

        userdata = Caffeine.newBuilder()
                .expireAfter(new Expiry<Long, User>() {
                    @Override
                    public long expireAfterCreate(@NonNull Long key, @NonNull User value, long currentTime) {
                        log.info("expireAfterCreate");
                        return TimeUnit.MINUTES.toNanos(60);
                    }

                    @Override
                    public long expireAfterUpdate(@NonNull Long key, @NonNull User value, long currentTime, @NonNegative long currentDuration) {
                        log.info("expireAfterUpdate");
                        return TimeUnit.MINUTES.toNanos(30);
                    }

                    @Override
                    public long expireAfterRead(@NonNull Long key, @NonNull User value, long currentTime, @NonNegative long currentDuration) {
                        log.info("expireAfterRead");
                        return currentDuration;
                    }
                })
                .build();
    }


    public Cache<Long, User> getUserdata() {
        return userdata;
    }

    public void setUserdata(Cache<Long, User> userdata) {
        this.userdata = userdata;
    }
}
