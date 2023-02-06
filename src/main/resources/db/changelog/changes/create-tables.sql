--liquibase formatted sql

--changeset Maksym:2
create table users(
    id INT NOT NULL AUTO_INCREMENT,
    login VARCHAR(128) NOT NULL,
    password VARCHAR(64),
    email VARCHAR(64),
    firstname VARCHAR(64),
    lastname VARCHAR(64),
    phone VARCHAR(24),
    birthday date,
    status TINYINT NOT NULL DEFAULT 1,
    created date DEFAULT NULL,
    updated date DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY email_UNIQUE (email),
    UNIQUE KEY login_UNIQUE (login)
);
--rollback drop table users;

--changeset Maksym:3
create table roles(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(64) NOT NULL,
    status TINYINT NOT NULL DEFAULT 1,
    created date DEFAULT NULL,
    updated date DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY name_UNIQUE (name)
);
--rollback drop table roles;

--changeset Maksym:4
CREATE TABLE users_roles (
    user_id INT  NOT NULL,
    role_id INT  NOT NULL,
    status TINYINT NOT NULL DEFAULT 1,
    created date DEFAULT NULL,
    updated date DEFAULT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT Constr_Users_Roles_Users_fk
     FOREIGN KEY user_fk (user_id) REFERENCES users (id)
         ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT Constr_Users_Roles_Roles_fk
     FOREIGN KEY role_fk (role_id) REFERENCES roles (id)
         ON DELETE CASCADE ON UPDATE CASCADE
);
--rollback drop table roles;

--changeset Maksym:5
CREATE TABLE colors (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(45) NOT NULL,
    status TINYINT NOT NULL DEFAULT 1,
    created date DEFAULT NULL,
    updated date DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY name_UNIQUE (name)
);
--rollback drop table colors;

--changeset Maksym:6
CREATE TABLE sorts (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(45) NOT NULL,
    status TINYINT NOT NULL DEFAULT 1,
    created date DEFAULT NULL,
    updated date DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY name_UNIQUE (name)
);
--rollback drop table sorts;

--changeset Maksym:7
CREATE TABLE countries (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(128) NOT NULL,
    status TINYINT NOT NULL DEFAULT 1,
    created date DEFAULT NULL,
    updated date DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY name_UNIQUE (name)
);
--rollback drop table countries;

--changeset Maksym:8
CREATE TABLE regions (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(128) DEFAULT NULL,
    country_id int NOT NULL,
    status TINYINT NOT NULL DEFAULT 1,
    created date DEFAULT NULL,
    updated date DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY name_UNIQUE (name),
    KEY fk_country_id_idx (country_id),
    CONSTRAINT fk_country_id FOREIGN KEY (country_id) REFERENCES countries (id)
);
--rollback drop table regions;

--changeset Maksym:9
CREATE TABLE manufacturers (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(128) DEFAULT NULL,
    status TINYINT NOT NULL DEFAULT 1,
    created date DEFAULT NULL,
    updated date DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY name_UNIQUE (name)
);
--rollback drop table manufacturers;

--changeset Maksym:10
CREATE TABLE sweetness (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(64) NOT NULL,
    status TINYINT NOT NULL DEFAULT 1,
    created date DEFAULT NULL,
    updated date DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY name_UNIQUE (name)
);
--rollback drop table sweetness;

--changeset Maksym:11
CREATE TABLE wines (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(128) NOT NULL,
    color_id int NOT NULL,
    sort_id int NOT NULL,
    country_id int NOT NULL,
    region_id int DEFAULT NULL,
    manufacturer_id int DEFAULT NULL,
    price decimal(10,2) unsigned DEFAULT NULL,
    volume decimal(4,2) unsigned NOT NULL,
    year int unsigned NOT NULL,
    sweetness_id int NOT NULL,
    rang int unsigned DEFAULT NULL,
    discount int unsigned DEFAULT 0,
    composition varchar(255) DEFAULT NULL,
    description varchar(1024) DEFAULT NULL,
    picture_id int unsigned DEFAULT NULL,
    status TINYINT DEFAULT 1,
    created date DEFAULT NULL,
    updated date DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY wines_id_uindex (id),
    KEY fk_idx (country_id),
    KEY fk_sweetness_idx (sweetness_id),
    KEY fk_region_id_idx (region_id),
    KEY fk_color_id_idx (color_id),
    KEY fk_sort_id_idx (sort_id),
    KEY fkw_manufacturer_id_idx (manufacturer_id),
    CONSTRAINT fkw_color_id FOREIGN KEY (color_id) REFERENCES colors (id),
    CONSTRAINT fkw_sort_id FOREIGN KEY (sort_id) REFERENCES sorts (id),
    CONSTRAINT fkw_country_id FOREIGN KEY (country_id) REFERENCES countries (id),
    CONSTRAINT fkw_manufacturer_id FOREIGN KEY (manufacturer_id) REFERENCES manufacturers (id),
    CONSTRAINT fkw_region_id FOREIGN KEY (region_id) REFERENCES regions (id),
    CONSTRAINT fkw_sweetness_id FOREIGN KEY (sweetness_id) REFERENCES sweetness (id)
);
--rollback drop table wines;

