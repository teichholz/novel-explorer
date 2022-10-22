CREATE TABLE Novel
(
 "id"                integer NOT NULL,
 FK_NovelAlias     integer NOT NULL,
 FK_NovelSource    integer NOT NULL,
 title             varchar(100) NOT NULL,
 coverImg          bytea NOT NULL,
 chapterCount      integer NOT NULL,
 rating            numeric(3,2) NOT NULL,
 releaseDate       date NOT NULL,
 viewsTotal        integer NOT NULL,
 viewsLastMonth    integer NOT NULL,
 linkNovelOverview varrchar(100) NOT NULL,
 linkNovelChapters varchar(100) NOT NULL,
 CONSTRAINT PK_1 PRIMARY KEY ( "id", FK_NovelAlias, FK_NovelSource ),
 CONSTRAINT FK_1 FOREIGN KEY ( FK_NovelAlias ) REFERENCES NovelAlias ( "id" ),
 CONSTRAINT FK_2 FOREIGN KEY ( FK_NovelSource ) REFERENCES NovelSoure ( "id" )
);

CREATE INDEX FK_2 ON Novel
(
 FK_NovelAlias
);

CREATE INDEX FK_3 ON Novel
(
 FK_NovelSource
);

CREATE TABLE NovelAlias
(
 "id"   integer NOT NULL,
 name varchar(100) NOT NULL,
 CONSTRAINT PK_1 PRIMARY KEY ( "id" )
);

CREATE TABLE NovelSoure
(
 "id"                integer NOT NULL,
 name              varchar(100) NOT NULL,
 domain            varchar(100) NOT NULL,
 linkNovelOverview varchar(100) NOT NULL,
 CONSTRAINT PK_1 PRIMARY KEY ( "id" )
);
