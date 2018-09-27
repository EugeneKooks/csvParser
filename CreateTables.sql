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
commit;