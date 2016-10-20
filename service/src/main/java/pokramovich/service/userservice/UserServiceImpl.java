package pokramovich.service.userservice;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pokramovich.domain.pojo.User;
import pokramovich.service.repository.UserRepository;


import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * Created by Pokramovich on 21.09.2016.
 */

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository<User,Long> userRepository;

    @Autowired
    public UserServiceImpl(UserRepository<User, Long> userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();

    }

    @Override
    public void createTestInformation() {
        Random random=new Random();
        for(int i=0;i<10;i++){
            userRepository.save(new User.UserBuilder(RandomStringUtils.randomAlphabetic(20),
                    RandomStringUtils.randomAlphabetic(31),
                    RandomStringUtils.randomAlphabetic(47))
                    .build());
        }
    }

    @Override
    public CompletableFuture<List<User>> getAllAsync() {

        return  userRepository.findAllUser();
    }
}
