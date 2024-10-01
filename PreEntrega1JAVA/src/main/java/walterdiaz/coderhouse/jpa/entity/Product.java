package walterdiaz.coderhouse.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUCT")
public class Product {

    public Product () {}

    public Product(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int Id;

    @Column (name = "NAME")
    @Getter
    @Setter
    private String name;

    @Column (name = "PRICE")
    @Getter
    @Setter
    private int price;

    @Column (name = "AMOUNT")
    @Getter
    @Setter
    private int amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    private Client Client;

    public Product(walterdiaz.coderhouse.jpa.entity.Client client) {
        Client = client;
    }
}