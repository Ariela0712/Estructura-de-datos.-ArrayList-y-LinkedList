public class Gestor {
    private LinkedList<Cancion> colaRep;

    public Gestor() {
        colaRep = new LinkedList<>();
    }

    public void agregarCancion(Cancion cancion) {
        if (!validarCancion(cancion)) {
            return;
        }
        colaRep.add(cancion);
        System.out.println("Cancion agregada correctamente.");
    }
    
    public void agregarCancionInd(Cancion cancion, int indice) {
        if (!validarCancion(cancion)) {
            return;
        }
        try {
            colaRep.add(cancion, indice);
            System.out.println("Cancion agregada correctamente en el indice " + indice + ".");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No se pudo agregar la cancion: " + e.getMessage());
        }
    }

    public void eliminarCancion(int indice) {
        try {
            Cancion eliminada = colaRep.remove(indice);
            System.out.println("Cancion eliminada correctamente: " + eliminada);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No se pudo eliminar la cancion: " + e.getMessage());
        }
    }

    private boolean validarCancion(Cancion cancion) {
        if (cancion == null) {
            System.out.println("Error, La cancion no puede ser nula.");
            return false;
        }
        if (!validarTexto(cancion.getTitulo())) {
            System.out.println("Error, El titulo es nulo, vacio o contiene caracteres invalidos.");
            return false;
        }
        if (!validarTexto(cancion.getArtista())) {
            System.out.println("Error, El artista es nulo, vacio o contiene caracteres invalidos.");
            return false;
        }
        if (!validarDuracion(cancion.getDuracionS())) {
            System.out.println("Error, La duracion debe ser un entero mayor que cero.");
            return false;
        }
        return true;
    }

    private boolean validarTexto(String texto) {
        return texto != null && !texto.trim().isEmpty() && texto.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑüÜ ]+");
    }

    private boolean validarDuracion(int duracion) {
        return duracion > 0;
    }

    public void mostrarCola() {
        colaRep.mostrar();
    }

    public Cancion reproducirSiguiente() {
        if (colaRep.isEmpty()) {
            System.out.println("No hay canciones en la cola.");
            return null;
        }
        return colaRep.remove(0);
    }

    public void invertirCola() {
        colaRep.invertir();
    }

    public void limpiarCola() {
        colaRep.clear();
    }

    public int size() {
        return colaRep.size();
    }

    public boolean estaVacia() {
        return colaRep.isEmpty();
    }

    public Cancion obtener(int indice) {
        return colaRep.get(indice);
    }

    public boolean contieneCancion(Cancion cancion) {
        return colaRep.contiene(cancion);
    }

    public int posicionCancion(Cancion cancion) {
        return colaRep.indexOf(cancion);
    }
}
