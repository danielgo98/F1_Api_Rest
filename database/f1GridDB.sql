create database F1GridDB;
use F1GridDB;

create table DRIVERS(
ID int primary key auto_increment,
FIRST_NAME varchar(56),
LAST_NAME varchar(56),
NUMBER int,
AGE int,
BIRTH_DATE date,
NACIONALITY varchar(80),
ROLE  varchar(78)
);

create table TEAMS(
ID int primary key auto_increment,
NAME varchar(58),
ENGINE varchar(40)
);

alter table DRIVERS
add column ID_TEAM int null after ROLE;

alter table DRIVERS 
add constraint FK_DRIVERS_TEAMS foreign key(ID_TEAM) references TEAMS(ID);


-- INSERTS A LAS TABLAS
-- INSERTS EN LA TABLA TEAMS
INSERT INTO TEAMS (NAME, ENGINE) values ('Alfa Romeo', 'Ferrari');
INSERT INTO TEAMS (NAME, ENGINE) values ('Alpine', 'Renault');
INSERT INTO TEAMS (NAME, ENGINE) values ('Alpha Tauri', 'Honda');
INSERT INTO TEAMS (NAME, ENGINE) values ('Aston Martin', 'Mercedes');
INSERT INTO TEAMS (NAME, ENGINE) values ('Ferrari', 'Ferrari');
INSERT INTO TEAMS (NAME, ENGINE) values ('Haas', 'Ferrari');
INSERT INTO TEAMS (NAME, ENGINE) values ('Mclaren', 'Mercedes');
INSERT INTO TEAMS (NAME, ENGINE) values ('Mercedes', 'Mercedes');
INSERT INTO TEAMS (NAME, ENGINE) values ('Red Bull', 'Honda');
INSERT INTO TEAMS (NAME, ENGINE) values ('Williams', 'Mercedes');

