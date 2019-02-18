CREATE TABLE user(
    id bigint unsigned NOT NULL auto_increment,
    name varchar(100) NOT NULL,
    email varchar(100) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
    userrole varchar(10) NOT NULL DEFAULT 'USER',
    deleted tinyint(1) unsigned NOT NULL DEFAULT 0,
    CONSTRAINT pk_user PRIMARY KEY (id)
)

ENGINE=InnoDB;

INSERT INTO user (name, email, password) VALUES ('Geza', 'geza@kekazeg.hu', 'gezavagyok11');
INSERT INTO user (name, email, password) VALUES ('Joska', 'joskagyerek@bezboz.hu', 'mostpofazzalJoskaGyerek');
INSERT INTO user (name, email, password, userrole) VALUES ('admin', 'admin@demomoney.hu', 'admin', 'ADMIN');