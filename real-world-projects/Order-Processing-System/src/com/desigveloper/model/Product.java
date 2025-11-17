package com.desigveloper.model;

public class Product {
    private final String productId;
    private final String name;
    private final double price;
    private final int stockQuantity;

    private Product(Builder builder) {
        this.productId = builder.productId;
        this.name = builder.name;
        this.price = builder.price;
        this.stockQuantity = builder.stockQuantity;
    }

    // Getters
    public String getProductId() {
        return this.productId;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getStockQuantity() {
        return this.stockQuantity;
    }

    // Static builder class
    public static class Builder {
        private String productId;
        private String name;
        private double price;
        private int stockQuantity;

        public Builder(String productId, String name, double price) {
            this.productId = productId;
            this.name = name;
            this.price = price;
        }

        public Builder withStockQuantity(int stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
        
    }

    public void addNewItem() {

    }

     
    public void sortItems() {

    }

    public void removeItem() {

    }
}
