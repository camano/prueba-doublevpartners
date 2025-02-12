CREATE DATABASE dbdoublevpartners;

INSERT INTO public.estatus (estatus_id,nombre_estatus) VALUES
	 (1,'abierto'),
	 (2,'cerrado');


select (select estatus_id from estatus where nombre_estatus='abierto') from tickets;