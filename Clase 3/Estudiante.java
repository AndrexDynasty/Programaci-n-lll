public class Estudiante {
    // Atributos
    private int id;
    private String nombre;
    private String facultad;

    // constructor

    public Estudiante(int id, String nombre, String facultad) {
        this.id = id;
        this.nombre = nombre;
        this.facultad = facultad;
    }

    public String toString() {
        return "Estudiante { id: " + id + " nombre: " + nombre + " facultad " + facultad + "}";
    }

    public int cantidadEstudiantes(String facultad) {
        // logica del metodo
        return 0;

    }
}