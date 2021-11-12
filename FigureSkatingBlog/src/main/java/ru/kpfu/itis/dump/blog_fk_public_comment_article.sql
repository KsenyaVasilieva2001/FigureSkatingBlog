
create table comment_article
(
    id         bigserial
        constraint comment_pkey
            primary key,
    id_user    bigint not null
        constraint comment_user__id_fk
            references user_
            on update cascade on delete restrict,
    id_article bigint not null
        constraint comment_article_id_fk
            references article
            on update restrict on delete cascade,
    content    text   not null,
    created    timestamp default CURRENT_TIMESTAMP
);

alter table comment_article
    owner to postgres;

create index comment_id_article_index
    on comment_article (id_article);


INSERT INTO public.comment_article (id, id_user, id_article, content, created) VALUES (1, 1, 1, 'Очень интересно! Мне все понравилось', '2021-11-03 13:44:42.463896');
INSERT INTO public.comment_article (id, id_user, id_article, content, created) VALUES (2, 3, 1, 'Супер', '2021-11-03 13:44:42.547664');
INSERT INTO public.comment_article (id, id_user, id_article, content, created) VALUES (3, 2, 1, 'Cool!', '2021-11-08 17:53:08.825239');
INSERT INTO public.comment_article (id, id_user, id_article, content, created) VALUES (4, 1, 1, 'Awesome!', '2021-11-08 17:53:08.867312');
INSERT INTO public.comment_article (id, id_user, id_article, content, created) VALUES (5, 2, 1, 'Perfect!', '2021-11-08 17:53:08.894196');
INSERT INTO public.comment_article (id, id_user, id_article, content, created) VALUES (6, 3, 1, 'Not bad!', '2021-11-08 17:53:08.927485');
INSERT INTO public.comment_article (id, id_user, id_article, content, created) VALUES (7, 3, 1, 'So so...!', '2021-11-08 17:53:08.984173');
INSERT INTO public.comment_article (id, id_user, id_article, content, created) VALUES (8, 2, 1, 'Well done!', '2021-11-08 17:53:09.017148');
INSERT INTO public.comment_article (id, id_user, id_article, content, created) VALUES (9, 1, 1, 'Thank you!', '2021-11-08 17:53:09.084025');