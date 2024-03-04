CREATE SEQUENCE kroha_product_id_seq;

CREATE TABLE kroha_product (
    id BIGINT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    cost VARCHAR(255) NOT NULL,
    photo BYTEA
);
