package ru.gredychian;

import ru.gredychian.persist.Product;
import ru.gredychian.persist.ProductRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BootstrapListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductRepository productRepository = new ProductRepository();
        productRepository.insert(new Product("Apple", 50));
        productRepository.insert(new Product("Bread", 30));
        productRepository.insert(new Product("Milk", 80));

        sce.getServletContext().setAttribute("productRepository", productRepository);
    }
}
