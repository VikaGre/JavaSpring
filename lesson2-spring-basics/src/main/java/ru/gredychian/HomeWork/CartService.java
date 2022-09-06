package ru.gredychian.HomeWork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class CartService {

    private final Cart cart;
    private final ProductRepository productRepository;

    @Autowired
    public CartService(Cart cart, ProductRepository productRepository) {
        this.cart = cart;
        this.productRepository = productRepository;
    }

    public void addProduct(Long id) {
        Product product = productRepository.findProductById(id);
        cart.add(product);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findProductById(id);
        cart.delete(product);
    }

    public List<Product> getProducts() {
        return cart.getAllProduct();
    }
}
