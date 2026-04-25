package com.allysoftsolutions.store.service;

import com.allysoftsolutions.store.exception.LowStockException;
import com.allysoftsolutions.store.model.Product;
import com.allysoftsolutions.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Page<Product> getProductsPaginated(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // spring-task1: Full business logic
    @Transactional
    public double placeOrder(Long productId, int quantity) {
        Product product = getProductById(productId);

        if (product.getStockQuantity() < quantity) {
            throw new LowStockException("Insufficient stock for product: " + product.getName());
        }

        double totalValue = quantity * product.getPrice();
        if (quantity > 5) {
            totalValue *= 0.9; // 10% discount
            System.out.println("[LOG] 10% discount applied for quantity > 5");
        }

        // Update stock atomically
        product.setStockQuantity(product.getStockQuantity() - quantity);
        productRepository.save(product);

        System.out.println("[LOG] Order placed. Updated stock: " + product.getStockQuantity());
        return totalValue;
    }

    // spring-task5: Stock update with redirect support
    @Transactional
    public void updateStock(Long id, int newStock) {
        Product product = getProductById(id);
        product.setStockQuantity(newStock);
        productRepository.save(product);
    }

    // spring-task3 methods exposed via service
    public List<Product> getLowStockProducts() {
        return productRepository.findByStockQuantityLessThan(10);
    }
}
