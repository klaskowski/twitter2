USE twitter2;

CREATE TABLE user (
    id int NOT NULL AUTO_INCREMENT,
    username varchar(255),
    password varchar(255),
    PRIMARY KEY (`id`)
);
