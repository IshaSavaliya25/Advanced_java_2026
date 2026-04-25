package com.allysoftsolutions.store;

/**
 * ProductBean (POJO)
 * Used for business logic (discount calculation)
 */
public class ProductBean {

    private int id;
    private String name;
    private String category;
    private double price;
    private int stockQuantity;
    private String supplier;

    // Default constructor (MANDATORY for Bean)
    public ProductBean() {}

    // Parameterized constructor
    public ProductBean(int id, String name, String category, double price, int stockQuantity, String supplier) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.supplier = supplier;
    }

    // ✅ Business Method (IMPORTANT for viva)
    public double calculateDiscountedTotal(int quantity) {
        double total = quantity * price;

        if (quantity > 5) {
            total = total * 0.9; // 10% discount
            System.out.println("[BEAN LOG] 10% discount applied");
        }

        return total;
    }

    // Getters & Setters (MANDATORY for Bean)

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier; }
}