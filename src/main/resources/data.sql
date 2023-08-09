CREATE TABLE group_id (
    id INT NOT NULL PRIMARY KEY
);

CREATE TABLE letter_group (
    id INT NOT NULL,
    group_id INT NOT NULL,
    letter VARCHAR(1) NOT NULL UNIQUE,
    PRIMARY KEY (id),
    FOREIGN KEY (group_id) REFERENCES group_id(id)
);

CREATE TABLE points (
    id INT NOT NULL,
    letter_group_id INT NOT NULL,
    points INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (letter_group_id) REFERENCES group_id(id)
);

CREATE TABLE valid_words (
    id INT NOT NULL AUTO_INCREMENT,
    word VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO group_id VALUES (1);
INSERT INTO group_id VALUES (2);
INSERT INTO group_id VALUES (3);
INSERT INTO group_id VALUES (4);
INSERT INTO group_id VALUES (5);
INSERT INTO group_id VALUES (6);
INSERT INTO group_id VALUES (7);

INSERT INTO letter_group VALUES (1, 1, 'A');
INSERT INTO letter_group VALUES (2, 1, 'E');
INSERT INTO letter_group VALUES (3, 1, 'I');
INSERT INTO letter_group VALUES (4, 1, 'L');
INSERT INTO letter_group VALUES (5, 1, 'N');
INSERT INTO letter_group VALUES (6, 1, 'O');
INSERT INTO letter_group VALUES (7, 1, 'R');
INSERT INTO letter_group VALUES (8, 1, 'S');
INSERT INTO letter_group VALUES (9, 1, 'T');
INSERT INTO letter_group VALUES (10, 1, 'U');
INSERT INTO poINTs VALUES (1, 1, 1);

INSERT INTO letter_group VALUES (11, 2, 'D');
INSERT INTO letter_group VALUES (12, 2, 'G');
INSERT INTO poINTs VALUES (2, 2, 2);

INSERT INTO letter_group VALUES (13, 3, 'B');
INSERT INTO letter_group VALUES (14, 3, 'C');
INSERT INTO letter_group VALUES (15, 3, 'M');
INSERT INTO letter_group VALUES (16, 3, 'P');
INSERT INTO poINTs VALUES (3, 3, 3);

INSERT INTO letter_group VALUES (17, 4, 'F');
INSERT INTO letter_group VALUES (18, 4, 'H');
INSERT INTO letter_group VALUES (19, 4, 'V');
INSERT INTO letter_group VALUES (20, 4, 'W');
INSERT INTO letter_group VALUES (21, 4, 'Y');
INSERT INTO poINTs VALUES (4, 4, 4);

INSERT INTO letter_group VALUES (22, 5, 'K');
INSERT INTO poINTs VALUES (5, 5, 5);

INSERT INTO letter_group VALUES (23, 6, 'J');
INSERT INTO letter_group VALUES (24, 6, 'X');
INSERT INTO poINTs VALUES (6, 6, 8);

INSERT INTO letter_group VALUES (25, 7, 'Q');
INSERT INTO letter_group VALUES (26, 7, 'Z');
INSERT INTO poINTs VALUES (7, 7, 10);


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
