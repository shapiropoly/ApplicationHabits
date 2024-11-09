CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    "name" varchar(100) NOT NULL,
    username varchar(100) UNIQUE NOT NULL,
    email varchar(100) NOT NULL,
    "password" varchar(100) NOT NULL,
    role_id INTEGER NOT NULL,
    dateregistration DATE NOT NULL,
    datelastactivity DATE NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

INSERT INTO users ("name", username, email, "password", role_id, dateregistration, datelastactivity)
VALUES
('Bob', 'bob_191', 'bob191@gmail.com', '34839dkjfhsdjf343', 1, '2024-09-17', '2024-09-18'), -- admin
('Mark', 'mio_mark', 'mark2@gmail.com', '53239dkjfh332343', 2, '2024-09-16', '2024-09-18'); -- user


