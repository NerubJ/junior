create sequence hibernate_sequence start 1 increment 1

create table number (
  id int8 not null,
  max_palindrome numeric(38, 2),
  min_palindrome numeric(38, 2),
  number numeric(38, 2),
  number_of_palindromes int4,
  primary key (id)
);