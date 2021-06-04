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
![alt Text](https://drive.google.com/file/d/1oY2-3lQRiFgPF_Knh8uOTEeuwt6Hamc0/view?usp=sharing)



La tabla esta en una lista que se puede mejorar enviandolo a bdd en lugar de una lista generada en el constructor

los metodos CalculatorServices estan redundando el map para buscar esto mejoraria la usar jpa