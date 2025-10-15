package ParcialI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamenPilaMapa {

    static class PilaEnteros {
        private int[] datos;
        private int tope; // guarda la posición del último elemento

        public PilaEnteros(int capacidad) {
            datos = new int[capacidad];
            tope = -1; // pila vacía
        }

        public boolean estaVacia() { return tope == -1; }
        public boolean estaLlena() { return tope + 1 == datos.length; }

        public void apilar(int x) {
            if (estaLlena()) throw new IllegalStateException("Pila llena");
            tope++;
            datos[tope] = x; // agrego el valor a la pila
        }

        public int desapilar() {
            if (estaVacia()) throw new IllegalStateException("Pila vacía");
            int v = datos[tope]; // tomo el último agregado
            tope--;
            return v;
        }
    }

    // Comprueba si los paréntesis están bien balanceados
    public static boolean esBalanceado(String s) {
        PilaEnteros pila = new PilaEnteros(s.length());

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // cada "(" lo guardo en la pila
                pila.apilar(1);
            } else if (c == ')') {
                // si quiero cerrar y no hay nada, está mal
                if (pila.estaVacia()) {
                    return false;
                }
                pila.desapilar();
            }
        }
        // si la pila queda vacía, todo cerró bien
        return pila.estaVacia();
    }

    // Actualiza una nota si el ID existe y está en el rango 0 a 100
    public static boolean actualizarCalificacion(Map<Integer,Integer> califPorId, int id, int nota) {
        // Revisamos que la nota sea válida
        if (nota < 0 || nota > 100) {
            return false;
        }

        // Revisamos que el ID esté en el mapa
        if (!califPorId.containsKey(id)) {
            return false;
        }

        // Todo correcto, actualizamos la nota
        califPorId.put(id, nota);
        return true;
    }

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        System.out.println("Balanceado: " + esBalanceado(cadena));

        Map<Integer,Integer> mapa = new HashMap<Integer,Integer>();
        mapa.put(101, 70);
        System.out.println("Actualizado: " + actualizarCalificacion(mapa, 101, 95));

        sc.close();
    }
}
