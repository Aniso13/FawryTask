package org.anis.work;

public class Main {
    public static void main(String[] args) {
        Product cheese = new PerishableShippableProduct("Cheese", 100, 5, java.time.LocalDate.now().plusDays(2), 0.2);
        Product biscuits = new PerishableShippableProduct("Biscuits", 150, 3, java.time.LocalDate.now().plusDays(5), 0.7);
        Product tv = new ShippableProduct("TV", 3000, 2, 7.0);
        Product scratchCard = new Product("Scratch Card", 50, 10) {};

        Customer customer = new Customer("Ali", 1000);
        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);
        CheckoutService.checkout(customer, cart);
    }
}