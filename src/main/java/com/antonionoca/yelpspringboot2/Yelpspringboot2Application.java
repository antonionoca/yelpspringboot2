package com.antonionoca.yelpspringboot2;

import com.antonionoca.yelpspringboot2.model.entity.Business;
import com.antonionoca.yelpspringboot2.model.repository.BusinessRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Arrays;

@SpringBootApplication
public class Yelpspringboot2Application {

	private static final Logger log = LoggerFactory.getLogger(Yelpspringboot2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Yelpspringboot2Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(BusinessRepository businessRepository) {
		return (args) -> {

			log.info("Inserting demo businesses");

			businessRepository.saveAll(Arrays.asList(
					new Business("b1"),
					new Business("b2"),
					new Business("b3"),
					new Business("b4")
					)
			);

			for (Business business :
					businessRepository.findAll()) {
				log.info("Business:" + business.getName());
			}

			log.info("Ready");
		};
	}
}
