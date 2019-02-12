CREATE TABLE user(
    id bigint unsigned NOT NULL auto_increment,
    name varchar(100) NOT NULL,
    email varchar(100) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
    deleted tinyint(1) unsigned NOT NULL DEFAULT 0,
    CONSTRAINT pk_user PRIMARY KEY (id)
)

ENGINE=InnoDB;