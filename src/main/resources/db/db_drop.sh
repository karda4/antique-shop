#!/bin/bash
sudo -u postgres psql < ./create_db_and_user.sql;
\q
psql "host=localhost dbname=antique_shop user=antique password=euqitna" < ./create_tables.sql;

