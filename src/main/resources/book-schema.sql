drop table if exists Books CASCADE;
CREATE TABLE books(title varchar(255), id integer, price double, stock boolean, PRIMARY KEY (ID));