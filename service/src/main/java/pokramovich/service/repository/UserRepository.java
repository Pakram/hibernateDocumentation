package pokramovich.service.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import pokramovich.domain.pojo.User;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by Pokramovich on 21.09.2016.
 */
public interface UserRepository<T,ID> extends CrudRepository<User,Long> {
    @Async
    @Query("SELECT t FROM User t")
    CompletableFuture<List<User>> findAllUser();

}
