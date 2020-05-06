CREATE SCHEMA IF NOT EXISTS Warehouse DEFAULT CHARACTER SET utf8;

USE Warehouse;

create table if not exists User (
    id              bigint not null auto_incremen,
    Name            varchar(100) not null
    primary key (id)
);

CREATE TABLE IF NOT EXISTS Products (
    id              bigint not null auto_increment,
    user_id         bigint,
    Name            varchar(100) not null,
    Price           decimal(19,2) not null,
    Category        varchar(50),
    Discount        float not null,
    Description     varchar(300) not null,
    Created         timestamp default current_timestamp(),
    primary key (id),
    foreign key (user_id) references User (id)
)
    auto_increment = 1;