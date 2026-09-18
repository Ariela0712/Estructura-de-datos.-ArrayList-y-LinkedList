public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();

        gestor.anadirPaciente(new Paciente("Julieta", "001", 24, false));
        gestor.anadirPaciente(new Paciente("Kayden", "002", 35, false));
        gestor.anadirPaciente(new Paciente("Romeo", "003", 60, false));

        Paciente esperado = new Paciente("Julieta", "001", 24, false);
        Paciente obtenido = gestor.obtenerPaciente(0);
        System.out.println("\nObteniendo paciente en la posicion 0: "+obtenido+" - "+(gestor.sonIguales(esperado, obtenido) ? "Correcto" : "Incorrecto"));

        Paciente prioritario = new Paciente("Antonetta", "004", 70, true);
        gestor.agregarPaciente(prioritario, 0);
        System.out.println("Agregando paciente prioritario en la posicion 0: "+prioritario+" - "+(gestor.sonIguales(prioritario, gestor.obtenerPaciente(0)) ? "Correcto" : "Incorrecto"));
        System.out.println("Verificando que el paciente en la posicion 1 es el esperado: "+ (gestor.sonIguales(esperado, gestor.obtenerPaciente(1)) ? "Correcto: "+gestor.obtenerPaciente(1) : "Incorrecto"));
        System.out.println("Verificar tamano de la lista: "+ (gestor.tamanoSala() == 4 ? "Correcto: " + gestor.tamanoSala() : "Incorrecto"));

        int tamanoI = gestor.tamanoSala();
        Paciente removido = gestor.removerPaciente(1);
        System.out.println("\nRemoviendo paciente en la posicion 1: "+ (gestor.sonIguales(removido, esperado) ? "Correcto: "+removido+"(eliminado)" : "Incorrecto"));
        System.out.println("Verificando que el tamano de la lista disminuyo en 1: "+ (gestor.tamanoSala() == tamanoI - 1 ? "Correcto: Tamano: "+gestor.tamanoSala() : "Incorrecto"));

        Paciente atendido = gestor.atenderSiguientePaciente();
        System.out.println("Atendiendo al paciente prioritario: "+ (gestor.sonIguales(atendido, prioritario) ? "Correcto" : "Incorrecto"));

        try {
            gestor.agregarPaciente(new Paciente("Luna", "005", 30, false), 10);
            System.out.println("Agregando paciente en un indice fuera de rango: Incorrecto, error no fue manejado");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Agregando paciente en un indice fuera de rango: Correcto manejo del error: "+e.getMessage());
        }

        try {
            gestor.obtenerPaciente(100);
            System.out.println("Accediendo a un indice fuera de rango: Incorrecto, error no fue manejado");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Accediendo a un indice fuera de rango: Correcto manejo del error: "+e.getMessage());
        }

        try {
            gestor.removerPaciente(120);
            System.out.println("Eliminando elemento de un indice fuera de rango: Incorrecto, error no fue manejado");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Eliminando elemento de un indice fuera de rango: Correcto manejo del error: "+e.getMessage());
        }

        System.out.println("\nPruebas negativas de tipo de dato:");
        gestor.anadirPaciente(null);
        gestor.anadirPaciente(new Paciente("", "006", 30, false));
        gestor.anadirPaciente(new Paciente(null, "007", 30, false));
        gestor.anadirPaciente(new Paciente("Ana123", "010", 30, false));
        gestor.anadirPaciente(new Paciente("Maria@", "011", 30, false));
        gestor.anadirPaciente(new Paciente("Ana", "", 30, false));
        gestor.anadirPaciente(new Paciente("Ana", null, 30, false));
        gestor.anadirPaciente(new Paciente("Pedro", "A09B", 30, false));
        gestor.anadirPaciente(new Paciente("Lucia", "008", 0, false));
        gestor.anadirPaciente(new Paciente("Annabelle", "009", -5, false));

        System.out.println("\nAtendiendo en una sala vacia:");
        Gestor gestorVacio = new Gestor();
        System.out.println(gestorVacio.atenderSiguientePaciente() == null ? "Correcto: no se puede atender" : "Incorrecto");

        System.out.println("\nSala de espera:");
        gestor.mostrarSalaEspera();
    }
}
