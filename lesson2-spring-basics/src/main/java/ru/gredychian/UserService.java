package ru.gredychian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gredychian.persist.User;
import ru.gredychian.persist.UserRepository;
import ru.gredychian.persist.UserRepositoryImpl;

import javax.annotation.PostConstruct;


@Service //контролируется спрингом
//обработка ввода пользователя
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void ini() {// дополнительный метод, который вызывается после создания bean
        System.out.println("Method PostConstruct worked out.");

    }

    public void insert(User user) {
        if(user.getRole().equals("ADMIN") || user.getRole().equals("GUEST")) {
            this.userRepository.insert(user); //добавляем этого пользователя
        } else { //иначе кидаем исключение, что пришли неправильные аргументы
            throw new IllegalArgumentException("Incorrect role.");
        }
    }

    public int findAll() {
        return this.userRepository.findAll().size();
    }

}
