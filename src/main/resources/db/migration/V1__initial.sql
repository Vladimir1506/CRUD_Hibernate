create table regions(
"id" bigserial primary key,
"name" varchar(25)
);
create table users(
"id" bigserial primary key,
"firstname" varchar (56),
"lastname" varchar (56),
"region_id" bigint,
"role" varchar(10)
);
create table posts(
"id" bigserial primary key,
"content" varchar (1000),
"created" timestamp,
"updated" timestamp,
"user_id" bigint
);