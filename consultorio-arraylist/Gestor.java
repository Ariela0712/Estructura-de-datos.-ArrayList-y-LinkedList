public class Gestor {
    private ArrayList<Paciente> salaEspera;

    public Gestor() {
        this.salaEspera = new ArrayList<>();
    }

    public void anadirPaciente(Paciente paciente) {
        if (!validarPaciente(paciente)) {
            return;
        }
        salaEspera.add(paciente);
        System.out.println("Paciente anadido correctamente");
    }

    public void agregarPaciente(Paciente paciente, int indice) {
        if (!validarPaciente(paciente)) {
            return;
        }
        salaEspera.add(paciente, indice);
        System.out.println("Paciente agregado correctamente");
    }

    private boolean validarPaciente(Paciente paciente) {
        if (paciente == null) {
            System.out.println("Error, El paciente no puede ser null");
            return false;
        }
        if (paciente.getNombre() == null || paciente.getNombre().trim().isEmpty()) {
            System.out.println("Error, El nombre no puede estar vacio o nulo");
            return false;
        }
        if (!paciente.getNombre().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ]+( [a-zA-ZáéíóúÁÉÍÓÚñÑüÜ]+)*")) {
            System.out.println("Error, El nombre solo puede contener letras y espacios");
            return false;
        }
        if (paciente.getId() == null || paciente.getId().trim().isEmpty()) {
            System.out.println("Error, El id no puede estar vacio o nulo");
            return false;
        }
        if (!paciente.getId().matches("[0-9]+")) {
            System.out.println("Error, El id solo puede contener numeros");
            return false;
        }
        if (paciente.getEdad() <= 0) {
            System.out.println("Error, La edad debe ser mayor que 0");
            return false;
        }
        return true;
    }

    public Paciente obtenerPaciente(int indice) {
        return salaEspera.get(indice);
    }

    public boolean sonIguales(Paciente primero, Paciente segundo) {
        if (primero == null || segundo == null) {
            return primero == segundo;
        }
        return primero.getId().equals(segundo.getId());
    }

    public Paciente removerPaciente(int indice) {
        return salaEspera.remove(indice);
    }

    public Paciente atenderSiguientePaciente() {
        if (salaEspera.isEmpty()) {
            System.out.println("No hay pacientes en la sala de espera");
            return null;
        }
        Paciente atendido = salaEspera.remove(0);
        System.out.println("Paciente atendido: " + atendido);
        return atendido;
    }

    public int tamanoSala() {
        return salaEspera.size();
    }

    public void mostrarSalaEspera() {
        salaEspera.mostrar();
    }
}