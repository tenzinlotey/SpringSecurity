Use BankApp;
drop table if exists authorities;
drop table if exists users;

create table authorities(
	id int primary key auto_increment,
	authority varchar(40) not null,
    username varchar(30) not null
    );

create table users(
	id int primary key auto_increment,
    username varchar(20) unique not null,
    email varchar(20) not null,
    password varchar(20) not null,
    enabled int not null
    );
    
