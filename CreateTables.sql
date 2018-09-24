-- sql script for creating tables for SOCCER database schema

	drop database soccer;
	commit;
	Create database soccer;
	use soccer;
	
	create table country(
	country_name varchar(20),
	population decimal(10,2) default 10.5, -- considered that default population of a country will be 10500 people
	no_of_worldcup_won int default 0, -- considered that when a new country added it will have zero world cups won.
	manager varchar(20),
	primary key(country_name)
	);

	create table players(
	player_id int,
	name varchar(40),
	fname varchar(20),
	lname varchar(35),
	dob date,
	player_country varchar(20),
	height_cms int,
	club varchar(30),
	position varchar(10),
	caps_for_country int,
	is_captain char, -- since boolean datatype does not exist in mysql taking a character F indicating FALSE and T indicating TRUE
	primary key(player_id),
	constraint fk_players_country -- players(referencing) country(referenced)
	foreign key(player_country) references country(country_name) on delete cascade
	);

	create table match_results(
	match_id int,
	date_of_match date,
	start_time_of_match time,
	team1 varchar(20) not null, -- in a match to happen both teams should be present
	team2 varchar(20) not null, -- in a match to happen both teams should be present
	team1_score int,
	team2_score int,
	stadium_name varchar(35) not null, -- a stadium is mandatory to make a match happen
	host_city varchar(20) not null, --  a stadium will always be part of some city
	primary key(match_id),
	constraint fk_matchresults_country_a -- matchResults(reerencing) country(referenced)
	foreign key(team1) 
	references country(country_name) on delete cascade,
	constraint fk_matchresults_country_b -- matchResults(reerencing) country(referenced)
	foreign key(team2) references country(country_name) on delete cascade
	);

	create table player_card(
	player_id int,
	yellow_cards int default 0, --  considered that a new player will always have 0 cards
	red_cards int default 0, --  considered that a new player will always have 0 cards
	primary key(player_id),
	constraint fk_playercards_players -- player_card(referencing) players(referenced)
	foreign key(player_id) references players(player_id) on delete cascade
	);

	create table player_assists_goals(
	player_id int,
	no_of_matches int default 0, --  must be 0 for a new player when added
	goals int default 0, --  must be 0 for a new player when added
	assists int default 0, --  must be 0 for a new player when added
	minutes_played int default 0, --  must be 0 for a new player when added
	primary key(player_id),
	constraint fk_playerassistsgoals_players -- player_assists_goals(referencing) player(referenced)
	foreign key(player_id) references players(player_id)
	);

commit;