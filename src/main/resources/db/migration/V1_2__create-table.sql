CREATE TABLE categories (
id SERIAL,
title varchar(50) NOT NULL,
description TEXT NOT NULL,
image varchar(100) NOT NULL,
PRIMARY KEY (id)
);


CREATE TABLE habits (
    id SERIAL PRIMARY KEY,
    title varchar(200) NOT NULL,
    description TEXT NOT NULL,
    category_id integer NOT NULL,
    image varchar(50) NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);


CREATE TABLE roles (
id SERIAL,
title varchar(50) UNIQUE NOT NULL,
PRIMARY KEY (id)
);


INSERT INTO roles (title)
VALUES ('admin'), ('user');


CREATE TABLE collections (
id SERIAL,
title varchar(100) NOT NULL,
description TEXT NOT NULL,
image varchar(50) NOT NULL,
PRIMARY KEY (id)
);