package com.desigveloper.model;

import java.time.LocalDate;

public class Order {
    private final String orderId;
    private final String status;
    private final LocalDate date;
    private final double totalAmount;

    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.status = builder.status;
        this.date = builder.date;
        this.totalAmount = builder.totalAmount;
    }

    // Getters
    public String getOrderId() {
        return this.orderId;
    }

    public String getStatus() {
        return this.status;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public double getTotalAmount() {
        return this.totalAmount;
    }

    // static builder class
    public static class Builder {
        private String orderId;
        private String status;
        private LocalDate date;
        private double totalAmount;

        public Builder(String orderId, String status, LocalDate date) {
            this.orderId = orderId;
            this.status = status;
            this.date = date;
        }

        public Builder withTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
        
    }

    public void placeOrder(Product product) {

    }

    public void updateStatus() {

    }

    public double calculateTotalAmount() {
        return 0;
    }
    public void shipOrder() {

    }

     
    public void sortItems() {

    }

    public void storeItems() {

    }

    public void cancelOrder() {

    }
}

// class RushOrder extends Order {
//     public void handlePriority() {

//     }

//     public void calcShippingCharging() {

//     }
// }
