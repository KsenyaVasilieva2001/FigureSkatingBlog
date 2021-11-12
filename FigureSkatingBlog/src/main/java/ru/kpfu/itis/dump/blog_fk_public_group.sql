
create table "group"
(
    id           serial
        constraint group_pk
            primary key,
    group_number integer not null
);

alter table "group"
    owner to postgres;

create unique index group_id_uindex
    on "group" (id);

create unique index group_group_number_uindex
    on "group" (group_number);



INSERT INTO public."group" (id, group_number) VALUES (1, 101);
INSERT INTO public."group" (id, group_number) VALUES (2, 102);