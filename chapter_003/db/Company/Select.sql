-- names of all persons that are NOT in the company with id = 5
select
    p.name as person_name
from person p
         left join company c on c.id = p.company_id
where c.id != 5;


-- company name for each person
select
    p.name as person_name,
    c.name as company_name
from person p
         left join company c on c.id = p.company_id;


-- Select the name of the company with the maximum number of persons + number of persons in this company
select
    c.name as company_name,
    count(p.name)
from company c
         left join person p on p.company_id = c.id
group by c.name
order by count(p.name) desc
limit 1
