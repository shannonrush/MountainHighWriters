# --- !Ups

CREATE TABLE events (
	id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name varchar(255) NOT NULL,
	date datetime NOT NULL,
	description varchar(255) NOT NULL
);

CREATE TABLE users (
	id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	last varchar(255),
	first varchar(255)
);

CREATE TABLE reservations (
	id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	user_id bigint(20),
	event_id bigint(20)
);

# --- !Downs

DROP TABLE events;
DROP TABLE users;
DROP TABLE reservations;
