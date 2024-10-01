package walterdiaz.coderhouse.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import walterdiaz.coderhouse.jpa.entity.Client;
import walterdiaz.coderhouse.jpa.entity.Product;
import walterdiaz.coderhouse.jpa.service.DaoFactory;

import java.util.ArrayList;
import java.util.List;

import static walterdiaz.coderhouse.jpa.entity.Product.*;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	@Autowired
	public DaoFactory daoFactory;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			// Se crean un clientes
			Client client = new Client( "Juan", "Perez", 12345678);

			// Se crean productos
			Product product = new Product("Yerba", 5000, 3);

			product.setClient(client);

			List<Product> productos = new ArrayList<Product>();
			productos.add(product);

			client.setProducts(productos);

			// Crear cliente con domicilios
			daoFactory.create(client);

			// Buscar cliente guardado
			Client clientGuardado = daoFactory.getClient(client);

			System.out.println(clientGuardado.toString());

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
