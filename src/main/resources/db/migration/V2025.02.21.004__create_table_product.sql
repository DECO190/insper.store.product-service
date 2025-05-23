CREATE TABLE product (
    id_product VARCHAR(36) NOT NULL PRIMARY KEY,
    tx_name VARCHAR(256) NOT NULL,
    vl_price DECIMAL(10, 2) NOT NULL,
    tx_unit VARCHAR(64) NOT NULL
);
