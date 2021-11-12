
-- auto-generated definition
create table speciality
(
    id   integer     not null
        constraint speciality_pkey
            primary key,
    name varchar(20) not null
);

alter table speciality
    owner to postgres;

create index speciality_name_index
    on speciality (name);


INSERT INTO public.speciality (id, name) VALUES (1, 'Cтарший тренер');
INSERT INTO public.speciality (id, name) VALUES (2, 'Тренер');
INSERT INTO public.speciality (id, name) VALUES (3, 'Хореограф');
INSERT INTO public.speciality (id, name) VALUES (4, 'Тренер ОФП и СФП');