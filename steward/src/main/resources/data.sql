insert into user(name, username, password, rol)
values ('Adrianne Dobyns Lopez', 'dobyns', 'dobyns123', 1);

insert into user(name, username, password, rol)
values ('Alfonso Rodriguez Kiloptio', 'alfj1011', 'a', 0);

insert into user(name, username, password, rol)
values ('Angela Vickrey Fernandez', 'vickrey', 'vickrey123', 0);

insert into user(name, username, password, rol)
values ('Becki Mclemore Gomez', 'mclemore', 'mclemore123', 1);

insert into user(name, username, password, rol)
values ('Deeann Dearborn Navarro', 'dearborn', 'dearborn123', 1);

insert into user(name, username, password, rol)
values ('Elvis Mumme Casado', 'mumme', 'mumme123', 0);

insert into user(name, username, password, rol)
values ('Francisco Harkey Garcia', 'garcia', 'garcia123', 0);

insert into user(name, username, password, rol)
values ('Isabel López García', 'isabel123', 'pass4', 1);

insert into user(name, username, password, rol)
values ('Jennifer Maestre Serena', 'jorge123', 'pass2', 0);

insert into user(name, username, password, rol)
values ('Juan Pedro Rodriguez Kiloptio', 'bjungp45', 'b', 1);

insert into user(name, username, password, rol)
values ('Lavern Sturman Jover', 'sturman', 'sturman123', 0);

insert into user(name, username, password, rol)
values ('Lidon Kilkenny Marti', 'kilkenny', 'kilkenny123', 0);

insert into user(name, username, password, rol)
values ('Magdalene Lafond Casal', 'lafond', 'lafond123', 1);

insert into user(name, username, password, rol)
values ('Margarito Flach Sanchez', 'flach', 'flach123', 1);

insert into user(name, username, password, rol)
values ('Maria Alonso Martinez', 'mar123', 'pass5', 0);

insert into user(name, username, password, rol)
values ('Monroe Turcios Almarza', 'turcios', 'turcios123', 0);

insert into user(name, username, password, rol)
values ('Nannie Trowell Regueira', 'trowell', 'trowell123', 1);

insert into user(name, username, password, rol)
values ('Natalie Fowles Luna', 'fowles', 'fowles123', 1);

insert into user(name, username, password, rol)
values ('Paula Juan Campello', 'pablo123', 'pass3', 0);

insert into user(name, username, password, rol)
values ('Roselle Visconti Greyjoy', 'visconti', 'visconti123', 1);

insert into user(name, username, password, rol)
values ('Samuel Navarro García', 'samuelnaga', 'pass1', 0);

insert into user(name, username, password, rol)
values ('Valrie Garver Linares', 'garver', 'garver123', 1);

insert into user(name, username, password, rol)
values ('Vilma Hillis Espinosa', 'hillis', 'hillis123', 1);

insert into user(name, username, password, rol)
values ('Wiley Dennie Brenes', 'dennie', 'dennie123', 0);





INSERT INTO COUNTRY(name)
VALUES ('Spain');

	insert into city(name, country_id)
	values ('Alicante', 1);
	
		insert into building(name, city_id)
		values ('Britania', 1);
		
			insert into floor(number, building_id)
			values (1,1);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 1);
				
					insert into user_workplace(workplace_id, user_id)
					values (1, 1);

				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 1);
				
					insert into user_workplace(workplace_id, user_id)
					values (2, 2);

				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (3, 0, 0, 0, 1);
				
					insert into user_workplace(workplace_id, user_id)
					values (3, 3);
					
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (4, 0, 0, 0, 1);
				
					insert into user_workplace(workplace_id, user_id)
					values (4, 4);
					
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (5, 0, 0, 0, 1);
				
					insert into user_workplace(workplace_id, user_id)
					values (5, 5);
					
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (6, 0, 0, 0, 1);
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (7, 0, 0, 0, 1);
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (8, 0, 0, 0, 1);
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (9, 0, 0, 0, 1);
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (10, 0, 0, 0, 1);
				
			insert into floor(number, building_id)
			values (2,1);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 2);
				
					insert into user_workplace(workplace_id, user_id)
					values (11, 6);
					
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 2);
				
