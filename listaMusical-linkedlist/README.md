# Cola de Reproduccion - App de Musica Sonora

## Contexto

La aplicacion de musica Sonora administra la cola de reproduccion del usuario. Las canciones se agregan al final, aunque tambien es posible insertar una cancion en una posicion concreta para que suene a continuacion. La cancion que se reproduce se retira del principio de la cola. Ademas, el usuario puede consultar la cola, invertir su orden y vaciarla.

Este proyecto implementa la estructura enlazada desde cero, sin utilizar `java.util.LinkedList`.

## Objetivo

El objetivo es practicar la implementacion de una lista enlazada generica y aplicarla a un caso realista. El ejercicio trabaja especialmente:

- Recorrido secuencial mediante nodos.
- Insercion y eliminacion por indice.
- Validacion de indices con `IndexOutOfBoundsException`.
- Inversion de los enlaces de una lista sin crear otra lista.
- Validacion de los datos de una cancion.
- Pruebas positivas y negativas mediante un `main` propio.

## Clases del proyecto

### `Cancion`

`Cancion` es la clase de datos del dominio. Contiene:

- `titulo`: titulo de la cancion.
- `artista`: artista o grupo musical.
- `duracionS`: duracion en segundos.

Incluye un constructor, getters y `toString()` para mostrar una cancion de forma legible. La clase no contiene la logica de validacion; esa responsabilidad corresponde a `Gestor`.

## Clases y responsabilidades

### `List<E>`

Es la interfaz de la lista y define `add`, `remove`, `get`, `size`, `clear` e
`isEmpty`. Tambien define `add(E elemento, int indice)` para insertar en una
posicion concreta.

### `Nodo<E>`

Representa cada elemento de la lista enlazada. Guarda:

- `dato`: el elemento almacenado.
- `sig`: referencia al siguiente nodo.

Proporciona getters y setters para acceder al dato y cambiar el enlace siguiente.

### `LinkedList<E>`

Implementa `List<E>` usando nodos propios. Mantiene una referencia `head` al primer nodo y un contador `size`.

Metodos base:

- `add(E e)`: agrega un elemento al final.
- `add(E e, int indice)`: inserta un elemento en una posicion valida.
- `remove(int indice)`: elimina y devuelve el elemento del indice indicado.
- `get(int indice)`: devuelve el elemento del indice indicado.
- `size()`: devuelve la cantidad de elementos.
- `clear()`: elimina todos los nodos de la lista.
- `isEmpty()`: indica si la lista esta vacia.

Metodos propios:

- `mostrar()`: recorre los nodos con un puntero `actual` e imprime cada elemento.
- `invertir()`: invierte la lista usando los punteros `anterior`, `actual` y `siguiente`, modificando los enlaces existentes.
- `contiene(E e)`: busca un elemento y devuelve `true` o `false`.
- `indexOf(E e)`: devuelve la posicion del primer elemento encontrado o `-1` si no existe.

Los metodos que reciben indices validan los limites. Si el indice no es valido, lanzan `IndexOutOfBoundsException`.

### `Gestor`

Es la clase que representa la cola de reproduccion y conecta el dominio con la estructura de datos. Contiene internamente:

```java
private LinkedList<Cancion> colaRep;
```

Sus responsabilidades son:

- Validar canciones antes de agregarlas.
- Agregar canciones al final o en una posicion concreta.
- Eliminar canciones de la cola.
- Comprobar si una cancion esta en la cola y consultar su posicion.
- Mostrar la cola.
- Reproducir la siguiente cancion, retirando la primera.
- Invertir y limpiar la cola.
- Consultar su tamano y si esta vacia.
- Obtener una cancion por indice.

La validacion comprueba que la cancion no sea nula, que titulo y artista no sean nulos, vacios ni contengan caracteres no permitidos, y que la duracion sea un entero mayor que cero. La validacion de texto se realiza mediante una expresion regular.

### `Main`

Contiene el metodo `main` y funciona como programa de prueba. Ejecuta casos positivos y negativos sobre un objeto `Gestor`, mostrando los resultados en consola.

## Relacion entre las clases

`Main` no manipula directamente la lista enlazada. Usa `Gestor`, que centraliza la validacion y las operaciones de la cola. `LinkedList` almacena las canciones en nodos `Nodo`, mientras `Cancion` representa los datos de cada elemento.

## Estructura del proyecto

```text
ListaReproduccion/
├── src/
│   ├── Cancion.java
│   ├── Gestor.java
│   ├── LinkedList.java
│   ├── List.java
│   ├── Main.java
│   └── Nodo.java
├── bin/
├── lib/
└── README.md
```



## Como ejecutar

1. Descarga o clona el repositorio
2. Abre el proyecto en tu IDE de preferencia
3. Compila todas las clases
4. Ejecuta la clase principal (Main) usando el boton **Run**
5. Verás en la consola los resultados de las pruebas negativas y positivas.
java -cp bin Main
```

## Casos de prueba

`Main` incluye los siguientes casos.

### Casos positivos

1. Agregar canciones al final de la cola.
2. Insertar una cancion en el indice `1`.
3. Mostrar las canciones en el orden de reproduccion.
4. Verificar el tamano de la cola.
5. Obtener la cancion del indice `0` y comprobar sus datos.
6. Reproducir la primera cancion y verificar que el tamano disminuye.
7. Mostrar la cola restante.
8. Invertir la cola y mostrar el orden invertido.
9. Limpiar la cola y comprobar que queda vacia.

### Casos negativos

1. Agregar una cancion con titulo vacio.
2. Agregar una cancion con artista compuesto solo por espacios.
3. Agregar una cancion con titulo `null`.
4. Agregar un titulo con caracteres no permitidos, como `@`.
5. Agregar un artista con caracteres no permitidos, como `#`.
6. Agregar una duracion igual a cero.
7. Agregar una duracion negativa.
8. Agregar una cancion nula.
9. Insertar una cancion valida en un indice fuera de rango.
10. Eliminar una cancion usando un indice fuera de rango.
11. Obtener una cancion usando un indice fuera de rango y capturar `IndexOutOfBoundsException`.
12. Intentar reproducir cuando la cola esta vacia.

Una cadena con el texto literal `"null"` no es lo mismo que un valor `null`; el texto literal puede pasar la expresion regular porque es una cadena valida. En cambio, `new Cancion(null, ...)` se rechaza correctamente.

## Funcionamiento de `invertir()`

La inversion se hace sin crear una segunda lista. En cada paso se guardan tres referencias:

1. `siguiente` conserva el nodo que falta recorrer.
2. `actual.setSig(anterior)` cambia la direccion del enlace.
3. `anterior` y `actual` avanzan al siguiente paso.

Al terminar el recorrido, `head` pasa a apuntar al ultimo nodo original, que ahora es el primero.

## Decisiones de implementacion

Se utiliza una lista enlazada porque la cola se recorre principalmente de forma secuencial y reproducir una cancion consiste en quitar el primer elemento. La implementacion permite practicar los enlaces entre nodos y no depende de `java.util.LinkedList`.
