DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR (50) NOT NULL,
    password VARCHAR (50) NOT NULL,
    enabled SMALLINT NOT NULL DEFAULT 1
);

DROP TABLE IF EXISTS role CASCADE;
CREATE TABLE role (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS user_role CASCADE;
CREATE TABLE user_role (
	id BIGSERIAL PRIMARY KEY,
	user_id BIGINT REFERENCES users(id),
	role_id BIGINT REFERENCES role(id)
);

DROP TABLE IF EXISTS category CASCADE;
CREATE TABLE category (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS image CASCADE;
CREATE TABLE image (
	id BIGSERIAL PRIMARY KEY,
	path VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR (50) NOT NULL,
	price INTEGER,
	description VARCHAR (250) NOT NULL,
	category_id BIGINT REFERENCES category(id),
	image_id BIGINT REFERENCES image(id)
);

DROP TABLE IF EXISTS orders CASCADE;
CREATE TABLE orders (
	id BIGSERIAL PRIMARY KEY,
	user_id BIGINT REFERENCES users(id),
	total_price INTEGER
);

DROP TABLE IF EXISTS order_line CASCADE;
CREATE TABLE order_line (
	id BIGSERIAL PRIMARY KEY,
	order_id BIGINT REFERENCES orders(id),
	product_id BIGINT REFERENCES product(id),
	amount INTEGER
);

DROP TABLE IF EXISTS order_order_lines CASCADE;
CREATE TABLE order_order_lines (
	id BIGSERIAL PRIMARY KEY,
	order_id BIGINT REFERENCES orders(id),
	order_line_id BIGINT REFERENCES order_line(id)
);