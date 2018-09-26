-- sql script for creating tables for VIZOR database schema

	drop database vizor;
	commit;
	Create database vizor;
	use vizor;
	
	create table proceeds(
	id int AUTO_INCREMENT,     
	Name varchar(20),
	Date date,
	Media varchar(20),
	Campaign varchar(20),
	Platform varchar(20),
	Installs decimal(5,0),
    Cost varchar(20),
primary key(id)
	);	
commit;