package com.allysoftsolutions.store.controller;

import com.allysoftsolutions.store.dto.OrderRequest;
import com.allysoftsolutions.store.model.Product;
import com.allysoftsolutions.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
 * spring-task2: REST Controller with pageable, @Valid, ResponseEntity
 */
@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Page<Product>> getAllProducts(Pageable pageable) {
        return ResponseEntity.ok(productService.getProductsPaginated(pageable));
    }

    @PostMapping("/order")
    public ResponseEntity<Double> placeOrder(@Valid @RequestBody OrderRequest request) {
        double total = productService.placeOrder(request.getProductId(), request.getQuantity());
        return ResponseEntity.ok(total);
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<Product> updateStock(@PathVariable Long id, @RequestParam int stock) {
        productService.updateStock(id, stock);
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        // Implement delete if needed
        return ResponseEntity.noContent().build();
    }

    // spring-task3 exposed via REST
    @GetMapping("/low-stock")
    public ResponseEntity<List<Product>> getLowStock() {
        return ResponseEntity.ok(productService.getLowStockProducts());
    }
}