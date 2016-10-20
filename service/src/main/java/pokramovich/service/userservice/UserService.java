package pokramovich.service.userservice;

import org.springframework.cache.annotation.Cacheable;
import pokramovich.domain.pojo.User;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by Pokramovich on 21.09.2016.
 */
public interface UserService {
    List<User> getAll();

    void createTestInformation();

    @Cacheable(value = "user")
    CompletableFuture<List<User>> getAllAsync();

}
