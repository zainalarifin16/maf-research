CREATE TABLE PEOPLE
(
 PERID NUMBER(6) NOT NULL,
 FIRSTNAME VARCHAR(20) NOT NULL, 
 LASTNAME VARCHAR(25) NOT NULL, 
 EMAIL VARCHAR(25), 
 PHONE VARCHAR(20), 
 BIRTH_DATE DATE, 
 ADDRESS VARCHAR(50), 
 CITY VARCHAR(30), 
 STATE VARCHAR(10),
CONSTRAINT PEOPLE_PK PRIMARY KEY(PERID)
);

COMMIT;

REM INSERTING into PEOPLE
 
Insert into PEOPLE (PERID,FIRSTNAME,LASTNAME,EMAIL,PHONE,BIRTH_DATE,ADDRESS,CITY,STATE) values (1, "Bill", "Baily", "bill@home.com", "6503456789", '1987-09-17', "100 Main Street", "San Jose", "CA");
Insert into PEOPLE (PERID,FIRSTNAME,LASTNAME,EMAIL,PHONE,BIRTH_DATE,ADDRESS,CITY,STATE) values (2, "Bob", "Billings", "bob@home.com", "6503456789", '1977-08-15', "200 First Street", "San Francisco", "CA");
Insert into PEOPLE (PERID,FIRSTNAME,LASTNAME,EMAIL,PHONE,BIRTH_DATE,ADDRESS,CITY,STATE) values (3, "Fred", "Flintstone", "fred@home.com", "6503456789", '1984-04-14', "300 Third Ave", "Redwood City", "CA");
Insert into PEOPLE (PERID,FIRSTNAME,LASTNAME,EMAIL,PHONE,BIRTH_DATE,ADDRESS,CITY,STATE) values (4, "Harold", "Horshak", "bruce@home.com", "6503456789", '1976-06-16', "400 Fifth Street", "Belmont", "CA");
Insert into PEOPLE (PERID,FIRSTNAME,LASTNAME,EMAIL,PHONE,BIRTH_DATE,ADDRESS,CITY,STATE) values (5, "Bruce", "Johnson", "bruce@home.com", "6503456789", '1991-01-11', "500 Sixth Street", "Millbrae", "CA");
Insert into PEOPLE (PERID,FIRSTNAME,LASTNAME,EMAIL,PHONE,BIRTH_DATE,ADDRESS,CITY,STATE) values (6, "Roger", "Robson", "roger@home.com", "6503456789", '1982-02-21', "600 Seventh Ave", "Livermore", "CA");
Insert into PEOPLE (PERID,FIRSTNAME,LASTNAME,EMAIL,PHONE,BIRTH_DATE,ADDRESS,CITY,STATE) values (7, "Barny", "Rubble", "barney@home.com", "6503456789", '1983-03-31', "700 Eigth Street", "San Jose", "CA");
Insert into PEOPLE (PERID,FIRSTNAME,LASTNAME,EMAIL,PHONE,BIRTH_DATE,ADDRESS,CITY,STATE) values (8, "Slim", "Shady", "slim@home.com", "6503456789", '1981-11-11', "800 Main Street", "Redwood City", "CA");
Insert into PEOPLE (PERID,FIRSTNAME,LASTNAME,EMAIL,PHONE,BIRTH_DATE,ADDRESS,CITY,STATE) values (9, "Jane", "Smith", "jane@home.com", "6501234567", '1993-09-17', "900 First Street", "Belmont", "CA");
Insert into PEOPLE (PERID,FIRSTNAME,LASTNAME,EMAIL,PHONE,BIRTH_DATE,ADDRESS,CITY,STATE) values (10, "John", "Smith", "john@home.com", "6503456789", '1988-08-18', "120 Second Ave", "Vallejo", "CA");
Insert into PEOPLE (PERID,FIRSTNAME,LASTNAME,EMAIL,PHONE,BIRTH_DATE,ADDRESS,CITY,STATE) values (11, "Ziggy", "Zaggy", "ziggy@home.com", "6503456789", '2001-03-11', "250 Third Street", "Dublin", "CA");
Insert into PEOPLE (PERID,FIRSTNAME,LASTNAME,EMAIL,PHONE,BIRTH_DATE,ADDRESS,CITY,STATE) values (12, "Zane", "Zero", "zane@home.com", "6503456789", '1987-06-16', "350 Fourth Street", "Pleasanton", "CA");

COMMIT;

