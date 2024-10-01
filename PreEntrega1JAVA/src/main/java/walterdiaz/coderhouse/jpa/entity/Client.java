package walterdiaz.coderhouse.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "CLIENT")
public class Client {

    public Client () {}

    public Client(String name, String lastname, int dni) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
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

    @Column (name = "LASTNAME")
    @Getter
    @Setter
    private String lastname;

    @Column (name = "DNI")
    @Getter
    @Setter
    private int dni;

    @OneToMany(mappedBy = "Client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Getter
    @Setter
    private List<Product> Products;

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }
}