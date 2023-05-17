## Trabajo Final del Primer Bimestre - Programación Orientada a Objetos

### Consideraciones Generales

- El trabajo es grupal.
- Se debe generar una solución en UML y lenguaje de programación en Java.
- Se ha creado un proyecto de Netbeans, en el cual existen creados paquetes y clases; con base al proyecto seguir con el desarrollo de la solución.
- Usted debe adicionar las clases que sean necesarias.
- Las clases deben tener los métodos respectivos por cada atributo.
- Es importante usar métodos constructores en las clases.
- Usted debe crear una carpeta donde se ubican los diagramas de las clases.


### Problemática

Se necesita realizar un sistema de gestión de una inmobiliaria. En la empresa se necesita llevar el registro de constructoras, edificios, departamentos, casas

A continuación se definen algunas particularidades.
* Una casa tiene propiedades como: propietario (nombres, apellidos, identificación; precio por metro cuadrado; número de metros cuadrados; costo final; barrio (nombre del barrio, referencia); ciudad (nombre ciudad, nombre provincia); numero de cuartos; constructora (nombre constructora, id de la empresa)

* Por cada departamento se necesita: propietario (nombres, apellidos, identificación); precio por metro cuadrado; número de metros cuadrados; valor alícuota mensual; costo final; barrio (nombre del barrio, referencia); ciudad (nombre ciudad, nombre provincia); nombre de edificio; ubicación del departamento en edificio; constructora (nombre constructora, id de la empresa)


El sistema debe permitir ingresar: propietarios; barrio; ciudades; constructoras; casas; departamentos. Además se solicita considerar lo siguiente:

* Todos los objetos de tipo propietario se deben ingresar y guardar en un archivo llamado propietarios.dat
* Todos los objetos de tipo barrio se deben ingresar y guardar en un archivo llamado barrios.dat
* Todos los objetos de tipo ciudad se deben ingresar y guardar en un archivo llamado ciudades.dat
* Todos los objetos de tipo constructora se deben ingresar y guardar en un archivo llamado constructoras.dat
* Todos los objetos de tipo casa se deben ingresar y guardar en un archivo llamado casas.dat
* Para el ingreso de una casa se debe tomar en consideración el siguiente proceso:
	* El propietario se debe obtener del archivo propietarios.dat a través de la identificación.
	* El barrio se debe obtener del archivo barrio.dat a través del nombre del barrio.
	* La ciudad se debe obtener del archivo ciudades.dat a través del nombre de la ciudad.
	* La constructora se debe obtener del archivo constructoras.dat a través del id de la empresa.
	* El costo final es igual al número de metros * precio del metro cuadrado.

* Todos los objetos de tipo departamento se deben ingresar y guardar en un archivo llamado departamentos.dat
* Para el ingreso de un departamento se debe tomar en consideración lo siguiente:
	* El propietario se debe obtener del archivo propietarios.dat a través de la identificación.
	* El barrio se debe obtener del archivo barrio.dat a través del nombre del barrio.
	* La ciudad se debe obtener del archivo ciudades.dat a través del nombre de la ciudad.
	* La constructora se debe obtener del archivo constructoras.dat a través del id de la empresa.
	* El costo final es igual al (número de metros * valor del metro cuadrado) + (valor alícuota mensual * 12).

* Debe existir la posibilidad de listar los datos ingresados para:
	* Propietarios
	* Barrios
	* Ciudades
	* Constructoras
	* Casas
	* Departamentos

### Herramientas a usar

- Lenguaje de programación Java
- Diagramador - DIAUML
- Git
- Github / GitHub-classroom

### Fecha de presentación

- Semana 8 del primer bimestre
