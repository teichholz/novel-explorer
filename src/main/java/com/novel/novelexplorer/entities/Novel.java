package com.novel.novelexplorer.entities;

import com.novel.novelexplorer.sources.NovelSource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Novel {

    @Id
    @SequenceGenerator(name = "novel_id_seq", sequenceName = "novel_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "novel_id_seq")
    private long id;
    @NonNull
    private String title;
    @NonNull
    private NovelSource novelSource;
    @Lob
    private byte[] coverImage;
    @NonNull
    private Long chapterCount;
    @NonNull
    private Double rating;
    private Date releaseDate;
    private Long viewsTotal;
    /**
     * TODO this should probably be a versioned column.
     * This allows for better statistics.
     */
    private Long viewsLastMonth;
    @NonNull
    private String linkNovelOverview;
    @NonNull
    private String linkNovelChapters;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Novel novel = (Novel) o;
        return Objects.equals(id, novel.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}