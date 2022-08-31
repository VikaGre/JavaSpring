package ru.gredychian.HomeWork;

public interface ProductRepository {

    Product findProductById (Long id);

    void addProduct (Long id, Product product);

}
