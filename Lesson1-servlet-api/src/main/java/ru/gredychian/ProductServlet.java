package ru.gredychian;

import ru.gredychian.persist.ProductRepository;
import ru.gredychian.persist.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/product/*")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        this.productRepository = new ProductRepository();
        this.productRepository.insert(new Product("Apple", 50));
        this.productRepository.insert(new Product("Bread", 30));
        this.productRepository.insert(new Product("Milk", 80));
        this.productRepository.insert(new Product("Juice", 80));
        this.productRepository.insert(new Product("Water", 50));
        this.productRepository.insert(new Product("Chocolate", 100));
        this.productRepository.insert(new Product("Cookie", 100));
        this.productRepository.insert(new Product("Soap", 150));
        this.productRepository.insert(new Product("Salt", 90));
        this.productRepository.insert(new Product("Pepper", 90));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        if (req.getParameter("id") == null) {
            writer.println("<table>");
            writer.println("<tr>");
            writer.println("<th>id</th>");
            writer.println("<th>product</th>");
            writer.println("</tr>");
            for (Product product : productRepository.findAll()) {
                writer.println("<tr>");
                writer.println("<td>" + product.getId() + "/td");
                writer.println("<td>" + product.getTitle() + "/td");
                writer.println("<td>" + product.getCost() + "/td");
                writer.println("</tr>");
            }
            writer.println("</table>");
        } else {
            writer.println("<h1>About product<h1>");
            writer.println("<h3>Product: " + productRepository.findById(Long.parseLong(req.getParameter("id"))).getTitle() + "</h3>");
            writer.println("<h3>Cost: " + productRepository.findById(Long.parseLong(req.getParameter("id"))).getCost() + "</h3>");
        }
    }
}
