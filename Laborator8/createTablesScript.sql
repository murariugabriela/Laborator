drop table movies_genres;
drop table  movies;
drop table genres;
drop table actors;
drop table directors;
Create table movies(
	movie_id serial primary key,
	title varchar(300),
	release_date timestamp,
	duration real,
	score real
);
create table genres(
	genre_id serial primary key,
	name varchar(40) unique
);
create table movies_genres(
	movie_id int,
	genre_id int,
	foreign key (movie_id) references movies(movie_id),
	foreign key (genre_id) references genres(genre_id)
);
create table actors(
	actor_id serial primary key,
	actor_name varchar(300),
	character_played_name varchar(300),
	movie_id integer,
	foreign key (movie_id) references movies(movie_id)
);
create table directors(
	director_id serial primary key,
	director_name varchar(300),
	movie_id integer,
	foreign key (movie_id) references movies(movie_id)
);