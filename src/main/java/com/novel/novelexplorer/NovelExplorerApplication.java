package com.novel.novelexplorer;

import com.novel.novelexplorer.entities.Novel;
import com.novel.novelexplorer.repositories.NovelRepository;
import com.novel.novelexplorer.sources.NovelSource;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.UrlResource;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
@Slf4j
public class NovelExplorerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NovelExplorerApplication.class, args);
	}

}