--					insert into user_workplace(workplace_id, user_id)
--					values (12, 7);
					
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (3, 0, 0, 0, 2);
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (4, 0, 0, 0, 2);
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (5, 0, 0, 0,2);
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (6, 0, 0, 0, 2);
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (7, 0, 0, 0, 2);
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (8, 0, 0, 0, 2);
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (9, 0, 0, 0, 2);
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (10, 0, 0, 0, 2);
			
			insert into floor(number, building_id)
			values (3,1);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 3);
				
					insert into user_workplace(workplace_id, user_id)
					values (21, 8);
					
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 3);
				
					insert into user_workplace(workplace_id, user_id)
					values (22, 21);
					
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (3, 0, 0, 0, 3);
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (4, 0, 0, 0, 3);
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (5, 0, 0, 0, 3);
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (6, 0, 0, 0, 3);
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (7, 0, 0, 0, 3);
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (8, 0, 0, 0, 3);
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (9, 0, 0, 0, 3);
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (10, 0, 0, 0, 3);
		
		insert into building(name, city_id)
		values ('Mendez', 1);
		
			insert into floor(number, building_id)
			values (1,2);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 4);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 4);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (3, 0, 0, 0, 4);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (4, 0, 0, 0, 4);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (5, 0, 0, 0, 4);
				
			insert into floor(number, building_id)
			values (2,2);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 5);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 5);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (3, 0, 0, 0, 5);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (4, 0, 0, 0, 5);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (5, 0, 0, 0, 5);
				
			insert into floor(number, building_id)
			values (3,2);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 6);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 6);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (3, 0, 0, 0, 6);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (4, 0, 0, 0, 6);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (5, 0, 0, 0, 6);
		
		insert into building(name, city_id)
		values ('OscarEsplá', 1);
		
			insert into floor(number, building_id)
			values (1,3);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 7);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 7);
				
			insert into floor(number, building_id)
			values (2,3);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 8);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 8);
				
			insert into floor(number, building_id)
			values (3,3);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 9);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 9);
				

	insert into city(name, country_id)
	values ('Barcelona',1);
	
		insert into building(name, city_id)
		values ('Can Camps', 2);
		
			insert into floor(number, building_id)
			values (1,4);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 10);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 10);
				
			insert into floor(number, building_id)
			values (2,4);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 11);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 11);
		
		insert into building(name, city_id)
		values ('Diagonal', 2);
		
			insert into floor(number, building_id)
			values (1,5);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 12);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 12);
				
			insert into floor(number, building_id)
			values (2,5);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 13);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 13);
	
	insert into city(name, country_id)
	values ('Madrid', 1);

		insert into building(name, city_id)
		values ('Manoteras', 3);
		
			insert into floor(number, building_id)
			values (1,6);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 14);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 14);
				
			insert into floor(number, building_id)
			values (2,6);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 15);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 15);
		
		insert into building(name, city_id)
		values ('Novus', 3);
		
			insert into floor(number, building_id)
			values (1,7);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 16);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 16);


INSERT INTO COUNTRY(name)
VALUES ('France');

	insert into city(name, country_id)
	values ('Lyon', 2);
		
		insert into building(name, city_id)
		values ('Colomer Dumont', 4);
		
			insert into floor(number, building_id)
			values (1,8);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 17);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 17);
			
			insert into floor(number, building_id)
			values (2,8);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 18);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 18);
		
	insert into city(name, country_id)
	values ('Paris', 2);
		
		insert into building(name, city_id)
		values ('Cubic 33', 5);
		
			insert into floor(number, building_id)
			values (1,9);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 19);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 19);
			
			insert into floor(number, building_id)
			values (2,9);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 20);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 20);

INSERT INTO COUNTRY(name)
VALUES ('Brazil');

	insert into city(name, country_id)
	values ('Rio de Janeiro', 3);
		
		insert into building(name, city_id)
		values ('Morumbi Square', 6);
		
			insert into floor(number, building_id)
			values (1,10);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 21);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 21);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (3, 0, 0, 0, 21);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (4, 0, 0, 0, 21);
			
			insert into floor(number, building_id)
			values (2,10);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 22);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 22);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (3, 0, 0, 0, 22);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (4, 0, 0, 6666, 22);
		
	insert into city(name, country_id)
	values ('São Paulo', 3);
		
		insert into building(name, city_id)
		values ('Galeria Building', 7);
		
			insert into floor(number, building_id)
			values (1,11);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 23);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 23);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (3, 0, 0, 0, 23);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (4, 0, 0, 0, 23);
			
			insert into floor(number, building_id)
			values (2,11);
			
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (1, 0, 0, 0, 24);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (2, 0, 0, 0, 24);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (3, 0, 0, 0, 24);
				
				insert into workplace(number, coordx, coordy, qrcode, floor_id)
				values (4, 0, 0, 1111, 24);
				
INSERT INTO COUNTRY(name)
VALUES ('Argentina');

INSERT INTO COUNTRY(name)
VALUES ('Canada');

--INSERT INTO COUNTRY(name)
--VALUES ('Japan');

INSERT INTO COUNTRY(name)
VALUES ('Mexico');

INSERT INTO COUNTRY(name)
VALUES ('Peru');

--INSERT INTO COUNTRY(name)
--VALUES ('Portugal');

INSERT INTO COUNTRY(name)
VALUES ('Slovenia');

INSERT INTO COUNTRY(name)
VALUES ('Sweden');

--INSERT INTO COUNTRY(name)
--VALUES ('Venezuela');
--
--INSERT INTO COUNTRY(name)
--VALUES ('Yemen');

--
--
--insert into city(name, country_id)
--values ('Paris',2);
--
--insert into city(name, country_id)
--values ('Lyon',2);
--
--insert into building(name, city_id)
--values ('OscarEspla',1);
--
--insert into building(name, city_id)
--values ('PlayaSanJuan', 1);
--
--insert into floor(number, building_id)
--values (1,1);
--
--insert into floor(number, building_id)
--values (2,1); 
--
--insert into workplace(number, coordx, coordy, qrcode, floor_id)
--values (1, 0, 0, 1);
--
--insert into workplace(number, coordx, coordy, qrcode, floor_id)
--values (2, 0, 0,1);



--insert into user_workplace(workplace_id, user_id)
--values (1, 1);
--
--insert into user_workplace(workplace_id, user_id)
--values (2, 2);