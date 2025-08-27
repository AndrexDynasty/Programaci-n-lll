public class Libro {
     // Atributos
    private double precio;
    private String Titulo;
    private int id;
     // constructor
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getTitulo() {
        return Titulo;
    }
    public Libro(double precio, String titulo, int id) {
        this.precio = precio;
        Titulo = titulo;
        this.id = id;
    }
    @Override
    public String toString() {
        return "Libro [precio=" + precio + ", Titulo=" + Titulo + ", id=" + id + "]";
    }
    public void setTitulo(String titulo) {
        Titulo = titulo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
