package entities;

import java.util.UUID;

public class Book {
    public UUID id;
    public String title;
    public double price;

    public int units;

    public Book(String title, double price, int units){
        this.id = UUID.randomUUID();
        this.title = title;
        this.price = price;
        this.units = units;
    }
}