-- INSERTS EN LA TABLA DRIVERS
INSERT INTO DRIVERS (FIRST_NAME, LAST_NAME, NUMBER, AGE, BIRTH_DATE, NACIONALITY, ROLE, ID_TEAM) values ('Valtteri', 'Bottas', 77, 33, '1989-08-28', 'Finnish', 'FIRST_DRIVER', 1);
INSERT INTO DRIVERS (FIRST_NAME, LAST_NAME, NUMBER, AGE, BIRTH_DATE, NACIONALITY, ROLE, ID_TEAM) values ('Guanyu', 'Zhou', 24, 24, '1999-05-30', 'Chinese', 'SECOND_DRIVER', 1);
INSERT INTO DRIVERS (FIRST_NAME, LAST_NAME, NUMBER, AGE, BIRTH_DATE, NACIONALITY, ROLE, ID_TEAM) values ('Pierre', 'Gasly', 10, 27, '1996-02-7', 'French', 'FIRST_DRIVER', 2);
INSERT INTO DRIVERS (FIRST_NAME, LAST_NAME, NUMBER, AGE, BIRTH_DATE, NACIONALITY, ROLE, ID_TEAM) values ('Esteban', 'Ocon', 31, 25, '1996-09-17', 'French', 'SECOND_DRIVER', 2);
INSERT INTO DRIVERS (FIRST_NAME, LAST_NAME, NUMBER, AGE, BIRTH_DATE, NACIONALITY, ROLE, ID_TEAM) values ('Daniel', 'Ricciardo', 3, 34, '1989-07-1', 'Australian', 'FIRST_DRIVER', 3);
INSERT INTO DRIVERS (FIRST_NAME, LAST_NAME, NUMBER, AGE, BIRTH_DATE, NACIONALITY, ROLE, ID_TEAM) values ('Yuki', 'Tsunoda', 22, 23, '2000-05-11', 'Japanese', 'SECOND_DRIVER', 3);
INSERT INTO DRIVERS (FIRST_NAME, LAST_NAME, NUMBER, AGE, BIRTH_DATE, NACIONALITY, ROLE, ID_TEAM) values ('Fernando', 'Alonso', 14, 42, '1981-07-29', 'Spanish', 'FIRST_DRIVER', 4);
INSERT INTO DRIVERS (FIRST_NAME, LAST_NAME, NUMBER, AGE, BIRTH_DATE, NACIONALITY, ROLE, ID_TEAM) values ('Lance', 'Stroll', 18, 24, '1998-10-29', 'Canadian', 'SECOND_DRIVER', 4);
INSERT INTO DRIVERS (FIRST_NAME, LAST_NAME, NUMBER, AGE, BIRTH_DATE, NACIONALITY, ROLE, ID_TEAM) values ('Charles', 'Leclerc', 16, 25, '1997-10-16', 'Monegasque', 'FIRST_DRIVER', 5);
INSERT INTO DRIVERS (FIRST_NAME, LAST_NAME, NUMBER, AGE, BIRTH_DATE, NACIONALITY, ROLE, ID_TEAM) values ('Carlos', 'Sainz', 55, 28, '1994-09-1', 'Spanish', 'SECOND_DRIVER', 5);
INSERT INTO DRIVERS (FIRST_NAME, LAST_NAME, NUMBER, AGE, BIRTH_DATE, NACIONALITY, ROLE, ID_TEAM) values ('Kevin', 'Magnussen', 20, 30, '1992-10-5', 'Danish', 'FIRST_DRIVER', 6);
INSERT INTO DRIVERS (FIRST_NAME, LAST_NAME, NUMBER, AGE, BIRTH_DATE, NACIONALITY, ROLE, ID_TEAM) values ('Nico', 'Hulkenberg', 27, 35, '1987-08-19', 'German', 'SECOND_DRIVER', 6);
INSERT INTO DRIVERS (FIRST_NAME, LAST_NAME, NUMBER, AGE, BIRTH_DATE, NACIONALITY, ROLE, ID_TEAM) values ('Lando', 'Norris', 4, 23, '1999-11-13', 'British', 'FIRST_DRIVER', 7);
INSERT INTO DRIVERS (FIRST_NAME, LAST_NAME, NUMBER, AGE, BIRTH_DATE, NACIONALITY, ROLE, ID_TEAM) values ('Oscar', 'Piastri', 81, 22, '2001-04-6', 'Australian', 'SECOND_DRIVER', 7);
INSERT INTO DRIVERS (FIRST_NAME, LAST_NAME, NUMBER, AGE, BIRTH_DATE, NACIONALITY, ROLE, ID_TEAM) values ('Lewis', 'Hamilton', 44, 38, '1985-01-7', 'British', 'FIRST_DRIVER', 8);
INSERT INTO DRIVERS (FIRST_NAME, LAST_NAME, NUMBER, AGE, BIRTH_DATE, NACIONALITY, ROLE, ID_TEAM) values ('George', 'Russell', 63, 25, '1998-02-15', 'British', 'SECOND_DRIVER', 8);
INSERT INTO DRIVERS (FIRST_NAME, LAST_NAME, NUMBER, AGE, BIRTH_DATE, NACIONALITY, ROLE, ID_TEAM) values ('Max', 'Verstappen', 1, 25, '1997-09-30', 'Dutch', 'FIRST_DRIVER', 9);
INSERT INTO DRIVERS (FIRST_NAME, LAST_NAME, NUMBER, AGE, BIRTH_DATE, NACIONALITY, ROLE, ID_TEAM) values ('Sergio', 'Perez', 11, 33, '1990-01-26', 'Mexican', 'SECOND_DRIVER', 9);
INSERT INTO DRIVERS (FIRST_NAME, LAST_NAME, NUMBER, AGE, BIRTH_DATE, NACIONALITY, ROLE, ID_TEAM) values ('Logan', 'Sergeant', 2, 22, '2000-12-31', 'American', 'FIRST_DRIVER', 10);
INSERT INTO DRIVERS (FIRST_NAME, LAST_NAME, NUMBER, AGE, BIRTH_DATE, NACIONALITY, ROLE, ID_TEAM) values ('Alexander', 'ALbon', 23, 27, '1996-03-23', 'Thai', 'SECOND_DRIVER', 10);