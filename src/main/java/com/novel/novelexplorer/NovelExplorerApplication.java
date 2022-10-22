package com.novel.novelexplorer;

import com.novel.novelexplorer.entities.Novel;
import com.novel.novelexplorer.repositories.NovelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Slf4j
public class NovelExplorerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NovelExplorerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(NovelRepository repository) {
		return (args) -> {
			Novel novel = Novel.builder()
					.title("COOOOOL")
					.chapterCount(42)
					.coverImage(null)
					.linkNovelChapters("")
					.linkNovelOverview("")
					.rating(5)
					.releaseDate(null)
					.viewsTotal(100)
					.viewsLastMonth(1000)
					.build();

			// save a few customers
			repository.save(novel);

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Novel customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");
		};
	}
}
