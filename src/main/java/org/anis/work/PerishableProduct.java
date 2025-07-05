package org.anis.work;

class PerishableProduct extends Product {
    private java.time.LocalDate expiryDate;

    public PerishableProduct(String name, double price, int quantity, java.time.LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return java.time.LocalDate.now().isAfter(expiryDate);
    }
}