# Ejercicios de Estructuras de Datos -ArrayList y LinkedList- en Java

Este repositorio reúne dos ejercicios de implementación de estructuras de datos desarrolladas desde cero en Java, sin utilizar las clases del paquete `java.util`. El objetivo general es comprender el funcionamiento interno de las estructuras lineales más utilizadas —una lista basada en arreglo dinámico y una lista enlazada— mediante su construcción manual, en lugar de emplear las implementaciones ya disponibles en el lenguaje. Cada ejercicio se desarrolla sobre un caso de dominio realista, con el fin de que la práctica no se limite a lo teórico, sino que demuestre la aplicación de estas estructuras en la resolución de un problema concreto.

Para quien revise este repositorio, cada carpeta permite observar de manera clara:
- La construcción de una estructura de datos genérica desde sus fundamentos (nodos, arreglos dinámicos, manejo de índices).
- La separación entre la lógica de validación y de negocio (clase `Gestor`) y la estructura de datos propiamente dicha (`ArrayList` / `LinkedList`), siguiendo un diseño ordenado y mantenible.
- El manejo de errores habituales, tales como datos inválidos o índices fuera de rango, mediante validaciones y excepciones.
- Un conjunto de pruebas manuales, que abarcan tanto casos correctos como casos de error, y que sirven como referencia para comprender el comportamiento esperado de cada método.

## Consultorio "Dr. Salas" — ArrayList

Este ejercicio consiste en la implementación propia de `ArrayList<E>`, mediante un arreglo (`Object[]`) que se redimensiona automáticamente al alcanzar su capacidad máxima. La estructura se aplica a la gestión de la sala de espera de un consultorio médico, donde los pacientes son atendidos, por lo general, en el orden de llegada, aunque en ocasiones es necesario insertar a un paciente prioritario en una posición específica de la fila. El ejercicio permite registrar pacientes, consultarlos por posición, insertarlos en un índice determinado, eliminarlos y atender al paciente que se encuentra al inicio de la fila. Incluye la validación de los datos del paciente (nombre, identificación, edad) previa a su registro, así como el manejo de errores mediante `IndexOutOfBoundsException` ante el acceso a posiciones inválidas.

El propósito específico de este ejercicio es practicar el manejo de arreglos dinámicos: el crecimiento del arreglo sin pérdida de los datos existentes, el desplazamiento de elementos al insertar o eliminar en una posición intermedia, y la validación segura de los límites de la estructura.

[`consultorio-arraylist/`](./consultorio-arraylist

## Aplicación de música "Sonora" — LinkedList

Este ejercicio consiste en la implementación propia de `LinkedList<E>`, basada en nodos enlazados (`Nodo<E>`), aplicada a la cola de reproducción de una aplicación de música. Las canciones se agregan al final de la cola, aunque también es posible insertarlas en una posición específica para que sean reproducidas a continuación. La reproducción de una canción implica retirarla del inicio de la cola. El ejercicio permite, además, consultar si una canción se encuentra en la cola, determinar su posición, invertir el orden de reproducción y vaciar la cola por completo. Incluye la validación de los datos de cada canción, así como el manejo de errores por índices inválidos.

El propósito específico de este ejercicio es practicar el manejo de referencias entre nodos: el recorrido, la inserción y la eliminación de elementos mediante el desplazamiento de punteros, en lugar de índices de arreglo, y particularmente la inversión de una lista enlazada mediante la modificación de sus enlaces existentes, sin necesidad de crear una segunda lista.

[`listaMusical-linkedlist/`](./listaMusical-linkedlist)

## Estructura común de ambos ejercicios

Si bien resuelven problemas distintos, ambos ejercicios comparten el mismo enfoque de diseño:

- Una interfaz `List<E>` que define las operaciones fundamentales: `add`, `remove`, `get`, `size`, `clear`, `isEmpty`, además de `add(E elemento, int indice)` para la inserción en una posición determinada.
- Una clase `Gestor` que centraliza la lógica de validación y las operaciones propias del dominio (consultorio o cola de música), de modo que la clase `Main` no manipula directamente la estructura de datos.
- Una clase `Main` con casos de prueba manuales —positivos y negativos— que documentan el comportamiento esperado de cada operación, incluyendo los errores que debe generar la estructura ante un uso incorrecto.
- Un README individual dentro de cada carpeta, con la descripción detallada de las clases, la relación entre ellas y el listado completo de los casos de prueba.
