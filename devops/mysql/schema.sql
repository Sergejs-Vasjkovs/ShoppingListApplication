CREATE SCHEMA IF NOT EXISTS Warehouse DEFAULT CHARACTER SET utf8;

USE Warehouse;

CREATE TABLE IF NOT EXISTS Products (
    ID              bigint not null auto_increment,
    Name            varchar(100) not null,
    Price           decimal(19,2) not null,
    Category        varchar(50),
    Discount        float not null,
    Description     varchar(300) not null,
    Created         timestamp default current_timestamp(),
                    primary key (ID)
)
    auto_increment = 1;