--changeset Maksym:12
CREATE TABLE stock_movements (
    id INT NOT NULL AUTO_INCREMENT,
    wine_id INT NOT NULL,
    quantity INT UNSIGNED NOT NULL,
    type INT NOT NULL,
    PRIMARY KEY (id),
    INDEX fk_wine_id_idx (wine_id ASC) INVISIBLE,
    CONSTRAINT fk_stock_movements_wine_id
     FOREIGN KEY (wine_id)
         REFERENCES wines (id)
         ON DELETE NO ACTION
         ON UPDATE NO ACTION
);
--rollback drop table stock_movements;

--changeset Maksym:13
CREATE TABLE shopping_basket (
    id int NOT NULL AUTO_INCREMENT,
    wine_id int DEFAULT NULL,
    quantity int unsigned DEFAULT NULL,
    user_id int DEFAULT 1,
    status TINYINT DEFAULT 1,
    created date DEFAULT NULL,
    updated date DEFAULT NULL,
    PRIMARY KEY (id),
    KEY fk_wine_id_idx (wine_id),
    KEY fk_user_id_idx (user_id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_wine_id FOREIGN KEY (wine_id) REFERENCES wines (id)
);
--rollback DROP TABLE shopping_basket;

--changeset Maksym:14
CREATE TABLE payment_types (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(64) NOT NULL,
    status TINYINT DEFAULT 1,
    created date DEFAULT NULL,
    updated date DEFAULT NULL,
    PRIMARY KEY (id)
)
--rollback DROP TABLE payment_types;

--changeset Maksym:15
CREATE TABLE delivery_types (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(64) NOT NULL,
    status TINYINT NOT NULL DEFAULT 1,
    created date DEFAULT NULL,
    updated date DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY name_UNIQUE (name)
)
--rollback DROP TABLE delivery_types;

--changeset Maksym:17
CREATE TABLE orders (
    id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    order_date date NOT NULL,
    firstname varchar(64) NOT NULL,
    lastname varchar(64) NOT NULL,
    email varchar(64) NOT NULL,
    phone varchar(24) NOT NULL,
    delivery_type_id int NOT NULL,
    town varchar(64) NOT NULL,
    address varchar(128) NOT NULL,
    payment_type_id int NOT NULL,
    discount_sum decimal(10,2) unsigned,
    order_status int NOT NULL,
    status TINYINT DEFAULT 1,
    created date DEFAULT NULL,
    updated date DEFAULT NULL,
    PRIMARY KEY (id),
    KEY fko_payment_type_id_idx (payment_type_id),
    KEY fko_delivery_type_id_idx (delivery_type_id),
    KEY fko_user_id_idx (user_id),
    CONSTRAINT fko_delivery_type_id FOREIGN KEY (delivery_type_id) REFERENCES delivery_types (id),
    CONSTRAINT fko_payment_type_id FOREIGN KEY (payment_type_id) REFERENCES payment_types (id),
    CONSTRAINT fko_user_id FOREIGN KEY (user_id) REFERENCES users (id)
)
--rollback DROP TABLE orders;

--changeset Maksym:18
CREATE TABLE order_details (
    id int NOT NULL AUTO_INCREMENT,
    order_id int NOT NULL,
    wine_id int NOT NULL,
    quantity int NOT NULL,
    price decimal(10,2) NOT NULL,
    status TINYINT DEFAULT 1,
    created date DEFAULT NULL,
    updated date DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY fkod_order_id_idx (order_id),
    KEY fkod_wine_id_idx (wine_id),
    CONSTRAINT fkod_order_id FOREIGN KEY (order_id) REFERENCES orders (id),
    CONSTRAINT fkod_wine_id FOREIGN KEY (wine_id) REFERENCES wines (id) ON DELETE CASCADE ON UPDATE CASCADE
)
--rollback DROP TABLE order_details;

--changeset Maksym:19
CREATE TABLE dish_categories (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(64) NOT NULL,
    status TINYINT DEFAULT 1,
    created date DEFAULT NULL,
    updated date DEFAULT NULL,
    PRIMARY KEY (id)
)
--rollback DROP TABLE dish_categories;

--changeset Maksym:20
CREATE TABLE dishes (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(45) NOT NULL,
    dish_category_id int NOT NULL,
    status TINYINT DEFAULT 1,
    created date DEFAULT NULL,
    updated date DEFAULT NULL,
    PRIMARY KEY (id),
    KEY fkdc_dish_category_id_idx (dish_category_id),
    CONSTRAINT fkdc_dish_category_id FOREIGN KEY (dish_category_id) REFERENCES dish_categories (id) ON DELETE CASCADE ON UPDATE CASCADE
)
--rollback DROP TABLE dishes;

--changeset Maksym:21
CREATE TABLE wines_dishes (
    wine_id int NOT NULL,
    dish_id int NOT NULL,
    status TINYINT DEFAULT 1,
    created date DEFAULT NULL,
    updated date DEFAULT NULL,
    KEY fkwd_wine_id_idx (wine_id),
    KEY fkwd_dish_id_idx (dish_id),
    CONSTRAINT fkwd_dish_id FOREIGN KEY (dish_id) REFERENCES dishes (id),
    CONSTRAINT fkwd_wine_id FOREIGN KEY (wine_id) REFERENCES wines (id)
)
--rollback DROP TABLE wines_dishes;
