# Prueba-doublevpartners

1. Generar el jar con el siguiente comando  mvn clean install

2. Ejecutar docker-compose up se configuro las imagenes de base de datos y el java que se esta utilizando solo es ejecutar el comando y el proyecto quedaria arriba

3. Ejecutar para llenar los estatus solo faltaria llenar los estados a la tabla
   INSERT INTO public.estatus (estatus_id,nombre_estatus) VALUES
   (1,'abierto'),
   (2,'cerrado');

4. http://localhost:9001/swagger-ui/index.html swagger con los end point a consumir
5. http://localhost:9001/api/tickets  ruta donde se encuentra los end point
6. la collecion de postman para que pruebe los end point se encuentra en la raiz del proyecto
7. se crearon pruebas unitarias de la capa servicio en backend 

Objetivo: Crear una aplicación que ayude a obtener una lista de
   usuarios y muestre la información de sus perfiles, explotando el API

En este punto no entendi muy bien si tocaba hacer una api de usuarios o solo de tickets