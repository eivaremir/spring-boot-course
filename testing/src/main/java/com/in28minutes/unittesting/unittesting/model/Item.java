package com.in28minutes.unittesting.unittesting.model;

public class Item {

    private final int id;
    private final String name;
    private final int price;
    private final int qty;

    public Item(int i, String name, int price, int qty) {
        this.id=i;
        this.name=name;
        this.price=price;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }
}
