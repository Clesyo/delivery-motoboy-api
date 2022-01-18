package br.com.motoboy.delivery;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.motoboy.delivery.seeders.DefaultSeeder;

@SpringBootApplication
public class DelivaeryMotoboyApiApplication {
	
	@Autowired
	private DeliveryMotoboyApiContext context;
	
	@Autowired
	private DefaultSeeder seeder;

	public static void main(String[] args) {
		SpringApplication.run(DelivaeryMotoboyApiApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		context.load();
		seeder.seedProfiles();
		seeder.seedUser();
	}

}
