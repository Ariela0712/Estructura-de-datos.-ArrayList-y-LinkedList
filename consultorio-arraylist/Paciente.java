public class Paciente {
    private String nombre;
    private String id;
    private int edad;
    private boolean prioridad;

    public Paciente(String nombre, String id, int edad, boolean prioridad) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return "Paciente [nombre:"+nombre+", id:"+id+", edad:"+edad+", prioridad:"+prioridad+ "]";
    }
    
}
