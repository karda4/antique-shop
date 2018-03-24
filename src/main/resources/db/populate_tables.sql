INSERT INTO users(id, name, password) VALUES (1, 'yura', '123');
INSERT INTO users(id, name, password) VALUES (2, 'sasha', '123');

INSERT INTO role(id, name) VALUES (1, 'ROLE_USER');
INSERT INTO role(id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);

INSERT INTO category (id, name) VALUES (1, 'category_1');
INSERT INTO category (id, name) VALUES (2, 'category_2');

INSERT INTO image (id, path) VALUES (1, 'http://placehold.it/320x150');

INSERT INTO product (id, name, price, description, category_id, image_id) VALUES (1, 'product_1', 120, 'description_1', 1, 1);
