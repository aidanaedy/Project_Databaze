drop table if exists book CASCADE;
CREATE TABLE book( id integer, title varchar(255), price double, stock boolean, PRIMARY KEY (ID));