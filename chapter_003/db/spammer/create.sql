create database spammer;

create table users (
    id serial primary key,
    name varchar(2000),
    email varchar(2000)
)