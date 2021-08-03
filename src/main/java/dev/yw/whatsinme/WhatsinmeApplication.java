package dev.yw.whatsinme;

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
	public CommandLineRunner test(ItemRepository itemRepository) {

		return (args) -> {
			
			// bookmarkRepository.save(new Bookmark("Bing", "https://bing.com"));

			logger.info("sup");

			// for (Bookmark bookmark : bookmarkRepository.findAll()) {
			// 	logger.info(bookmark.toString());
			// }

			// for (Bookmark bookmark : bookmarkRepository.findByDescription("Google")) {
			// 	logger.info(bookmark.toString());
			// }

			// logger.info(bookmarkRepository.findById(3).toString());

		};

	}

}
