drop table if exists Reservations;

create table Reservations (
	long int auto_increment primary key,
	roomName varchar2(25) not null,
	userName varchar2(25) not null,
	startDate timestamp not null,
	endDate timestamp not null,
	repeatCount int default 0 not null
)