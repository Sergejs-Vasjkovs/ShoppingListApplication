CREATE SCHEMA IF NOT EXISTS warehouse DEFAULT CHARACTER SET utf8;

USE warehouse;

create table if not exists user (
    id              bigint not null auto_incremen,
    name            varchar(100) not null
    primary key (id)
);

CREATE TABLE IF NOT EXISTS products (
    id              bigint not null auto_increment,
    user_id         bigint,
    name            varchar(100) not null,
    price           decimal(19,2) not null,
    category        varchar(50),
    discount        float not null,
    description     varchar(300) not null,
    created         timestamp default current_timestamp(),
    primary key (id),
    foreign key (user_id) references user (id)
)
    auto_increment = 1;