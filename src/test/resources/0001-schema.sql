CREATE TABLE IF NOT EXISTS author (
    id bigserial PRIMARY KEY,
    name varchar(255),
    surname varchar(255)
);

CREATE TABLE IF NOT EXISTS publishing_house (
    id bigserial PRIMARY KEY,
    name varchar(255)
);

CREATE TABLE IF NOT EXISTS book (
    id bigserial PRIMARY KEY,
    name varchar(255),
    publishing_year integer,
    publishing_house_id bigint,
    FOREIGN KEY (publishing_house_id) REFERENCES publishing_house(id)
);

CREATE TABLE IF NOT EXISTS author_book(
    authors_id bigint,
    books_id bigint,
    FOREIGN KEY (authors_id) REFERENCES author(id),
    FOREIGN KEY (books_id) REFERENCES book(id)
);


INSERT INTO author (name, surname) VALUES ('author1', 'author1');
INSERT INTO author (name, surname) VALUES ('author2', 'author2');
INSERT INTO author (name, surname) VALUES ('author3', 'author3');

INSERT INTO publishing_house (name) VALUES ('ph1');
INSERT INTO publishing_house (name) VALUES ('ph2');

INSERT INTO book (name, publishing_year, publishing_house_id) VALUES ('book1', 1111, 1);
INSERT INTO book (name, publishing_year, publishing_house_id) VALUES ('book2', 2222, 2);
INSERT INTO book (name, publishing_year, publishing_house_id) VALUES ('book3', 3333, 1);