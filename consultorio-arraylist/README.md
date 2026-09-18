# Control de Sala de Espera - Consultorio "Dr. Salas"

## Contexto

El consultorio del Dr. Salas atiende pacientes en el orden en que llegan. Sin
embargo, un paciente puede necesitar pasar antes por una situacion urgente o
por tener una cita confirmada. La recepcionista debe registrar los pacientes,
consultar su posicion, insertar pacientes prioritarios y atender al siguiente
paciente.

Esta version implementa la solucion usando una lista propia basada en un
arreglo dinamico. No se utiliza `java.util.ArrayList`.

## Objetivo

Practicar la implementacion de una estructura `ArrayList<E>` desde cero y
aplicarla a un caso sencillo de gestion de pacientes. El proyecto incluye
pruebas positivas y pruebas de errores, como indices invalidos y datos
incorrectos de un paciente.

## Clases del proyecto

### `Paciente`

Representa los datos de un paciente. Contiene `nombre`, `id`, `edad` y
`prioridad`.

Incluye constructor, getters y `toString()` para mostrar el paciente de forma
legible.

### `List<E>`

Es la interfaz de la lista y define `add`, `remove`, `get`, `size`, `clear` e
`isEmpty`. Tambien define `add(E elemento, int indice)` para insertar en una
posicion concreta.

### `ArrayList<E>`

Implementa `List<E>` usando un `Object[]`. Mantiene el arreglo de elementos, el
tamano actual y la capacidad disponible. Cuando el arreglo se llena,
`extender()` crea otro con diez posiciones adicionales y copia los elementos.

`validarIndiceAcceso()` y `validarIndiceInsercion()` lanzan
`IndexOutOfBoundsException` cuando el indice no es valido. La clase tambien
incluye `mostrar()` para imprimir la lista y `toString()` para convertir su
contenido en texto legible.

### `Gestor`

Es la clase encargada de la logica del consultorio. Contiene internamente:

```java
private ArrayList<Paciente> salaEspera;
```

Por eso `Main` no manipula directamente la lista. Sus metodos son:

- `anadirPaciente(Paciente paciente)`: valida y agrega al final.
- `agregarPaciente(Paciente paciente, int indice)`: valida e inserta en una
	posicion concreta.
- `obtenerPaciente(int indice)`: obtiene el paciente de una posicion.
- `removerPaciente(int indice)`: elimina y devuelve un paciente.
- `atenderSiguientePaciente()`: elimina y devuelve el paciente de la posicion
	cero. Si no hay pacientes, devuelve `null`.
- `tamanoSala()`: devuelve la cantidad de pacientes.
- `mostrarSalaEspera()`: muestra el contenido de la sala.
- `sonIguales(Paciente primero, Paciente segundo)`: compara dos pacientes

Antes de agregar un paciente, `Gestor` valida que no sea `null`, que el nombre
no este vacio y solo tenga letras y espacios, que el id no este vacio y solo
contenga numeros, y que la edad sea mayor que cero. La prioridad, por ser
`boolean`, solo puede ser `true` o `false` desde el propio codigo Java.

### `Main`

Contiene el metodo `main` y funciona como clase de pruebas. Crea un `Gestor`,
registra pacientes y comprueba las operaciones de la sala de espera. Tambien
prueba los casos invalidos e imprime los resultados en consola.

## Relacion entre las clases

```text
Main
 |
 v
Gestor
 |
 v
ArrayList<Paciente> -- implementa --> List<E>
 |
 v
Paciente
```

`Main` utiliza `Gestor`. `Gestor` administra la sala de espera y delega el
almacenamiento en `ArrayList`. `ArrayList` implementa las operaciones definidas
por `List` y guarda objetos `Paciente`.

## Estructura del proyecto

consultorio-arrylist/
|   |-- ArrayList.java
|   |-- Gestor.java
|   |-- List.java
|   |-- Main.java
|   `-- Paciente.java
`-- README.md

## Como ejecutar

1. Descarga o clona el repositorio
2. Abre el proyecto en tu IDE de preferencia
3. Compila todas las clases
4. Ejecuta la clase principal (Main) usando el boton **Run**
5. Verás en la consola los resultados de las pruebas negativas y positivas.


## Casos de prueba

### Casos correctos

- Agregar tres pacientes al final de la sala.
- Obtener el paciente de la posicion cero.
- Insertar un paciente prioritario en la posicion cero.
- Verificar el desplazamiento de los pacientes y el tamano de la lista.
- Remover un paciente y comprobar que el tamano disminuye.
- Atender al paciente prioritario y mostrarlo.
- Mostrar la sala de espera.

### Casos de error

- Insertar, obtener o eliminar usando un indice fuera de rango.
- Agregar un paciente `null`.
- Agregar un nombre vacio, `null`, con numeros o con caracteres especiales.
- Agregar un id vacio, `null` o con letras.
- Agregar una edad igual a cero o negativa.
- Intentar atender una sala vacia.

Los errores de indice se controlan mediante `IndexOutOfBoundsException`. Los
datos invalidos se rechazan en `Gestor` y no se agregan a la sala.
