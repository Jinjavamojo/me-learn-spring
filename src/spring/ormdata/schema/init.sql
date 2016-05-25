drop table if exists spittle;
drop table if exists spitter;

create table spitter (
  id bigint,
  username varchar(25) not null,
  password varchar(25) not null,
  fullName varchar(100) not null,
  email varchar(50) not null,
  updateByEmail boolean not null,
  primary key(id)
);

create table spittle (
  id bigint primary key,
  spitter integer not null,
  message varchar(2000) not null,
  postedTime date not null,
  foreign key (spitter) references spitter(id)
);