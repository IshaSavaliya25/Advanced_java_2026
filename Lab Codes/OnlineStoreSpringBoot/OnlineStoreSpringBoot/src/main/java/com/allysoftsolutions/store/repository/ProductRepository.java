package com.allysoftsolutions.store.repository;

import com.allysoftsolutions.store.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Derived methods (spring-task1)
    List<Product> findByCategory(String category);

    List<Product> findByNameContainingIgnoreCase(String name);

    // spring-task3: Low stock alert
    List<Product> findByStockQuantityLessThan(int quantity);

    // spring-task3: Custom @Query for category-wise total order value (simulated)
    @Query("SELECT p.category, SUM(oi.totalValue) FROM Product p JOIN p.orderItems oi GROUP BY p.category")
    List<Object[]> getTotalOrderValuePerCategory(); // Assume OrderItem relation if extended

    // Pagination + search
    Page<Product> findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(
            String name, String category, Pageable pageable);
}