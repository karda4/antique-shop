DROP DATABASE IF EXISTS antique_shop;
DROP USER IF EXISTS antique;
CREATE DATABASE antique_shop;
CREATE USER antique WITH PASSWORD 'euqitna';
GRANT ALL ON DATABASE antique_shop TO antique;
