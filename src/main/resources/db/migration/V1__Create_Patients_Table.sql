CREATE TABLE patients (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          cpf VARCHAR(11) NOT NULL UNIQUE,
                          email VARCHAR(100),
                          phone VARCHAR(20),
                          address VARCHAR(255)
);