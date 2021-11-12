create table "comment_coaches "
(
    id           bigint    default nextval('comment_coaches_id_seq'::regclass) not null
        constraint comment_coaches_pk
            primary key,
    id_coach     bigint                                                        not null
        constraint "comment_coaches _coach_id_fk"
            references coach
            on update cascade on delete restrict,
    content      text,
    created_at   timestamp default CURRENT_TIMESTAMP                           not null,
    stars_number integer                                                       not null
);

alter table "comment_coaches "
    owner to postgres;

create unique index comment_coaches_id_uindex
    on "comment_coaches " (id);

