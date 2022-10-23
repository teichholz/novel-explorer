package com.novel.novelexplorer.sources;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.EnumSet;

@Converter(autoApply = true)
public class NovelSourceConverter implements AttributeConverter<NovelSource, String> {
    @Override
    public String convertToDatabaseColumn(NovelSource source) {
        if (source == null)
            return null;

        return source.getName();
    }

    @Override
    public NovelSource convertToEntityAttribute(String attribute) {
        if (attribute == null)
            return null;

        return EnumSet.allOf(NovelSource.class)
                .stream()
                .filter(source -> source.getName().equals(attribute))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
