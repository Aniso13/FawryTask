package org.anis.work;

class PerishableShippableProduct extends PerishableProduct implements Shippable {
    private double weight;

    public PerishableShippableProduct(String name, double price, int quantity, java.time.LocalDate expiryDate, double weight) {
        super(name, price, quantity, expiryDate);
        this.weight = weight;
    }

    @Override
    public boolean isShippable() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}