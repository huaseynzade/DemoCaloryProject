create table exercises
(
    burn_calories double precision,
    category_id   integer
        constraint fksjihwced9d783bvjnvca7f6av
            references exercises_category,
    duration      double precision,
    id            integer generated by default as identity
        primary key,
    equipment     varchar(255),
    instructions  varchar(255),
    name          varchar(255)
);

alter table exercises
    owner to postgres;

