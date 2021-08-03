package dev.yw.whatsinme;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WhatsinmeApplication {

	private static final Logger logger = LoggerFactory.getLogger(WhatsinmeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WhatsinmeApplication.class, args);
	}

	@Bean
	public CommandLineRunner test(
		ItemRepository itemRepository,
		UnitRepository unitRepository
	) {

		return (args) -> {
			
			itemRepository.save(new Item("Milk"));
			itemRepository.save(new Item("Banana"));
			itemRepository.save(new Item("Cucumber"));
			itemRepository.save(new Item("Shiitake"));
			itemRepository.save(new Item("Yogurt"));

			Unit unit = new Unit(LocalDate.now());
			unit.setItem(itemRepository.findByName("Milk"));
			unitRepository.save(unit);

			// for (Item item : itemRepository.findAll()) {
			// 	logger.info(item.toString());
			// }

			// logger.info(itemRepository.findById(1L).toString());
			// logger.info(itemRepository.findByName("Shiitake").toString());

		};

	}

}
