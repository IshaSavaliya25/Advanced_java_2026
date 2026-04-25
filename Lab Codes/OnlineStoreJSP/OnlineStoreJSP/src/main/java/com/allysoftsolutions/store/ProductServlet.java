package com.allysoftsolutions.store;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/placeOrder")
public class ProductServlet extends HttpServlet {

    private static List<ProductBean> inventory = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        inventory.add(new ProductBean(1, "Laptop", "Electronics", 50000, 20, "Dell"));
        inventory.add(new ProductBean(2, "Mouse", "Electronics", 500, 8, "Logitech"));
        inventory.add(new ProductBean(3, "Keyboard", "Electronics", 1200, 15, "HP"));

        getServletContext().setAttribute("inventory", inventory);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int productId = 0;
        int quantity = 0;

        try {
            productId = Integer.parseInt(req.getParameter("productId"));
            quantity = Integer.parseInt(req.getParameter("quantity"));
        } catch (Exception e) {
            req.setAttribute("error", "Invalid input");
            req.getRequestDispatcher("lowStockError.jsp").forward(req, resp);
            return;
        }

        if (quantity <= 0) {
            req.setAttribute("error", "Quantity must be greater than 0");
            req.getRequestDispatcher("lowStockError.jsp").forward(req, resp);
            return;
        }

        ProductBean selected = null;

        for (ProductBean p : inventory) {
            if (p.getId() == productId) {
                selected = p;
                break;
            }
        }

        if (selected == null) {
            req.setAttribute("error", "Product not found");
            req.getRequestDispatcher("lowStockError.jsp").forward(req, resp);
            return;
        }

        if (selected.getStockQuantity() < quantity) {
            req.setAttribute("error", "Insufficient stock");
            req.getRequestDispatcher("lowStockError.jsp").forward(req, resp);
            return;
        }

        double total = selected.calculateDiscountedTotal(quantity);

        // Update stock
        selected.setStockQuantity(selected.getStockQuantity() - quantity);

        // Session cart
        HttpSession session = req.getSession();
        List<OrderItem> cart = (List<OrderItem>) session.getAttribute("cart");

        if (cart == null) cart = new ArrayList<>();

        cart.add(new OrderItem(selected, quantity, total));
        session.setAttribute("cart", cart);

        // Global sales
        ServletContext context = getServletContext();
        Double globalSales = (Double) context.getAttribute("globalSales");
        if (globalSales == null) globalSales = 0.0;

        globalSales += total;
        context.setAttribute("globalSales", globalSales);

        req.setAttribute("product", selected);
        req.setAttribute("quantity", quantity);
        req.setAttribute("totalValue", total);
        req.setAttribute("message", "Order placed successfully");

        req.getRequestDispatcher("orderConfirmation.jsp").forward(req, resp);
    }

    public static class OrderItem {
        ProductBean product;
        int quantity;
        double totalValue;

        public OrderItem(ProductBean p, int q, double t) {
            this.product = p;
            this.quantity = q;
            this.totalValue = t;
        }

        public ProductBean getProduct() { return product; }
        public int getQuantity() { return quantity; }
        public double getTotalValue() { return totalValue; }
    }
}