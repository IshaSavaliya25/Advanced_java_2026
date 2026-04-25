package com.allysoftsolutions.store;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@WebFilter("/placeOrder")
public class StockCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        int productId = Integer.parseInt(req.getParameter("productId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        ServletContext context = req.getServletContext();
        List<Product> inventory = (List<Product>) context.getAttribute("inventory");

        boolean sufficient = false;

        for (Product p : inventory) {
            if (p.getId() == productId && p.getStockQuantity() >= quantity) {
                sufficient = true;
                break;
            }
        }

        if (!sufficient) {
            System.out.println("[FILTER] Blocked");
            req.setAttribute("error", "Stock not available");
            req.getRequestDispatcher("lowStockError.jsp").forward(request, response);
            return;
        }

        System.out.println("[FILTER] Passed");
        chain.doFilter(request, response);
    }
}