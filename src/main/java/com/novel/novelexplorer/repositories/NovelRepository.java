package com.novel.novelexplorer.repositories;

import com.novel.novelexplorer.entities.Novel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NovelRepository extends CrudRepository<Novel, Long> {
    List<Novel> findByTitle(String title);
}
