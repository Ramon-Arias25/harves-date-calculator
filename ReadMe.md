#Harves Date Calculator

##CONSIGNA

Dado el calendario de siembra que se indica en la siguiente tabla adjunta, se pide crear un recurso el cual cumpla con lo siguiente:

1- Tome los siguientes parámetros:
a- Especie
b- Ancho del área de sembrado (metros)
c- Largo del área de sembrado (metros)

2- Debe devolver en su respuesta un JSON con los siguientes datos:
a- Especie
b- Cantidad de plantines posibles a sembrar en dicha área
c- Fecha estimada de cosecha

3- Si la especie no figura en el listado debe devolverse un mensaje "No se encontraron datos de dicha especie"

4- Si la fecha en que se ejecuta esta consulta está fuera de la fecha de siembra debe devolverse el mensaje:
"La especie consultada está fuera de calendario"

5- Si el ancho y/ó largo del área de sembrado en metros es negativo debe devolverse el mensaje:
"Los datos ingresados son incorrectos"


####Tabla
![alt Text](https://raw.githubusercontent.com/Ramon-Arias25/harves-date-calculator/main/tabla-cosecha.PNG)

1- Integrar MySQL al proyecto actual
2- Crear una tabla "Especie" que represente a la tabla indicada en la consigna anterior, pero esta vez con id
3- Usar la especificación JPA para tomar datos de dicha tabla
4- Crear un repositorio para disponer del método correspondiente para traer el registro de la tabla pedido
5- Crear un servicio para alojar la lógica de negocio de la aplicación en un método
6- Modificar el método de la consigna anterior a un controlador, pero esta vez los parámetros de entrada
deben ser el id (mirar nueva tabla), más el ancho y largo de sembrado
7- La respuesta debe ser la misma que en el caso anterior (JSON)

En esencia, debe reemplazarse el listado hardcoding por datos populados en la bbdd y crearse
un modelo con repositorio, servicio y controlador manteniendo la funcionalidad núcleo de la consigna anterior.

![alt Text](https://raw.githubusercontent.com/Ramon-Arias25/harves-date-calculator/main/tabla-cosecha2.PNG)


Ejemplo de Request valido

{
    "name": "1", _<- nombre de la especie no discrimina mayusculas_
    "width": 1, _<- ancho de la superficie a evaluar_
    "high": 1 _<- largo de la superficie a evaluar_
}

GitPuh https://github.com/Ramon-Arias25/harves-date-calculator