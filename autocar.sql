use autocar;
create table Sign_up(id_sign int NOT NULL PRIMARY KEY , name varchar(20), Cin varchar(20),Tele integer(20),
Email varchar(30),password varchar(20));

create table log_in(id_log integer, Cin varchar(20),password varchar(20), CONSTRAINT FK_log_in FOREIGN KEY (id_sign)REFERENCES Sign_up(id_sign));

create table destination(id_destination int NOT NULL PRIMARY KEY, name_of_company varchar(20),
 villedepart varchar(30),villedarriver varchar(30),Date_journey date,Num_of_Ticket integer);
 
create table Storage_destination(id_storage int NOT NULL PRIMARY KEY,Company_car_name varchar(40),Route varchar(40),
 depart_time date,arriving_time date,price_in_dh integer,
 CONSTRAINT FK_Storage_destination FOREIGN KEY (id_destination)REFERENCES destination(id_destination));
 
 create table payement(id_payement int NOT NULL PRIMARY KEY, numCard integer(16));
 create table Ticketlost(id_TicketLost int NOT NULL PRIMARY KEY, Cin varchar(20), CONSTRAINT FK_Ticketlost FOREIGN KEY (id_Ticket)REFERENCES destination(id_Ticket));
 create table Ticket(id_Ticket int NOT NULL PRIMARY KEY, CONSTRAINT FK_Ticket FOREIGN KEY (id_destination)REFERENCES destination(id_destination));