create database authentication;

create table user(
name varchar(100),
email varchar(100),
password varchar(100)
);

create table login_attempt(
email varchar(100),
success boolean,
created_at datetime
);