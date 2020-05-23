# Prueba Desarrollo para latam

servicio REST que recibe como parámetro de entrada:
 * Nombre completo (nombres y apellidos) 
 * fecha (DD-MM-YYYY) 
 
 retorne: 

* Primer nombre y primer apellido
* Edad
* Cuántos días faltan para su cumpleaños o en caso de que sea su cumpleaños felicitarlo y ocupar la siguiente API “https://www.poemist.com/api/v1/randompoems” para dedicarle un poema random de la lista que responde



## Como desplegar el sistema

* descargar la aplicación y cargarlo con su ide de preferencia (recomendado IntelliJ).
* una vez tenga la aplicación cargada en su ide ejecutar:


```bash
gradle bootRun
```

## Probar si está funcionando

para testear si quedó bien desplegada la aplicacion en el navegador o desde postman

```
http://localhost:8080/api/v0/birthday?name=mis nombres&lastName=apellidopaterno&motherLastName=apellidoMaterno&birthday=22-05-2020
```
*la fecha de nacimiento debe ir en formato dd-MM-yyyy
