package com.novel.novelexplorer.repositories;

import com.novel.novelexplorer.entities.Novel;
import com.novel.novelexplorer.sources.NovelSource;
import lombok.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NovelRepository extends CrudRepository<Novel, Long> {
    List<Novel> findByTitle(String title);

    List<Novel> findByNovelSource(NovelSource source);
}
