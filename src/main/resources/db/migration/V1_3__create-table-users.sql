CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    "name" varchar(100) NOT NULL,
    username varchar(100) UNIQUE NOT NULL,
    email varchar(100) NOT NULL,
    "password" varchar(100) NOT NULL,
    dateregistration DATE NOT NULL,
    datelastactivity DATE NOT NULL
);

INSERT INTO users ("name", username, email, "password", dateregistration, datelastactivity)
VALUES
('Bob', 'bob_191', 'bob191@gmail.com', '34839dkjfhsdjf343', '2024-09-17', '2024-09-18'), -- admin
('Mark', 'mio_mark', 'mark2@gmail.com', '53239dkjfh332343', '2024-09-16', '2024-09-18'); -- user


