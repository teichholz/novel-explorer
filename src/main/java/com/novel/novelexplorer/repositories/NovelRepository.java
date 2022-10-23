package com.novel.novelexplorer.repositories;

import com.novel.novelexplorer.entities.Novel;
import com.novel.novelexplorer.sources.NovelSource;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NovelRepository extends CrudRepository<Novel, Long> {
    List<Novel> findByTitle(String title);

    List<Novel> findByNovelSource(NovelSource source);
}
