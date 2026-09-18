public class Main {
    public static void main(String[] args) {

        Gestor g = new Gestor();

        System.out.println("Pruebas positivas: ");
        g.agregarCancion(new Cancion("Lovely", "Billie Eilish", 354));
        g.agregarCancion(new Cancion("Numb", "Linkin Park", 482));
        g.agregarCancionInd(new Cancion("Hotel California", "Eagles", 391), 1);
        System.out.println("\nCola de reproducción después de agregar canciones: ");
        g.mostrarCola();
        System.out.println("Tamaño de la cola: " + g.size());

        Cancion obtenida1 = g.obtener(0);
        boolean cancionCorrecta = obtenida1.getTitulo().equals("Lovely") && obtenida1.getArtista().equals("Billie Eilish")
        && obtenida1.getDuracionS() == 354;
        System.out.println("\nCanción en la posición 0: "+ (cancionCorrecta ? "Correcto: " + obtenida1 : "Incorrecto"));

        Cancion cancionAusente = new Cancion("Imagine", "John Lennon", 183);
        System.out.println("¿La canción en la posición 0 está en la cola?: "+(g.contieneCancion(obtenida1) ? "Correcto" : "Incorrecto"));
        System.out.println("Posición de la canción encontrada: " + g.posicionCancion(obtenida1));
        System.out.println("¿La cancion esta ausente?: "+(g.contieneCancion(cancionAusente) ? "Incorrecto" : "Correcto"));
        
        int tam = g.size();
        System.out.println("\nReproduciendo y retirando la primera canción:");
        System.out.println(g.reproducirSiguiente());
        System.out.println("Verificando el tamaño de la cola después de eliminar la primera canción: " + (g.size() == tam - 1 ? "Correcto: " + g.size() : "Incorrecto"));

        System.out.println("\nCola restante:");
        g.mostrarCola();

        System.out.println("\nCola invertida:");
        g.invertirCola();
        g.mostrarCola();

        System.out.println("\nPruebas negativas: ");
        g.agregarCancion(new Cancion("", "Pablo Lopez", 400));
        g.agregarCancion(new Cancion("Como mirarte", "   ", 450));
        g.agregarCancion(new Cancion(null, "Sebastian Yatra", 200));
        g.agregarCancion(new Cancion("Perfect@", "Ed Sheran", 500));
        g.agregarCancion(new Cancion("Snap", "Rosa Lin#", 200));
        g.agregarCancion(new Cancion("Shape of you", null, 300));
        g.agregarCancion(new Cancion("Kill me fats", "Three days Grace", 0));
        g.agregarCancion(new Cancion("Boulevard of Broken Dreams", "Green Day", -10));
        g.agregarCancion(null);
        
        System.out.println("\nCola de reproducción después de intentos de agregar canciones inválidas: ");
        g.mostrarCola();

         System.out.println("\nAgregar canción con índice fuera de rango: ");
        g.agregarCancionInd(new Cancion("Saturno", "Pablo Alboran", 500), 100);

        g.eliminarCancion(100);

        try {
            g.obtener(500);
            System.out.println("Accediendo a indice fuera de rango: Incorrecto, error no lanzado");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Accediendo a indice fuera de rango: Correcto, error manejado: " + e.getMessage());
        }
        
        System.out.println("\nLimpiando la cola: ");
        g.limpiarCola();
        System.out.println("\nVerificando si la cola está vacía después de limpiar: " + (g.estaVacia() ? "Correcto: Tamano: "+ g.size() : "Incorrecto"));
        Cancion siguiente = g.reproducirSiguiente();
        if (siguiente == null) {
            System.out.println("No se puede reproducir: la cola está vacía.");
        } else {
            System.out.println("Reproduciendo: " + siguiente);
        }
    }
}
