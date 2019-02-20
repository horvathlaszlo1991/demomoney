CREATE TABLE user(
    id bigint unsigned NOT NULL auto_increment,
    name varchar(100) NOT NULL,
    email varchar(100) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
    role varchar(10) NOT NULL DEFAULT 'USER',
    deleted tinyint(1) unsigned NOT NULL DEFAULT 0,
    CONSTRAINT pk_user PRIMARY KEY (id)
)

ENGINE=InnoDB;

INSERT INTO user (name, email, password) VALUES ('user', 'geza@kekazeg.hu', '$2a$10$MOdYtjJPIympQN8484STP.LQGRDZHQTNb5/MXvdsWuz5ZVEpNY7Se');
INSERT INTO user (name, email, password, role) VALUES ('admin', 'admin@demomoney.hu', '$2a$10$7C3KaLAXgXwfM8NboaXj8OryT7a2dbllcvVog8kpwdZ2DSh2jdRxS', 'ADMIN');