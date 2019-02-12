CREATE TABLE wallet(
    id bigint unsigned NOT NULL auto_increment,
    cash bigint,
    card bigint,
    user_id bigint unsigned NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id),
    CONSTRAINT pk_wallet PRIMARY KEY (id)

)

ENGINE=InnoDB;