
CREATE DATABASE jaltantra_db;
USE jaltantra_db;

CREATE TABLE roles(
	role_id INT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(20) NOT NULL UNIQUE
);

INSERT INTO roles
(role_name)
VALUES
('ADMIN'),
('MANAGER'),
('FARMER');

SELECT *FROM roles;

CREATE TABLE users(
	user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role_id INT NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_users_role
		FOREIGN KEY (role_id)
        REFERENCES 	roles(role_id)
);

CREATE TABLE admins (
    admin_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL UNIQUE,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    mobile VARCHAR(15),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_admin_user
        FOREIGN KEY (user_id)
        REFERENCES users(user_id)
);

INSERT INTO users
(username,password,role_id)
VALUES
('yadnyesh','Pass@123',1);

INSERT INTO users
(username, password, role_id)
VALUES
('mangesh', 'mangesh@123', 2);

-- ('admin','admin@123',1);


INSERT INTO admins
(user_id,full_name,email,mobile)
VALUES
(2,'yadnyesh','yadnyesh@124','+91 52463 78942');



-- (1,'System Administrator','admin@jaltantra.com','+91 56484 12596');

SELECT *FROM roles;
SELECT *FROM users;
SELECT *FROM admins;

SELECT
    a.admin_id,
    a.user_id,
    a.full_name,
    a.email,
    a.mobile,
    a.created_at,
    a.updated_at,
    u.status
FROM admins a
JOIN users u
    ON a.user_id = u.user_id
WHERE a.user_id = 1;


CREATE TABLE regions(
	region_id INT PRIMARY KEY AUTO_INCREMENT,
    region_name VARCHAR(100) NOT NULL,
    area VARCHAR(100) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO regions
(region_name, area)
VALUES
('Pune', 'Haveli'),
('Pune', 'Mulshi'),
('Nashik', 'Sinnar');

SELECT * FROM regions;

CREATE TABLE managers (
    manager_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL UNIQUE,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    mobile VARCHAR(15),
    region_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_manager_user
        FOREIGN KEY (user_id)
        REFERENCES users(user_id),

    CONSTRAINT fk_manager_region
        FOREIGN KEY (region_id)
        REFERENCES regions(region_id)
);

INSERT INTO managers
(user_id, full_name, email, mobile, region_id)
VALUES
(2, 'Mangesh Patil', 'mangesh@jaltantra.com', '+91 9876543210', 1);

SELECT * FROM managers;

USE jaltantra_db;

CREATE TABLE farmers (
    farmer_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL UNIQUE,
    full_name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    mobile VARCHAR(15),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_farmer_user
        FOREIGN KEY (user_id)
        REFERENCES users(user_id)
);