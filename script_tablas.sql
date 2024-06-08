drop table if exists pronosticos ;
drop table if exists usuarios;
drop table if exists partidos;
drop table if exists paises ;

create table paises(
	codigo_int int not null,
	nombre varchar(20),
	constraint paises_pk primary key(codigo_int)
);


select * from paises;

insert into paises(codigo_int, nombre)
values(032, 'Argentina');
insert into paises(codigo_int, nombre)
values(068, 'Bolivia');
insert into paises(codigo_int, nombre)
values(076, 'Brasil');
insert into paises(codigo_int, nombre)
values(124, 'Canada');
insert into paises(codigo_int, nombre)
values(152, 'Chile');
insert into paises(codigo_int, nombre)
values(170, 'Colombia');
insert into paises(codigo_int, nombre)
values(188, 'Costa Rica');
insert into paises(codigo_int, nombre)
values(218, 'Ecuador');
insert into paises(codigo_int, nombre)
values(840, 'Estados Unidos');
insert into paises(codigo_int, nombre)
values(388, 'Jamaica');
insert into paises(codigo_int, nombre)
values(484, 'Mexico');
insert into paises(codigo_int, nombre)
values(591, 'Panama');
insert into paises(codigo_int, nombre)
values(600, 'Paraguay');
insert into paises(codigo_int, nombre)
values(604, 'Peru');
insert into paises(codigo_int, nombre)
values(858, 'Uruguay');
insert into paises(codigo_int, nombre)
values(862, 'Venezuela');

create table partidos(
	codigo SERIAL not null,
	equipo1 int not null,  
	equipo2 int not null,
	fecha date not null,
	hora time not null,
	constraint partidos_pk primary key(codigo),
	constraint equipo1_pk foreign key(equipo1) references paises(codigo_int), 
	constraint equipo2_pk foreign key(equipo2) references paises(codigo_int) 
);

select * from partidos;

insert into partidos(equipo1, equipo2, fecha, hora)
values(032, 124, '15/06/2024', '20:30');
insert into partidos(equipo1, equipo2, fecha, hora)
values(604,152 ,'21/06/2024', '20:30');
insert into partidos(equipo1, equipo2, fecha, hora)
values(218, 862, '22/06/2024', '20:30');
insert into partidos(equipo1, equipo2, fecha, hora)
values(484, 388, '22/06/2024', '20:30');
insert into partidos(equipo1, equipo2, fecha, hora)
values(840, 068, '23/06/2024', '20:30');--
insert into partidos(equipo1, equipo2, fecha, hora)
values(858, 591, '23/06/2024', '20:30');--
insert into partidos(equipo1, equipo2, fecha, hora)
values(170, 600, '24/06/2024', '20:30');
insert into partidos(equipo1, equipo2, fecha, hora)
values(076, 188, '24/06/2024', '20:30');--
insert into partidos(equipo1, equipo2, fecha, hora)
values(604, 124, '25/06/2024', '20:30');
insert into partidos(equipo1, equipo2, fecha, hora)
values(152, 032, '25/06/2024', '20:30');

create table usuarios(
	cedula char(10) not null,
	nombre varchar(30) not null,
	apellido varchar(30) not null,
	constraint usuarios_pk primary key(cedula)
);

select * from usuarios;

insert into usuarios(cedula, nombre, apellido)
values('1727039917', 'Kelvin', 'Bermeo');
insert into usuarios(cedula, nombre, apellido)
values('1709386757', 'Segundo', 'Bermeo');
insert into usuarios(cedula, nombre, apellido)
values('1727039925', 'Javier', 'Bermeo');


create table pronosticos(
	cod_pro serial not null,
	cedula_user char(10) not null,
	cod_par int not null,
	cod_equipo1 int not null,
	cod_equipo2 int not null,
	marc_e1 int not null,
	marc_e2 int not null,
	constraint pronosticos_pk primary key(cod_pro),
	constraint user_fk foreign key(cedula_user) references usuarios(cedula),
	constraint par_fk foreign key(cod_par) references partidos(codigo),
	constraint eq1_fk foreign key(cod_equipo1) references paises(codigo_int),
	constraint eq2_fk foreign key(cod_equipo2) references paises(codigo_int) 
);

select * from pronosticos;

insert into pronosticos(cedula_user, cod_par, cod_equipo1, cod_equipo2, marc_e1, marc_e2)
values('1727039917', 1, 170, 218, 3, 1);
insert into pronosticos(cedula_user, cod_par, cod_equipo1, cod_equipo2, marc_e1, marc_e2)
values('1727039917', 6, 32, 124, 3, 3);
insert into pronosticos(cedula_user, cod_par, cod_equipo1, cod_equipo2, marc_e1, marc_e2)
values('1727039917', 7, 604, 152, 2, 3);
insert into pronosticos(cedula_user, cod_par, cod_equipo1, cod_equipo2, marc_e1, marc_e2)
values('1709386757', 1, 170, 218, 1, 1);
insert into pronosticos(cedula_user, cod_par, cod_equipo1, cod_equipo2, marc_e1, marc_e2)
values('1709386757', 6, 32, 124, 0, 3);
insert into pronosticos(cedula_user, cod_par, cod_equipo1, cod_equipo2, marc_e1, marc_e2)
values('1709386757', 7, 604, 152, 3, 1);
insert into pronosticos(cedula_user, cod_par, cod_equipo1, cod_equipo2, marc_e1, marc_e2)
values('1727039925', 1, 170, 218, 0, 1);
insert into pronosticos(cedula_user, cod_par, cod_equipo1, cod_equipo2, marc_e1, marc_e2)
values('1727039925', 6, 32, 124, 1, 2);
insert into pronosticos(cedula_user, cod_par, cod_equipo1, cod_equipo2, marc_e1, marc_e2)
values('1727039925', 7, 604, 152, 2, 5);

--CONSULTAS
select * from partidos
where fecha = '22/06/2024'

select * from pronosticos pr, usuarios us
where pr.cedula_user = '1727039917'
and pr.cedula_user = us.cedula

select * from pronosticos 
where cod_par =6 


select * from pronosticos
