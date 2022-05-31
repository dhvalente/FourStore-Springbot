package br.com.foursys.fourcamp.fourstore.config;

import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.foursys.fourcamp.fourstore.data.CategoryData;
import br.com.foursys.fourcamp.fourstore.data.ClientData;
import br.com.foursys.fourcamp.fourstore.data.OrdemItemData;
import br.com.foursys.fourcamp.fourstore.data.OrderData;
import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.enums.OrderStatus;
import br.com.foursys.fourcamp.fourstore.model.Category;
import br.com.foursys.fourcamp.fourstore.model.Client;
import br.com.foursys.fourcamp.fourstore.model.Order;
import br.com.foursys.fourcamp.fourstore.model.OrderItem;
import br.com.foursys.fourcamp.fourstore.model.Product;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClientData clientData;
	
	@Autowired
	private CategoryData categoryData;
	
	@Autowired
	private OrderData orderData;
	
	@Autowired
	private ProductData productData;
	
	@Autowired
	private OrdemItemData ordemItemData;
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 		
	
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 

		categoryData.saveAll(Arrays.asList(cat1 , cat2, cat3));
		productData.saveAll(Arrays.asList(p1 , p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productData.saveAll(Arrays.asList(p1 , p2, p3, p4, p5));
		
		Client c1 = new Client(null, "Diogo Valente", "00055522277");
		Client c2 = new Client(null, "Jose Robson", "11144499965");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, c1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, c2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, c1); 

		clientData.saveAll(Arrays.asList(c1, c2));
		orderData.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		ordemItemData.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
	}

}
