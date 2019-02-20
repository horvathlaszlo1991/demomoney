CREATE TABLE wallet(
    id bigint unsigned NOT NULL auto_increment,
    cash bigint,
    card bigint,
    user_id bigint unsigned NOT NULL,
    deleted tinyint(1) unsigned NOT NULL DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES user(id),
    CONSTRAINT pk_wallet PRIMARY KEY (id)

)

ENGINE=InnoDB;

INSERT INTO wallet (cash, card, user_id) VALUES (135, 614, 1);
INSERT INTO wallet (cash, card, user_id) VALUES (4165, 64614, 2);