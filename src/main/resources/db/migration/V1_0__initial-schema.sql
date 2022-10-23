CREATE TABLE novel
(
 id                SERIAL,
 novel_source    varchar(100) NOT NULL,
 title             varchar(100) NOT NULL,
 cover_image          oid,
 chapter_count      integer NOT NULL,
 rating            numeric(3,2) NOT NULL,
 release_date       date,
 views_total        integer,
 views_last_month    integer,
 link_novel_overview varchar(100) NOT NULL,
 link_novel_chapters varchar(100) NOT NULL,
 CONSTRAINT PK_NOVEL PRIMARY KEY ( "id")
);
