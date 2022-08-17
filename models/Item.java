package models;

public class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Invalid name");
        if(price < 0) throw new IllegalArgumentException("Price can't be < 0");
        this.name = name;
        this.price = price;
    }

    public Item(Item source) {
        name = source.name;
        price = source.price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()) throw new IllegalArgumentException("Invalid name");
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price can't be < 0");
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ": $" + price + " ";
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if (!(obj instanceof Item item)) return false;
        return this.name.equals(item.name) && price== item.price;
    }
}
