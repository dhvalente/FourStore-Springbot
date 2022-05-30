package br.com.foursys.fourcamp.fourstore.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import br.com.foursys.fourcamp.fourstore.data.ClienteData;
import br.com.foursys.fourcamp.fourstore.model.Client;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClienteData clientData;

	@Override
	public void run(String... args) throws Exception {
		Client c1 = new Client(null, "Diogo Valente", "00055522277");
		Client c2 = new Client(null, "Jose Robson", "11144499965");

		clientData.saveAll(Arrays.asList(c1, c2));
	}

}
