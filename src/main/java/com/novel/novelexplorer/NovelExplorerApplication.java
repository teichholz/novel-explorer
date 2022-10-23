package com.novel.novelexplorer;

import com.novel.novelexplorer.entities.Novel;
import com.novel.novelexplorer.repositories.NovelRepository;
import com.novel.novelexplorer.sources.NovelSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
					.title("Heaven above")
					.rating(0.0)
					.novelSource(NovelSource.RoyalRoad)
					.chapterCount(100L)
					.linkNovelChapters("")
					.linkNovelOverview("")
					.build();

			Novel saved = repository.save(novel);

			for (Novel novel1 : repository.findByNovelSource(NovelSource.RoyalRoad)) {
				log.info(novel1.toString());
			}
		};
	}
}
