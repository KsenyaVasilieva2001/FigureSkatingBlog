
-- auto-generated definition
create table user_uuid
(
    id      bigserial
        constraint user_uuid_pk
            primary key,
    uuid    uuid   not null,
    user_id bigint not null
        constraint user_uuid_user__id_fk
            references user_
            on update cascade on delete cascade
);

alter table user_uuid
    owner to postgres;

create unique index user_uuid_id_uindex
    on user_uuid (id);

create unique index user_uuid_uuid_uindex
    on user_uuid (uuid);



INSERT INTO public.user_uuid (id, uuid, user_id) VALUES (73, '7c09bb46-9051-49ee-9f33-3673a3c882e0', 56);
INSERT INTO public.user_uuid (id, uuid, user_id) VALUES (74, '087d05d6-e1e3-40db-b568-e8a2584acff3', 56);
INSERT INTO public.user_uuid (id, uuid, user_id) VALUES (75, '2a5ff3a8-5804-4d41-8428-41184096ad77', 56);
INSERT INTO public.user_uuid (id, uuid, user_id) VALUES (76, '7af3d0d9-935b-4d0c-991d-d26efcfeed42', 56);
INSERT INTO public.user_uuid (id, uuid, user_id) VALUES (77, '2c42c599-a9bd-46d5-835f-617eb97d7b2d', 56);
INSERT INTO public.user_uuid (id, uuid, user_id) VALUES (78, 'a4e905d5-00b9-4aa1-9e1c-bd212cd6f01b', 56);
INSERT INTO public.user_uuid (id, uuid, user_id) VALUES (79, '02646ce8-4656-486d-95eb-2eb9f9320e43', 56);
INSERT INTO public.user_uuid (id, uuid, user_id) VALUES (80, '620e914a-8cf7-48c3-a93b-5f8a8929c7c3', 56);
INSERT INTO public.user_uuid (id, uuid, user_id) VALUES (81, '9bbb9bc0-ab25-456c-8ead-12ab28da3d15', 56);
INSERT INTO public.user_uuid (id, uuid, user_id) VALUES (82, '20e9aee7-fef8-47ec-a4a8-134084b605e3', 57);
INSERT INTO public.user_uuid (id, uuid, user_id) VALUES (83, '77abbf03-1940-4bc4-a9be-aa6b43f9b904', 56);