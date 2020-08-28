--Создать структур данных в базе. Таблицы. Кузов. Двигатель, Коробка передач.
create table Body (
                      id serial primary key,
                      name varchar(50)
);

create table Engine (
                        id serial primary key,
                        name varchar(50)
);

create table Transmission (
                              id serial primary key,
                              name varchar(50)
);

--Создать структуру Машина.
create table Car (
                     id serial primary key,
                     name varchar(50),
                     fk_id_body int references Body(id),
                     fk_id_engine int references Engine(id),
                     fk_id_transmission int references Transmission(id)
);

--Заполнить таблицы через insert.
insert into
    body (name)
values
('Hatchback'),
('SUV');

insert into
    engine (name)
values
('V6'),
('V8');

insert into
    transmission (name)
values
('automatic'),
('manual');

insert into car (name, fk_id_body, fk_id_engine, fk_id_transmission) values
('audi', 2, 1, 1),
('bmw', 1, 1, 1);

-- Вывести список всех машин и все привязанные к ним детали.
select
    c.name car, b.name body, e.name engine, t.name transmission
from
    car c
        left join
    body b on c.fk_id_body = b.id
        left join
    engine e on c.fk_id_engine = e.id
        left join
    transmission t on c.fk_id_transmission = t.id;

--Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
select
    c.name car, b.name body, e.name engine, t.name transmission
from
    car c
        right outer join
    body b on c.fk_id_body = b.id
        right outer join
    engine e on c.fk_id_engine = e.id
        right outer join
    transmission t on c.fk_id_transmission = t.id
where c.name is null;
