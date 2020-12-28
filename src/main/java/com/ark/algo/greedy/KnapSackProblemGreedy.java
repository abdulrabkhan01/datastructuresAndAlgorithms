package com.ark.algo.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Given n number of items i1, i2......in, with weights w1, w2,....wn and
 * cost from c1,c2,......cn, and given a bag of capacity K, select items
 * in a such a manner that the profit must be optimized, here partial amounts
 * can be taken from a given item.
 */
public class KnapSackProblemGreedy {

    private static List<Item> getSelectedItems(List<Item> items, int bagCapacity) {
        List<Item> selectedItems = new ArrayList<>(items.size());
        //Sort each item based on size density in descending order
        // Size density = cost/quantity
        items.sort(Comparator.comparing(Item::getDensity).reversed());
        int runningCapacity = bagCapacity;
        for (Item item : items) {
            runningCapacity = runningCapacity - item.getQuantity();
            if (runningCapacity >= 0) {
                selectedItems.add(item);
            }
        }
        return selectedItems;
    }

    public static void main(String[] args) {
        List<Item> items = populateItems();
        int bagCapacity = 3; //only 3 items can be stored.
        List<Item> selectedItems = getSelectedItems(items, bagCapacity);
        System.out.println("Selected items " + selectedItems);
        double sum = selectedItems.stream().mapToDouble(Item::getCost).sum();
        System.out.println("Total Cost Selected " + sum);
    }


    private static List<Item> populateItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Apple", 10, 100.0));
        items.add(new Item("Mango", 1, 1000.0));
        items.add(new Item("Water Mellon", 2, 500.0));
        return items;
    }
}

class Item {
    private final String name;
    private final int quantity;
    //Total cost for given quantity
    private final double cost;

    public Item(String name, int quantity, double cost) {
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", cost=" + cost +
                '}';
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCost() {
        return cost;
    }

    public double getDensity() {
        return cost / quantity;
    }
}
