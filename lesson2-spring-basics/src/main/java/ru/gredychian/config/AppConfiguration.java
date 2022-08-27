package ru.gredychian.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.gredychian.UserService;
import ru.gredychian.persist.UserRepository;
import ru.gredychian.persist.UserRepositoryImpl;

@Configuration
public class AppConfiguration {

   /* @Bean //создали здесь bean репозиторий
    public UserRepository userRepository() {
        return new UserRepositoryImpl();
    }

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository); //принимает и возвращает userRepository
    }*/

}
