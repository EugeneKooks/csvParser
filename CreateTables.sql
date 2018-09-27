-- sql script for creating tables for VIZOR database schema

	drop database vizor;
	commit;
	Create database vizor;
	use vizor;
	
	create table proceeds(
	id int AUTO_INCREMENT,	
	name varchar(200),
	date varchar(200),
	media varchar(200),
	campaign varchar(200),
	platform varchar(200),
	installs varchar(200),
    cost varchar(200),
    primary key(id)
	);
	
	create table match_results(
	id int AUTO_INCREMENT,
	match_id int,
	date_of_match date,
	start_time_of_match time,
	team1 varchar(20) not null, -- in a match to happen both teams should be present
	team2 varchar(20) not null, -- in a match to happen both teams should be present
	team1_score int,
	team2_score int,
	stadium_name varchar(35) not null, -- a stadium is mandatory to make a match happen
	host_city varchar(20) not null, --  a stadium will always be part of some city
	primary key(id)	
	);

commit;