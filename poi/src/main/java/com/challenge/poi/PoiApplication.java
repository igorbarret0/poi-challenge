package com.challenge.poi;

import com.challenge.poi.entity.InterestPoint;
import com.challenge.poi.repository.InterestPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PoiApplication implements CommandLineRunner {

	@Autowired
	private InterestPointRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(PoiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new InterestPoint("Lanchonete", 27L, 12L));
		repository.save(new InterestPoint("Posto", 31L, 18L));
		repository.save(new InterestPoint("Joalheria", 15L, 12L));
		repository.save(new InterestPoint("Floricultura", 19L, 21L));
		repository.save(new InterestPoint("Pub", 12L, 8L));
		repository.save(new InterestPoint("Supermercado", 23L, 6L));
		repository.save(new InterestPoint("Churrascaria", 28L, 2L));

	}
}
