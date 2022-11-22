use ticketautocar;
create table client 
(id_client int PRIMARY KEY AUTO_INCREMENT ,
 name varchar(20) not null, 
 Cin varchar(20) unique not null ,
 Tele integer(20) ,
Email varchar(60),
 password varchar(30));


 create table travel 
 (id_travel int PRIMARY KEY AUTO_INCREMENT,
 company_name varchar(30) not null ,
  villedepart varchar(30) NOT null,
  villedarriver varchar(30) not null,
  depart_time date not null,
  arriving_time date,
  price integer not null,
  number_places int not null check (number_places >= 0),
  date_travel date not null);



 create table reservation 
 (id_reservation int PRIMARY KEY AUTO_INCREMENT,
  company_name varchar(30) not null ,
  villedepart varchar(30) NOT null,
  villedarriver varchar(30) not null,
  depart_time date not null,
  arriving_time date,
  price integer not null,
  number_places int not null check (number_places >= 0),
  date_travel date not null,
  id_travel int not null,
  client_id int not null,
  FOREIGN KEY (client_id) REFERENCES client(id_client),
  FOREIGN KEY (id_travel) REFERENCES travel(id_travel));



 create table paiement
 (id_paiement int PRIMARY KEY AUTO_INCREMENT,
  numCard integer(16) not null unique,
  codepin integer(4) not null);