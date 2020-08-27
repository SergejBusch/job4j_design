--1. Написать запрос получение всех продуктов с типом "СЫР"
select * from product left join name on type_id = name.id where name.name = 'СЫР';

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select * from product where name like '%мороженое%';

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select * from product where EXTRACT(MONTH FROM expiried_date) = EXTRACT(MONTH FROM NOW() + interval '1 month');

--4. Написать запрос, который выводит самый дорогой продукт.
select * from product order by price desc limit 1;

--5. Написать запрос, который выводит количество всех продуктов определенного типа.
select
    count(product.id) as колличество,
    name.name
from
    product
join
    name
on
    type_id = name.id
group by
    name.name;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select * from product left join name on type_id = name.id where name.name = 'СЫР' or name.name = 'МОЛОКО';

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
select
    count(product.id) as колличество,
    name.name
from
    product
join
    name
on
    type_id = name.id
group by
    name.name
having
    count(product.id) < 10;

--8. Вывести все продукты и их тип.
select * from product left join name on type_id = name.id;