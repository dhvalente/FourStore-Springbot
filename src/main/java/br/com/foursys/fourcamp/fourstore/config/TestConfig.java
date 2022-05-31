package br.com.foursys.fourcamp.fourstore.config;

import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import br.com.foursys.fourcamp.fourstore.data.ClientData;
import br.com.foursys.fourcamp.fourstore.data.OrderData;
import br.com.foursys.fourcamp.fourstore.model.Client;
import br.com.foursys.fourcamp.fourstore.model.Order;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClientData clientData;
	
	@Autowired
	private OrderData orderData;

	@Override
	public void run(String... args) throws Exception {
		Client c1 = new Client(null, "Diogo Valente", "00055522277");
		Client c2 = new Client(null, "Jose Robson", "11144499965");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), c1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), c2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), c1); 

		clientData.saveAll(Arrays.asList(c1, c2));
		orderData.saveAll(Arrays.asList(o1, o2, o3));
	}

}
