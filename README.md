# EventoBoletos
Servicio para la administración de boletos de eventos.

Para el presente proyecto se utilizo  el lenguaje Java, la herramienta Spring Boot del framework Spring, así como el entorno de desarrollo "Workspace Spring Tool Suite"; como base de datos opte por usar Mysql.

Para arrancar y probar dicho servicio es necesario abrir la clase "EventoApplication" ubicada en la ruta "eventos/src/main/java/com/evento/aplicacion/EventoApplication.java", esto nos lo desplegara en el servidor embebido Tomcat (en caso de usar la misma herramienta), utilizando la opción Run As > Spring Boot App.
![image](https://github.com/user-attachments/assets/59785283-0783-44de-8c9c-047c99821bde)

Para el primer evento "Crear la definición de un evento", probamos los posibles escenarios que se puedan dar:
Caso exitoso:
![image](https://github.com/user-attachments/assets/cb178923-6ccc-42dc-9b01-00b5bfc92fb9)
Caso con campo nulo:
![image](https://github.com/user-attachments/assets/22a68f22-1f4a-4c40-8024-f571b118b1ae)
Caso con fecha de inicio menor a la actual:
![image](https://github.com/user-attachments/assets/0cda9fef-9dd1-4007-baef-ebeeaf48fbe5)
Caso con fecha de fin menor a la fecha de inicio:
![image](https://github.com/user-attachments/assets/53e843af-f965-4bc2-82c9-abdeb3877116)
Cantidad de boletos disponibles fuera del rango (>1 && <300)
![image](https://github.com/user-attachments/assets/bbaaf38e-39f3-4c73-b705-75d22d7557ec)

Para el segundo evento "Actualizar evento", probamos con los siguientes escenarios:
Caso actualización de nombre:
![image](https://github.com/user-attachments/assets/0daa0c56-9243-4a84-8855-b3ef78578030)
Caso negativo actualización fecha inicio, pues en el evento anterio se comprobo de manera positiva:
![image](https://github.com/user-attachments/assets/c1aee886-0593-4452-97d6-9ded2184b15c)

Caso negativo actualización fecha fin:
![image](https://github.com/user-attachments/assets/c4ca6c8e-c132-4a17-bfeb-25ff524ba7a4)

Para el tercer caso de "Borrar evento":
![image](https://github.com/user-attachments/assets/4b7dfbde-5a1f-4cb7-ae7b-31f0ab87cc77)
![image](https://github.com/user-attachments/assets/393374eb-0dd7-4e2c-8d90-849af6ebb89e)



Para el cuarto caso de "Vender boleto", se comprueba de la siguiente manera:
![image](https://github.com/user-attachments/assets/423140cf-1616-4f1c-8f4e-c8fd0b822ef5)



Para el penúltimo caso de canjeo de boleto:
Caso positivo:
![image](https://github.com/user-attachments/assets/38f54a9e-fb90-40f7-888d-3ef70cb45866)
Caso negativo:
![image](https://github.com/user-attachments/assets/3af220d2-7f53-4548-a53e-9142829ea94e)
![image](https://github.com/user-attachments/assets/ccce6a21-40aa-4335-9d77-b2a90d6888ba)



Para el último evento de obtener detalles del evento
![image](https://github.com/user-attachments/assets/78e79ed1-40d0-42df-aa08-1ae5bfbedea5)

