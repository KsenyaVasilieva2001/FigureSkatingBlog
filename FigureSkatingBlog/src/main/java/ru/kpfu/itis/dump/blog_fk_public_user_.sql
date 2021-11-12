
create table user_
(
    id            bigserial
        constraint user__pkey
            primary key,
    login         varchar(100) not null
        constraint user__login_key
            unique,
    first_name    varchar(30),
    last_name     varchar(30),
    email         varchar(320) not null
        constraint user__email_key
            unique,
    hash_password varchar(100) not null,
    group_id      integer
        constraint user__group_group_number_fk
            references "group" (group_number)
            on update cascade on delete restrict,
    avatar        varchar(255) default 'https://placeimg.com/250/250/people?t=1635946131679'::character varying,
    created_at    timestamp    default CURRENT_TIMESTAMP
);

alter table user_
    owner to postgres;

create index user__last_name_index
    on user_ (last_name);




INSERT INTO public.user_ (id, login, first_name, last_name, email, hash_password, group_id, avatar, created_at) VALUES (1, 'ksekse', 'Ксения', 'Васильева', 'email@mail.com', '3676ttgt6t376c367c736', 101, 'https://placeimg.com/250/250/people?t=1635945916282', '2021-11-03 13:25:59.745868');
INSERT INTO public.user_ (id, login, first_name, last_name, email, hash_password, group_id, avatar, created_at) VALUES (2, 'smirsmir', 'Андрей', 'Смирнов', 'smir@mail.com', '3676ttgt6t376c367c444t', 102, 'https://placeimg.com/250/250/people?t=1635946033999', '2021-11-03 13:27:40.994930');
INSERT INTO public.user_ (id, login, first_name, last_name, email, hash_password, group_id, avatar, created_at) VALUES (3, 'vasvas', 'Наталья', 'Родионова', 'nat@mail.com', '3676ttgt68376c367c736', 102, 'https://placeimg.com/250/250/people?t=1635946131679', '2021-11-03 13:29:25.298555');
INSERT INTO public.user_ (id, login, first_name, last_name, email, hash_password, group_id, avatar, created_at) VALUES (56, 'Natalya', 'Vasileva', 'Natalya', 'nata@mail.ru', './0123456', null, 'https://placeimg.com/250/250/people?t=1635946131679', '2021-11-12 12:53:42.847224');
INSERT INTO public.user_ (id, login, first_name, last_name, email, hash_password, group_id, avatar, created_at) VALUES (57, 'john', 'John', 'john', 'john@mail.ru', './01./01', null, 'https://placeimg.com/250/250/people?t=1635946131679', '2021-11-12 13:11:55.542073');
INSERT INTO public.user_ (id, login, first_name, last_name, email, hash_password, group_id, avatar, created_at) VALUES (53, 'Tom', null, null, 'tom@mail.ru', 'asdfghjkl;''', null, 'https://placeimg.com/250/250/people?t=1635946131679', '2021-11-11 21:58:30.031593');