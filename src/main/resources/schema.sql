create table category (
    id int primary key auto_increment,
    name varchar(255),
    description varchar(255)
);



create table product (
    id int primary key auto_increment,
    name varchar(255),
    description varchar(255),
    foreign key (description) references category(description),
    price double,
    categoryId int
);