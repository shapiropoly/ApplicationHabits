INSERT INTO categories (title, description, image)
VALUES
('Здоровье', 'Описание категории', 'image1'),
('Спорт', 'Описание категории', 'image2'),
('Отношения', 'Описание категории', 'image3'),
('Хобби', 'Описание категории', 'image4')
;

INSERT INTO habits (title, description, category_id, image)
VALUES
('Йога', 'Описание привычки', 2, 'image1'),
('Чтение', 'Описание привычки', 4,'image2');

--INSERT INTO roles (title)
--VALUES ('admin'), ('staff'), ('user');

INSERT INTO collections (title, description, image)
VALUES
('12 rules of life', 'Описание коллекции', 'image1'),
('7 skills of high effective people', 'Описание коллекции', 'image2');

--INSERT INTO users ("name", username, email, "password", "role", dateRegistration, dateLastActivity)
--VALUES
--('user1', 'username1', 'user1@gmail.com', '34839dkjfhsdjf343', 3, '2024-09-17', '2024-09-18'),
--('user2', 'username2', 'user2@gmail.com', '53239dkjfh332343', 3, '2024-09-16', '2024-09-18');
--