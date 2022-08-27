package ru.gredychian;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.gredychian.config.AppConfiguration;
import ru.gredychian.persist.User;
import ru.gredychian.persist.UserRepositoryImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(/*AppConfiguration.class*/);
        UserService userService = context.getBean("userService", UserService.class);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter user name: ");
            String userName = scanner.nextLine();

            System.out.println("Enter user role: ");
            String role = scanner.nextLine();

            userService.insert(new User(userName, role)); //создвём объект, туда кладём им пользователя

            System.out.println("New user has been added. Current users count: " + userService.findAll());

            System.out.println("Enter \"end\" to exit");
            if (scanner.nextLine().equals("end")) {
                return; //выход из цикла
            }
        }
    }
}
