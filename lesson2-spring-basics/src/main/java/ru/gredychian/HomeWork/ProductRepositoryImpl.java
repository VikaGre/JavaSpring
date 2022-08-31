package ru.gredychian.HomeWork;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final Map<Long, Product> productMap = new HashMap<>();

    @PostConstruct
    public void init() {
        addProduct(1L, new Product(1L, "Milk", 90));
        addProduct(2L, new Product(2L, "Bread", 40));
        addProduct(3L, new Product(3L, "Water", 50));
        addProduct(4L, new Product(4L, "Cookie", 100));
        addProduct(5L, new Product(5L, "Cheese", 70));
    }

    @Override
    public Product findProductById(Long id) {
        return productMap.get(id);
    }

    @Override
    public void addProduct(Long id, Product product) {
        productMap.put(id, product);
    }
}
