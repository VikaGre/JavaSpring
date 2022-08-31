package ru.gredychian.HomeWork;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gredychian.config.AppConfiguration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        System.out.println("You have some commands: \nnew cart - create new cart \n" +
                "add - add product by id \ndelete - delete product by id \n" +
                "show - show all products in the cart \nexit - close console");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        CartService cartService = null;

        while (true) {
            System.out.print("Enter command: ");

            String command = scanner.next().toLowerCase().trim();
            System.out.println();

            switch (command) {
                case "new": {
                    cartService = context.getBean(CartService.class);
                    break;
                }
                case "add": {
                    if (cartService == null) {
                        System.out.println("First, you need to create a cart");
                        break;
                    }
                    System.out.print("Enter product's id: ");
                    long id = scanner.nextLong();
                    cartService.addProduct(id);
                    System.out.println();
                    break;
                }
                case "delete": {
                    if (cartService == null) {
                        System.out.println("First, you need to create a cart");
                        break;
                    }
                    System.out.print("Enter product's id: ");
                    long id = scanner.nextLong();
                    cartService.deleteProduct(id);
                    System.out.println();
                    break;
                }
                case "show": {
                    if (cartService == null) {
                        System.out.println("First, you need to create a cart");
                        break;
                    }
                    cartService.getProducts().forEach(System.out::println);
                    break;
                }
                case "exit": {
                    return;
                }
            }
        }
    }
}
