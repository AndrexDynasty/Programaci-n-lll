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
    public String getFacultad(){
        return facultad;
    }
    public String getNombre(){
        return nombre;
    }

    public String toString() {
        return "Estudiante { id: " + id + " nombre: " + nombre + " facultad " + facultad + "}";
    }

    public int cantidadEstudiantes(String facultad) {
        // logica del metodo
        return 0;

    }
    //Método para saber cuántos estudiantes tiene una facultad
public int contarEstudiantes(Estudiante[] e, String nombreFacultad) {
    int contador = 0;
    for (int i = 0; i < e.length; i++) {
        if (e[i].getFacultad().equals(nombreFacultad)) {
            contador++;
        }
    }
    return contador;
}
//Método para mostrar todos los nombres de los estudiantes
public void mostrarNombres(Estudiante[] e) {
    for (int i = 0; i < e.length; i++) {
        System.out.println(e[i].getNombre());
    }
}

}