package com.allysoftsolutions.store.controller;

import com.allysoftsolutions.store.dto.OrderRequest;
import com.allysoftsolutions.store.model.Product;
import com.allysoftsolutions.store.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * spring-task1: Main MVC Controller with Thymeleaf
 * spring-task4: Uses fragments, Bootstrap, dynamic discount display
 * spring-task5: @ModelAttribute, redirect, flash attributes
 */
@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String home() {
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String getProductList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "") String search,
            Model model) {

        var pageable = PageRequest.of(page, 10);
        var productPage = productService.getProductsPaginated(pageable); // extend with search if needed

        model.addAttribute("products", productPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("search", search);
        return "product-list"; // spring-task1, spring-task4
    }

    @GetMapping("/order/{id}")
    public String showOrderForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("orderRequest", new OrderRequest());
        return "order-form";
    }

    @PostMapping("/placeOrder")
    public String placeOrder(@Valid @ModelAttribute OrderRequest orderRequest,
            BindingResult result,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "order-form";
        }

        try {
            double total = productService.placeOrder(orderRequest.getProductId(), orderRequest.getQuantity());
            redirectAttributes.addFlashAttribute("message", "Order placed successfully!");
            redirectAttributes.addFlashAttribute("totalValue", total);
            return "redirect:/order-confirmation";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/products";
        }
    }

    @GetMapping("/order-confirmation")
    public String orderConfirmation() {
        return "order-confirmation";
    }
}
