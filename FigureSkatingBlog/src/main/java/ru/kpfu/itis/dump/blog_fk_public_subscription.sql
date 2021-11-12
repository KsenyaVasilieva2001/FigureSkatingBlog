
-- auto-generated definition
create table subscription
(
    id           bigint    default nextval('application_id_seq'::regclass) not null
        constraint application_pkey
            primary key,
    student_name varchar(100)                                              not null,
    phone_number varchar(11)                                               not null
        constraint application_phone_number_key
            unique,
    created      timestamp default CURRENT_TIMESTAMP
);

alter table subscription
    owner to postgres;




INSERT INTO public.subscription (id, student_name, phone_number, created) VALUES (8, 'Vasileva Ksenia Sergeevna', '89393365327', '2021-11-12 00:34:39.390851');
INSERT INTO public.subscription (id, student_name, phone_number, created) VALUES (9, 'Natalia Vasileva', '89270951616', '2021-11-12 00:37:15.055720');
