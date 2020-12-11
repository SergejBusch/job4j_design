-- 1. Есть таблица встреч(id, name), есть таблица юзеров(id, name).
-- Нужно доработать модель базы данных, так чтобы пользователи могли учавствовать во встречах.
-- У каждого участника встречи может быть разный статус участия - например подтвердил участие, отклонил.
create type yes_or_no as enum ('yes', 'no');

create table appointments_users (
    id serial primary key,
    appointment_id int references example1.public.appointments(id),
    user_id int references example1.public.user(id),
    confirmed yes_or_no not null
);

-- 2. Нужно написать запрос, который получит список всех заявок и количество подтвердивших участников.

-- если нужно показать все заявки
select
    a.name, au.confirmed from example1.public.appointments a
left join (select aa.name, count(auu.confirmed) confirmed from example1.public.appointments aa
        left join appointments_users auu on aa.id = auu.appointment_id
        where auu.confirmed = 'yes'
        group by
             name) au
  on a.name = au.name;

--если нужно показать только те заявки где есть подтверждение
select a.name, count(au.confirmed) from example1.public.appointments a
left join appointments_users au
    on a.id = au.appointment_id
where au.confirmed = 'yes'
group by a.name;


-- 3. Нужно получить все совещания, где не было ни одной заявки на посещения
select a2.name from example1.public.appointments a2
    except
select a.name from example1.public.appointments a
                       inner join appointments_users au on a.id = au.appointment_id
where confirmed = 'yes'
group by a.name