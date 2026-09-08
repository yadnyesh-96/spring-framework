CREATE DATABASE spring_core_banking;

USE spring_core_banking;

CREATE TABLE bank_accounts (
    account_number VARCHAR(20) PRIMARY KEY,
    customer_name VARCHAR(100) NOT NULL,
    account_type VARCHAR(20) NOT NULL,
    balance DECIMAL(15,2) NOT NULL,
    status VARCHAR(20) NOT NULL
);


INSERT INTO bank_accounts
(account_number, customer_name, account_type, balance, status)
VALUES
('ACC1001', 'Yadnyesh', 'SAVINGS', 50000.00, 'ACTIVE'),
('ACC1002', 'Rahul', 'CURRENT', 125000.50, 'ACTIVE'),
('ACC1003', 'Priya', 'SAVINGS', 75000.00, 'ACTIVE');

SELECT *FROM bank_accounts;