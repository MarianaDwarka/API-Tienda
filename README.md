# Tienda

### Contexto
Una tienda ha incrementado en gran medida sus ventas. Dado esto y que le está siendo casi imposible registrar las mismas y manejar el stock de sus productos de forma manual, necesita
del desarrollo de una aplicación que le permita realizar esta tarea.

La dueña de la tienda manifiesta que todas las operaciones que tenga la aplicación se deben poder realizar mediante dos tipos de clientes http distintos:

- Una aplicación web, cuyo frontend desarrollará un programador amigo (no será parte de nuestra tarea como desarrolladores backend).

- Una aplicación Mobile que será implementada a futuro.

Cada una de estas app representa a los dispositivos que ella y sus empleados manejan actualmente. En síntesis: una computadora y varios celulares.

Dada esta situación particular y de que necesita utilizar el mismo backend para ambas opciones, solicita el desarrollo de una API.

### Modelado

A partir del relevamiento que ha llevado a cabo un analista funcional, se detectaron que serán necesarias las siguientes clases:
- Producto
- Venta
- Cliente
  
En donde cada venta posee una lista de productos (una venta puede tener asociados varios productos y un producto puede aparecer en varias ventas)  y uno y solo un cliente asociado.

Además de eso, cada clase debe tener los siguientes atributos:

**Producto**

- Long codigo_producto
- String nombre
- String marca
- Double costo
- Double cantidad_disponible

**Venta**

- Long codigo_venta
- LocalDate fecha_venta
- Double total
- List<Producto> listaProductos
- Cliente unCliente

**Cliente**

- Long id_cliente
- String nombre
- String apellido
- String dni

### Requerimientos

A partir del análisis realizado respecto al modelado se desarrollaron los siguientes puntos:

1. CRUD completo de productos
   - Métodos HTTP: GET, POST, DELETE, PUT
2. CRUD completo de clientes
   - Métodos HTTP: GET, POST, DELETE, PUT
3. CRUD completo de ventas
   - Métodos HTTP: GET, POST, DELETE, PUT
4. Obtener todos los productos cuya cantidad_disponible sea menor a 5
   - Métodos HTTP: GET
5. Obtener la lista de productos de una determinada venta
   - Métodos HTTP: GET
6. Obtener la sumatoria del monto y también cantidad total de ventas de un determinado día
   - Métodos HTTP: GET
7. Obtener el codigo_venta, el total, la cantidad de productos, el nombre del cliente y el apellido del cliente de la venta con el monto más alto de todas.
   - Métodos HTTP: GET
