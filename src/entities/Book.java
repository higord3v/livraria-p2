package entities;

import java.util.UUID;

public class Book {
    public UUID id;
    public String title;
    public double price;

    public int units;
    public int selledUnits;

    public Book(String title, double price, int units){
        this.id = UUID.randomUUID();
        this.title = title;
        this.price = price;
        this.units = units;
        this.selledUnits = 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", units=" + units +
                '}';
    }
}
