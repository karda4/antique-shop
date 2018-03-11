#!/bin/bash
sudo -u postgres psql
\i src/main/resources/db/create_db_and_user.sql
