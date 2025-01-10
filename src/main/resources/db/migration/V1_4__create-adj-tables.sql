CREATE TABLE users_to_roles (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);


CREATE TABLE users_to_habits (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    habit_id INTEGER NOT NULL,
    frequency TEXT,
    replay INTEGER,
    date_start DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (habit_id) REFERENCES habits(id)
);


CREATE TABLE habits_to_collections (
    id SERIAL PRIMARY KEY,
    habit_id INTEGER NOT NULL,
    collection_id INTEGER NOT NULL,
    FOREIGN KEY (habit_id) REFERENCES habits(id),
    FOREIGN KEY (collection_id) REFERENCES collections(id)
);


CREATE TABLE check_up (
id SERIAL PRIMARY KEY,
date_check date NOT NULL,
user_to_habit_id INTEGER NOT NULL,
FOREIGN KEY (user_to_habit_id) REFERENCES users_to_habits(id)
);

