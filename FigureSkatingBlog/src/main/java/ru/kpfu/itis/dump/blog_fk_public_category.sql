create table category
(
    id       serial
        constraint category_pkey
            primary key,
    name     varchar(20)       not null,
    url      varchar(20)       not null
        constraint category_url_key
            unique,
    articles integer default 0 not null
);

alter table category
    owner to postgres;

create index category_name_index
    on category (name);





INSERT INTO public.category (id, name, url, articles) VALUES (1, 'Прыжковые элементы', '/jumps', 5);
INSERT INTO public.category (id, name, url, articles) VALUES (2, 'Вращения', '/spins', 5);
INSERT INTO public.category (id, name, url, articles) VALUES (3, 'Скольжение', '/sliding', 2);
INSERT INTO public.category (id, name, url, articles) VALUES (4, 'ОФП', '/ofp', 2);
INSERT INTO public.category (id, name, url, articles) VALUES (5, 'СФП', '/sfp', 5);
INSERT INTO public.category (id, name, url, articles) VALUES (6, 'Хореография', '/choreography', 2);