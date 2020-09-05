create database bookdb;
use bookdb;
create table author(
    idAuthor int primary key,
    name varchar(100)
);
create table book(
    idBook int primary key,
    idAuthor int,
    title varchar(100),
    year int
);
alter table book add foreign key (idAuthor) references author (idAuthor);
-- example data
insert into author (idAuthor, name) values (1, 'John Authorman');
insert into author (idAuthor, name) values (2, 'Charles Writer');
insert into author (idAuthor, name) values (3, 'Steven Penman');
insert into book (idBook, idAuthor, title, year) values (1, 1, 'The Modern Cook', 1993);
insert into book (idBook, idAuthor, title, year) values (2, 1, 'The Incomprehensible Guide To Snoring', 1999);
insert into book (idBook, idAuthor, title, year) values (3, 2, 'Java Primitives: Object Oriented Unless It Isn\'t', 1993);
insert into book (idBook, idAuthor, title, year) values (4, 2, 'Web Development With Lisp', 1996);
insert into book (idBook, idAuthor, title, year) values (5, 3, 'Git Conflicts And How Not To Go Crazy Over Them', 1999);
insert into book (idBook, idAuthor, title, year) values (6, 3, 'Binary Files On Git - And Other Terrible Ideas', 1993);
create user 'app' identified by 'd0lphin';
grant select on *.* to 'app';
