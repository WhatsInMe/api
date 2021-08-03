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
			
			itemRepository.save(new Item("Milk", 500, 14));
			itemRepository.save(new Item("Banana"));
			itemRepository.save(new Item("Cucumber"));
			itemRepository.save(new Item("Shiitake"));
			itemRepository.save(new Item("Yogurt"));

			for (Item item : itemRepository.findAll()) {
				logger.info(item.toString());
			}

			unitRepository.save(new Unit(
				itemRepository.findByName("Milk")
			));

			// Item item = itemRepository.findByName("Milk");
			// Unit unit00 = new Unit(LocalDate.now());
			// unit00.setItem(item);
			// item.getUnits().add(unit00);
			// itemRepository.save(item);

			// unit00.setItem(itemRepository.findByName("Milk"));
			// unitRepository.save(unit00);

			// Unit unit01 = new Unit(LocalDate.of(1990, 1, 1));
			// unit01.setItem(itemRepository.findByName("Milk"));
			// unitRepository.save(unit01);

			// for (Unit unit : unitRepository.findByItemId(1L)) {
			// 	// logger.info("ree");
			// 	logger.info(unit.toString());
			// }

			// logger.info(itemRepository.findById(1L).toString());
			// logger.info(itemRepository.findByName("Shiitake").toString());

		};

	}

}
