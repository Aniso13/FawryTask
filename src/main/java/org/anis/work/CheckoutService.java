package org.anis.work;

import java.util.*;

class CheckoutService {
    private static final double SHIPPING_FEE_PER_ITEM = 10;

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        List<CartItem> items = cart.getItems();
        List<Shippable> toShip = new ArrayList<>();
        double subtotal = 0;
        double shipping = 0;

        for (CartItem item : items) {
            Product product = item.product;
            if (item.quantity > product.getQuantity()) {
                System.out.println("Error: " + product.getName() + " is out of stock.");
                return;
            }
            if (product.isExpired()) {
                System.out.println("Error: " + product.getName() + " is expired.");
                return;
            }

            subtotal += item.getTotalPrice();
            if (product.isShippable()) {
                for (int i = 0; i < item.quantity; i++) {
                    toShip.add((Shippable) product);
                }
                shipping += SHIPPING_FEE_PER_ITEM * item.quantity;
            }
        }

        double total = subtotal + shipping;

        if (customer.getBalance() < total) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        for (CartItem item : items) {
            item.product.reduceQuantity(item.quantity);
        }

        customer.deduct(total);
        ShippingService.ship(toShip);

        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            System.out.println(item.quantity + "x " + item.product.getName() + " " + item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + (int) subtotal);
        System.out.println("Shipping " + (int) shipping);
        System.out.println("Amount " + (int) total);
        System.out.println("Customer balance: " + customer.getBalance());
    }
}