# Postgres install

$ sudo apt-get update
$ sudo apt-get install postgresql postgresql-contrib

# Postgres cli access as root user 'postgres'

$ sudo -u postgres psql

# Postgres create DB and user

execute in postgres cli as root user create_db_and_user.sql

# Postgres cli access as created user 'tvoya_yoga'

psql --host=localhost --dbname=antique_shop --username=antique

# Postgres create tables and insert data

execute in postgres cli as db user create_tables.sql