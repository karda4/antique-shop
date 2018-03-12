#!/bin/bash
psql "host=localhost dbname=antique_shop user=antique password=euqitna" < ./populate_tables.sql
