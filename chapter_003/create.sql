create database example1;

--tables creation
create table role (
    id serial primary key,
    role_name varchar(2000)
);

create table rules (
    id serial primary key,
    rule varchar(2000)
);

create table roles_rules (
    id serial primary key,
    roles_id int references role(id),
    rules_id int references role(id)
);

create table users (
    id serial primary key,
    name varchar(2000),
    passworz int,
    role_id int references role(id)
);

create table category (
    id serial primary key,
    category_name varchar(2000)
);

create table state (
    id serial primary key,
    state varchar(2000)
);

create table item (
    id serial primary key,
    item_name varchar(2000),
    user_id int references users(id),
    category_id int references category(id),
    state_id int references state(id)
);

create table comments (
    id serial primary key,
    comment varchar(2000),
    item_id int references item(id)
);

create table attachs (
    id serial primary key,
    item_id int references item(id)
)

--inserts
insert into role(role_name) values
    ('admin'),
    ('user1'),
    ('user2');

insert into users(name, passworz, role_id)	values
    ('edmund', 123, 2),
    ('siegfried', 123, 3);

insert into category(category_name) values
    ('important'),
    ('unimportant');

insert into state(state) values
    ('activ'),
    ('inactiv');

insert into item(item_name, user_id, category_id, state_id) values
    ('item1', 2, 1, 2),
    ('item2', 1, 1, 1);