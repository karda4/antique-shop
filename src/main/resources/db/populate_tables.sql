INSERT INTO users(id, name, password) VALUES (1, 'yura', '123');
INSERT INTO users(id, name, password) VALUES (2, 'sasha', '123');

INSERT INTO role(id, name) VALUES (1, 'ROLE_USER');
INSERT INTO role(id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);

INSERT INTO category (id, name) VALUES (1, 'Clocks');
INSERT INTO category (id, name) VALUES (2, 'Furniture');
INSERT INTO category (id, name) VALUES (3, 'Jewelry');

INSERT INTO image (id, path) VALUES (1, 'http://placehold.it/320x150');

INSERT INTO product (category_id, image_id, name, price, description) VALUES (1, 1, 'Seth Thomas wood works clock', 120, 'This clock has a nicely refinished solid mahogany case which is in great condition. There is only one tiny veneer chip on the upper left corner. The columns are tiger maple and they make for a good visual contrast with the darker mahogany. The carved paw feet and fruit basket crest are perfect without any chips.');
INSERT INTO product (category_id, image_id, name, price, description) VALUES (2, 1, 'LARGE SOLICITORS SHELVING DEE', 1650, 'A fabulous painted pine large scale English antique deed rack /bookcase / shelving, that has spent its life in a North of England solicitors office. In superb condition, all very original. Made is solid pine and still in the original paint finish, this antique rack has slatted shelves, all the edges are chamfered and the top cornice is finished on all four sides, so this antqiue deed rack could free stand away from a wall if needed. A superb piece to display or store items. So original, solid and made in great proportions.');
