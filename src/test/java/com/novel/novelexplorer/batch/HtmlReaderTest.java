package com.novel.novelexplorer.batch;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.HTML;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
public class HtmlReaderTest {
    @Value("classpath:test-data/index.html")
    private Resource stateFile;

    @Test
    public void testResource() throws IOException {
        Resource resource = stateFile;
        Document parsed = Jsoup.parse(resource.getInputStream(), StandardCharsets.UTF_8.name(), "");
        System.out.println(parsed.html());
    }

    private ItemReader<HTML> createReader() {
        // use AbstractItemCountingItemStreamItemReader to implement html reader
        // Before that properly try xml reader
        return new StaxEventItemReaderBuilder<HTML>()
                .name("itemReader")
                .resource(stateFile)
                .addFragmentRootElements("div class=\"fiction-list-item row\"")
                .build();
    }
}
