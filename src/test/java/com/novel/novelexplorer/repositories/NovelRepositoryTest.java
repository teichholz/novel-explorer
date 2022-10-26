package com.novel.novelexplorer.repositories;

import com.novel.novelexplorer.entities.Novel;
import com.novel.novelexplorer.sources.NovelSource;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@FlywayTest
@DataJpaTest
@AutoConfigureEmbeddedDatabase
class NovelRepositoryTest {
    @Autowired
    TestEntityManager entityManager;
    @Autowired
    NovelRepository repository;

    @Test
    void findByTitle() {
        String title = "Glorious Heaven";
        Novel novel = minimalObject();
        novel.setTitle(title);

        Novel saved = entityManager.persist(novel);
        entityManager.flush();

        List<Novel> royalRoadNovels = repository.findByTitle(title);

        assertThat(royalRoadNovels)
                .hasSize(1)
                .containsExactly(saved);
    }

    @Test
    void findByNovelSource() {
        Novel novel = minimalObject();
        novel.setNovelSource(NovelSource.RoyalRoad);

        Novel saved = entityManager.persist(novel);
        entityManager.flush();

        List<Novel> royalRoadNovels = repository.findByNovelSource(NovelSource.RoyalRoad);

        assertThat(royalRoadNovels)
                .hasSize(1)
                .containsExactly(saved);
    }

    private Novel minimalObject() {
        return Novel.builder()
                .title("")
                .rating(0.0)
                .novelSource(NovelSource.RoyalRoad)
                .chapterCount(100L)
                .linkNovelChapters("")
                .linkNovelOverview("")
                .build();
    }
}