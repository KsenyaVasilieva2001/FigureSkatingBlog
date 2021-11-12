create table coach
(
    id            serial
        constraint coach_pkey
            primary key,
    id_speciality integer      not null
        constraint coach_speciality_id_fk
            references speciality
            on update cascade on delete restrict,
    name          varchar(100) not null,
    rating        real      default 0,
    content       text         not null,
    created_at    timestamp default CURRENT_TIMESTAMP,
    photo_url     varchar   default 'http://placehold.it/250x250'::character varying,
    url           varchar      not null
);

alter table coach
    owner to postgres;

create index coach_name_index
    on coach (name);




INSERT INTO public.coach (id, id_speciality, name, rating, content, created_at, photo_url, url) VALUES (1, 1, 'Трусова Регина Викторовна', 0, 'Руководитель и основатель КФК "Free Skating. Мастер спорта по фигурному катанию (одиночное и синхронное катание, 2007 г.).
Бронзовый призёр соревнований по синхронному катанию всемирной Универсиады (г. Харбин, Китай, 2009 г.)
Неоднократный серебряный призёр чемпионата России по синхронному катанию.
Занимается фигурным катанием более 30 лет.', '2021-11-03 13:11:08.023843', 'https://sun9-48.userapi.com/impg/cSJlN0patF7mIfJwjBq0rZ4qcPfr04MzOeOsBA/m7nkd4TTmrY.jpg?size=750x1334&quality=96&sign=4d306b52f0775e96c1d0d19fe19ae843&type=album', '/coach-list/Trusova-Regina-Victorovna');
INSERT INTO public.coach (id, id_speciality, name, rating, content, created_at, photo_url, url) VALUES (2, 2, 'Гильманова Айгуль Баграмовна', 0, 'Кандидат в мастера спорта по синхронному фигурному катанию (2016 г.). Занимается фигурным катанием более 10 лет, действующий спортсмен', '2021-11-03 13:11:08.052606', 'https://cdn.profi.ru/pfiles/GilmanovaAB/a4539ad7461b71d05f4ab67d47cd1118-profi_a34-240.jpg', '/coach-list/Gilmanova-Aigul-Bagramovna');
INSERT INTO public.coach (id, id_speciality, name, rating, content, created_at, photo_url, url) VALUES (3, 4, 'Рублев Степан Михайлович', 0, 'Кандидат в мастера спорта по танцам на льду (2016 г.). Действующий спортсмен', '2021-11-03 13:11:08.098400', 'https://sun9-57.userapi.com/impf/5vsnDmVXy37xTt0a-6Q-1nqTUBDxUffRHVB4gw/fFbqiO_YUN0.jpg?size=453x566&quality=96&sign=bf7606b1a2fd782d1bdee70fce16fc0f&type=album', '/coach-list/Rublev-Stepan-Michalovich');
INSERT INTO public.coach (id, id_speciality, name, rating, content, created_at, photo_url, url) VALUES (4, 4, 'Люманова Алена Бориосовна', 0, 'Профессиональный преподаватель с многолетним опытом работы с детьми от трёх лет.', '2021-11-03 13:11:08.077066', 'https://placeimg.com/250/250/people?t=1635944716764', '/coach-list/Lumanova-Aliona-Boriosovna');