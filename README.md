# SasaCRUDTask

DB config:
create database kontakti;
create user 'Test'@'localhost' IDENTIFIED BY 'root';
grant all privileges on kontakti.* to 'Test'@'localhost';



use kontakti;
CREATE TABLE contacts (
                          ID int(11) not null auto_increment,
                          Ime varchar(45) default null,
                          Prezime varchar(45) default null,
                          Email varchar(45) default null,
                          Broj_telefona varchar(40) default null,
                          Grad varchar(30) default null,
                          Drzava varchar(30) default null,
                          PRIMARY KEY (id)
);

INSERT INTO kontakti.contacts(Ime, Prezime, Email, Broj_telefona, Grad, Drzava)
VALUES ('Mass','Gry','ewfew@gmail.com',019132321,'Zagreb', 'Hrvatska');
