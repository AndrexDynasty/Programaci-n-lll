public class EjecutarEstudiante {
    public static void main(String[] args) {
        // creacion de objetos Estudiante
        Estudiante objEst1 = new Estudiante(768, "Byron", "Ingenieria");
        Estudiante objEst2 = new Estudiante(456, "juan", "Ingenieria");

        Estudiante[] e = new Estudiante[3];
        e[0] = objEst1;
        e[1] = objEst2;
        e[2] = new Estudiante(123, "Ana", "Ingenieria");

        for (int i = 0; i < e.length; i++) {
            System.out.println(e[i]);
        }
    }
   
}
  
