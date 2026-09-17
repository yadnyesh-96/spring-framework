
CREATE DATABASE employee_hr_portal;
USE employee_hr_portal;

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(100) NOT NULL,
    salary INT NOT NULL,
    status VARCHAR(20) NOT NULL
);

DESCRIBE employees;

SELECT *FROM employees;

INSERT INTO employees (name, department, salary, status)
VALUES
('Rahul','Python',41200,'ACTIVE');