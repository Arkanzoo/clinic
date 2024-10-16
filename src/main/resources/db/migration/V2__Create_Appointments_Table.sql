CREATE TABLE appointments (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              patient_id BIGINT NOT NULL,
                              appointment_date TIMESTAMP NOT NULL,
                              FOREIGN KEY (patient_id) REFERENCES patients(id)
);