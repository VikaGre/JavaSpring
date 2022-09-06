package ru.gredychian.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gredychian.persist.User;
import ru.gredychian.persist.UserRepository;

@Controller
@RequestMapping("/user") //за какой end pont отвечает данный контроллер
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    //запрос, который перехватывает получение списка продуктов с помощью get
    @GetMapping //помечает метод, который перехватывает определённый тип http запрос
    public String listPage(Model model) {
        //модель - это такая коробка с объектами, мы можем в эту коробку
        //на backend что-то положить, а на frontend что-то с этой коробки достать
        //модель - это некоторая хэшмапа, где мы с помощью ключа
        //кладём туда новую запись и говорим, какому значению этот ключ соответствует

        model.addAttribute("users", userRepository.findAll()); //у нас есть новый клюс, который называется users
        return "user";

        //а значение этого ключа - userRepository.findAll(), то есть все пользователи
        //До тех пор, пока у нас не стоит аннотация @ResponseBody, которая говорит о том,
        //что мы возвращаем ответ как есть
    }

    @GetMapping("/{id}") //отрабатывает по другому пути, поэтому перехватываем "/id"
    public String form(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userRepository.findById(id));
        return "user_form";
    }

    @PostMapping
    public String saveUser(User user) {
        userRepository.save(user);
        return "redirect:/user";
    }
}
