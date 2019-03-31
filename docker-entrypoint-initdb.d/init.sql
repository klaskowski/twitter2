USE twitter2;

CREATE TABLE user (
    id int NOT NULL AUTO_INCREMENT,
    username varchar(255),
    password varchar(255),
    PRIMARY KEY (`id`)
);

CREATE TABLE tweet (
    id int NOT NULL AUTO_INCREMENT,
    content varchar(255),
    date DATETIME,
    user_id int,
    PRIMARY KEY (`id`),
    FOREIGN KEY (user_id) REFERENCES user(id)
)
