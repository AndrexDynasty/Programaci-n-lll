package ParcialI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamenColaMapa2 {

    static class ColaCircularEnteros {
        private int[] datos;
        private int cabeza; // posición del primero
        private int cola;   // posición donde entra el siguiente
        private int tam;    // cuántos elementos hay

        public ColaCircularEnteros(int capacidad) {
            datos = new int[capacidad];
            cabeza = 0;
            cola = 0;
            tam = 0;
        }

        public boolean estaVacia() { return tam == 0; }
        public boolean estaLlena() { return tam == datos.length; }

        public void encolar(int x) {
            if (estaLlena()) throw new IllegalStateException("Cola llena");
            datos[cola] = x; // agrego el número al final
            cola = (cola + 1) % datos.length; // muevo la cola circularmente
            tam++;
        }

        public int desencolar() {
            if (estaVacia()) throw new IllegalStateException("Cola vacía");
            int v = datos[cabeza]; // saco el primero en entrar
            cabeza = (cabeza + 1) % datos.length; // muevo la cabeza circularmente
            tam--;
            return v;
        }
    }

    // Este método suma +1 por cada '(' y -1 por cada ')'
    public static int balanceConCola(String s) {
        // La cola solo la usamos para guardar los valores y luego sumarlos
        ColaCircularEnteros cola = new ColaCircularEnteros(s.length());

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // cada paréntesis de apertura cuenta como +1
                cola.encolar(1);
            } else if (c == ')') {
                // cada cierre cuenta como -1
                cola.encolar(-1);
            }
        }

        // Ahora sacamos todo y sumamos para ver el balance final
        int suma = 0;
        while (!cola.estaVacia()) {
            suma += cola.desencolar();
        }

        return suma;
    }

    // Registra cuántos intentos ha hecho una persona por su nombre
    public static int registrarIntento(Map<String,Integer> intentos, String nombre) {
        // Si ya existe el nombre, le aumento 1
        if (intentos.containsKey(nombre)) {
            int valor = intentos.get(nombre);
            valor = valor + 1;
            intentos.put(nombre, valor);
            return valor;
        } else {
            // Si es la primera vez, empieza en 1
            intentos.put(nombre, 1);
            return 1;
        }
    }

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        System.out.println("Balance cola: " + balanceConCola(cadena));

        Map<String,Integer> intentos = new HashMap<String,Integer>();
        System.out.println("Intentos (Ana): " + registrarIntento(intentos, "Ana"));
        System.out.println("Intentos (Ana): " + registrarIntento(intentos, "Ana"));

        sc.close();
    }
}
