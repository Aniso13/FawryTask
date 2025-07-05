package org.anis.work;

import java.util.*;

class ShippingService {
    public static void ship(List<Shippable> items) {
        if (items.isEmpty()) return;

        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        Map<String, Integer> grouped = new HashMap<>();

        for (Shippable item : items) {
            grouped.put(item.getName(), grouped.getOrDefault(item.getName(), 0) + 1);
            totalWeight += item.getWeight();
        }

        grouped.forEach((name, count) -> System.out.println(count + "x " + name));
        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}