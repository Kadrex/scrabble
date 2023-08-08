CREATE TABLE group_id (
    id int not null primary key
);

CREATE TABLE letter_group (
                              id int not null,
                              group_id int not null,
                              letter varchar(1) not null unique,
                              primary key (id),
                              foreign key (group_id) references group_id(id)
);

CREATE TABLE points (
                        id int not null,
                        letter_group_id int not null,
                        points int not null,
                        primary key (id),
                        foreign key (letter_group_id) references group_id(id)
);

CREATE TABLE valid_words (
                             id int not null,
                             word varchar(255) not null,
                             primary key (id)
);


INSERT INTO group_id values (1);
INSERT INTO group_id values (2);
INSERT INTO group_id values (3);
INSERT INTO group_id values (4);
INSERT INTO group_id values (5);
INSERT INTO group_id values (6);
INSERT INTO group_id values (7);

INSERT INTO letter_group values (1, 1, 'A');
INSERT INTO letter_group values (2, 1, 'E');
INSERT INTO letter_group values (3, 1, 'I');
INSERT INTO letter_group values (4, 1, 'L');
INSERT INTO letter_group values (5, 1, 'N');
INSERT INTO letter_group values (6, 1, 'O');
INSERT INTO letter_group values (7, 1, 'R');
INSERT INTO letter_group values (8, 1, 'S');
INSERT INTO letter_group values (9, 1, 'T');
INSERT INTO letter_group values (10, 1, 'U');
INSERT INTO points values (1, 1, 1);

INSERT INTO letter_group values (11, 2, 'D');
INSERT INTO letter_group values (12, 2, 'G');
INSERT INTO points values (2, 2, 2);

INSERT INTO letter_group values (13, 3, 'B');
INSERT INTO letter_group values (14, 3, 'C');
INSERT INTO letter_group values (15, 3, 'M');
INSERT INTO letter_group values (16, 3, 'P');
INSERT INTO points values (3, 3, 3);

INSERT INTO letter_group values (17, 4, 'F');
INSERT INTO letter_group values (18, 4, 'H');
INSERT INTO letter_group values (19, 4, 'V');
INSERT INTO letter_group values (20, 4, 'W');
INSERT INTO letter_group values (21, 4, 'Y');
INSERT INTO points values (4, 4, 4);

INSERT INTO letter_group values (22, 5, 'K');
INSERT INTO points values (5, 5, 5);

INSERT INTO letter_group values (23, 6, 'J');
INSERT INTO letter_group values (24, 6, 'X');
INSERT INTO points values (6, 6, 8);

INSERT INTO letter_group values (25, 7, 'Q');
INSERT INTO letter_group values (26, 7, 'Z');
INSERT INTO points values (7, 7, 10);


INSERT INTO valid_words VALUES (1, 'beaver');
INSERT INTO valid_words VALUES (2, 'cougar');
INSERT INTO valid_words VALUES (3, 'dolphin');
INSERT INTO valid_words VALUES (4, 'eatery');
INSERT INTO valid_words VALUES (5, 'film');
INSERT INTO valid_words VALUES (6, 'guinea');
INSERT INTO valid_words VALUES (7, 'house');
INSERT INTO valid_words VALUES (8, 'island');
INSERT INTO valid_words VALUES (9, 'jarring');
INSERT INTO valid_words VALUES (10, 'koala');
INSERT INTO valid_words VALUES (11, 'lemon');
INSERT INTO valid_words VALUES (12, 'melon');
INSERT INTO valid_words VALUES (13, 'noble');
INSERT INTO valid_words VALUES (14, 'ocult');
INSERT INTO valid_words VALUES (15, 'paper');
INSERT INTO valid_words VALUES (16, 'quality');
INSERT INTO valid_words VALUES (17, 'rabbit');
INSERT INTO valid_words VALUES (18, 'snow');
INSERT INTO valid_words VALUES (19, 'tower');
INSERT INTO valid_words VALUES (20, 'under');
INSERT INTO valid_words VALUES (21, 'voucher');
INSERT INTO valid_words VALUES (22, 'wabbit');
INSERT INTO valid_words VALUES (23, 'xylophone');
INSERT INTO valid_words VALUES (24, 'yuck');
INSERT INTO valid_words VALUES (25, 'zoo');
