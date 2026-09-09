

CREATE DATABASE inventory_management;

USE inventory_management;

CREATE TABLE products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) NOT NULL
);

INSERT INTO products
(product_name, category, price, status)
VALUES
('Laptop', 'ELECTRONICS', 65000.00, 'ACTIVE'),
('Wireless Mouse', 'ACCESSORIES', 1200.00, 'ACTIVE'),
('Mechanical Keyboard', 'ACCESSORIES', 4500.00, 'ACTIVE'),
('Monitor', 'ELECTRONICS', 18000.00, 'ACTIVE'),
('USB-C Hub', 'ACCESSORIES', 2500.00, 'ACTIVE');


SELECT * FROM products;

CREATE TABLE inventory (
    inventory_id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    reorder_level INT NOT NULL,

    CONSTRAINT fk_inventory_product
        FOREIGN KEY (product_id)
        REFERENCES products(product_id)
);
INSERT INTO inventory
(product_id, quantity, reorder_level)
VALUES
(1, 20, 5),
(2, 100, 20),
(3, 50, 10),
(4, 15, 5),
(5, 30, 8);

SELECT * FROM inventory;

CREATE TABLE orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(100) NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(12,2) NOT NULL,
    status VARCHAR(20) NOT NULL
);

CREATE TABLE order_items (
    order_item_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,

    CONSTRAINT fk_order_item_order
        FOREIGN KEY (order_id)
        REFERENCES orders(order_id),

    CONSTRAINT fk_order_item_product
        FOREIGN KEY (product_id)
        REFERENCES products(product_id)
);