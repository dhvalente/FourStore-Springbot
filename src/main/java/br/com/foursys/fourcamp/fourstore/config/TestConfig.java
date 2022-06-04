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
import br.com.foursys.fourcamp.fourstore.data.SeasonData;
import br.com.foursys.fourcamp.fourstore.data.SizeData;
import br.com.foursys.fourcamp.fourstore.data.StockData;
import br.com.foursys.fourcamp.fourstore.enums.OrderStatus;
import br.com.foursys.fourcamp.fourstore.model.Address;
import br.com.foursys.fourcamp.fourstore.model.Category;
import br.com.foursys.fourcamp.fourstore.model.Client;
import br.com.foursys.fourcamp.fourstore.model.Order;
import br.com.foursys.fourcamp.fourstore.model.OrderItem;
import br.com.foursys.fourcamp.fourstore.model.Payment;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Season;
import br.com.foursys.fourcamp.fourstore.model.Size;
import br.com.foursys.fourcamp.fourstore.model.Stock;


@Configuration

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
	@Autowired
	private SeasonData seasonData;
	
	@Autowired
	private SizeData sizeData;
	
	@Autowired
	private StockData stockData;	
	@Override
	public void run(String... args) throws Exception {
		
		//Salvando as cores
		Category cat1 = new Category(null, "Azul");
		Category cat2 = new Category(null, "Amarelo");
		Category cat3 = new Category(null, "Branco");
		Category cat4 = new Category(null, "Laranja"); 
		Category cat5 = new Category(null, "Preto"); 
		categoryData.saveAll(Arrays.asList(cat1 , cat2, cat3, cat4, cat5));
		
		//Salvando as estações
		Season s1 = new Season(null, "Verão");
		Season s2 = new Season(null, "Inverno");
		Season s3 = new Season(null, "Primavera");
		Season s4 = new Season(null, "Outono");		
		seasonData.saveAll(Arrays.asList(s1, s2, s3, s4));
		
		//Salvando os tamanhos
		Size t1 = new Size(null, "RN");
		Size t2 = new Size(null, "PP");
		Size t3 = new Size(null, "P");
		Size t4 = new Size(null, "M");
		Size t5 = new Size(null, "G");	
		Size t6 = new Size(null, "GG");	
		Size t7 = new Size(null, "XG");	
		sizeData.saveAll(Arrays.asList(t1, t2, t3, t4, t5, t6, t7));
		
		//Salvando os produtos
		Product p6 = new Product(null, "Regata Macho Alfa", s4, t7, 15.00, 35.00);
		Product p1 = new Product(null, "Camiseta Vermelha Manga Curta GG",s1, t1, 20.00, 65.00);
		Product p2 = new Product(null, "Vestido Amarelo XG",s2, t2, 35.00, 110.00);
		Product p3 = new Product(null, "Bermuda Preta G2",s2,t3 , 25.00, 45.00);
		Product p4 = new Product(null, "Alguma Coisa Cinza", s3, t4, 10.00, 35.00);
		Product p5 = new Product(null, "Camiseta Ceral Radical",s4, t6, 55.00, 70.00);
		seasonData.saveAll(Arrays.asList(s1, s2, s3, s4));
		productData.saveAll(Arrays.asList(p1 , p2, p3, p4, p5));

		//Salvando o estoque	
		Stock sp1 = new Stock(null, p1, 42);
		Stock sp5 = new Stock(null, p5, 10);
		Stock sp2 = new Stock(null, p2, 32);
		Stock sp4 = new Stock(null, p4, 53);
		Stock sp3 = new Stock(null, p3, 27);

	
		stockData.saveAll(Arrays.asList(sp1,sp2,sp3,sp4,sp5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);		
		productData.saveAll(Arrays.asList(p1 , p2, p3, p4, p5));
		

		
		Client c1 = new Client(null, "Diogo Valente", "00055522277");
		Client c2 = new Client(null, "Jose Robson", "11144499965");
		Address a1 = new Address("Rua carochinha", "1111", "Marialva", "Jardim Itabera", "PR", "87145555",c1);
		Address a2 = new Address("Rua Aristides Bonifácio", "444", "Marialva", "Centro", "PR", "86990000",c2);		
		c1.setAdress(a1);
		c2.setAdress(a2);
		clientData.save(c1);
		clientData.save(c2);
		

		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, c1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, c2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, c1); 

		clientData.saveAll(Arrays.asList(c1, c2));
		orderData.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getSellPrice()); //erro ta partir daaqui
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getSellPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getSellPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getSellPrice()); 
		
		ordemItemData.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		orderData.save(o1);
	}

}
