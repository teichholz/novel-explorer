package com.novel.novelexplorer.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Blob;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Novel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private Blob coverImage;
    private long chapterCount;
    private double rating;
    private Date releaseDate;
    private long viewsTotal;
    /**
     * TODO this should probably be a versioned column.
     * This allows for better statistics.
     */
    private long viewsLastMonth;
    private String linkNovelOverview;
    private String linkNovelChapters;
}