package com.novel.novelexplorer.batch;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.core.io.UrlResource;

/**
 * TODO maybe use default xml reader builder
 */
@RequiredArgsConstructor
public class HtmlItemReader implements ItemReader<Element> {
    private final Document document;

    @Override
    public Element read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }
}
