package models;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cart {
    ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<Item>();
    }

    public Item getItem(int index) {
        return new Item(items.get(index));
    }

    public void setItem(int index, Item item) {
        items.set(index, new Item(item));
    }

    /**
     * Name: add
     *
     * @param item
     * @return boolean
     * <p>
     * Inside the function:
     * 1. Adds an item to the cart if it wasn't already added.
     */
    public boolean add(Item item) {
        if (items.contains(item)) {
            return false;
        }
        return items.add(new Item(item));
    }

    public boolean contains(Item item) {
        return items.contains(item);
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public double getSubtotal() {
        return items.stream().mapToDouble((item) -> item.getPrice()).sum();

    }

    public double getTax(double subtotal) {
        return subtotal * 0.13;
    }

    public double getTotal(double subtotal, double tax) {
        return subtotal + tax;
    }
public void clear(){
    items.clear();
}
    /**
     * Name: remove
     *
     * @param name Inside the function:
     *             1. Removes the item that matches the name passed in.
     */
    public void remove(String name) {
        if (items.isEmpty()) throw new IllegalStateException("INVALID STATE");
        items.removeIf((item) -> item.getName().equals(name));

    }

    /**
     * Name: checkout
     *
     * @return (String)
     * <p>
     * Inside the function:
     * 1. Calculates the subtotal (price before tax).
     * 2. Calculates the tax (assume tax is 13%).
     * 3. Calculates total: subtotal + tax
     * 4. Returns a String that resembles a receipt. See below.
     */
    public String checkout() {
        if (items.isEmpty()) throw new IllegalStateException("The list is empty");
        return "\tRECEIPT\n\n" +
                "\tSubtotal: $" + getSubtotal() + "\n" +
                "\tTax: $" + String.format("%.2f", getTax(getSubtotal())) + "\n" +
                "\tTotal: $" + String.format("%.2f", getTotal(getSubtotal(), getTax(getSubtotal()))) + "\n";
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < items.size(); i++) {
            temp += items.get(i).toString();
            temp += "\n";
        }
        return temp;
    }
}