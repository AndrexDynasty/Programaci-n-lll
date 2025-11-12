package Algoritmos;

import java.util.*;

public class Lista {


    public static List<List<int[]>> convertirAMatrizLista(int[][] grafo) {
        int n = grafo.length;
        List<List<int[]>> lista = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            lista.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (grafo[i][j] != 0) { // Hay conexión
                    lista.get(i).add(new int[]{j, grafo[i][j]});
                }
            }
        }
        return lista;
    }

 
    public static int verticeMinimo(int[] distancia, boolean[] visitado) {
        int min = Integer.MAX_VALUE, indice = -1;
        for (int v = 0; v < distancia.length; v++) {
            if (!visitado[v] && distancia[v] <= min) {
                min = distancia[v];
                indice = v;
            }
        }
        return indice;
    }

   
    public static void dijkstraLista(List<List<int[]>> lista, int inicio) {
        int n = lista.size();
        int[] distancia = new int[n];
        boolean[] visitado = new boolean[n];

        Arrays.fill(distancia, Integer.MAX_VALUE);
        distancia[inicio] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = verticeMinimo(distancia, visitado);
            visitado[u] = true;

            for (int[] arista : lista.get(u)) {
                int v = arista[0];
                int peso = arista[1];

                if (!visitado[v] && distancia[u] != Integer.MAX_VALUE
                        && distancia[u] + peso < distancia[v]) {
                    distancia[v] = distancia[u] + peso;
                }
            }
        }

        
        System.out.println("Distancias más cortas desde el vértice " + inicio + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Hasta " + i + " = " + distancia[i]);
        }
    }
    public static void main(String[] args) {

        int[][] grafo = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

       
        List<List<int[]>> listaAdyacencia = convertirAMatrizLista(grafo);

       
        System.out.println(" Lista de Adyacencia ");
        for (int i = 0; i < listaAdyacencia.size(); i++) {
            System.out.print("Vértice " + i + " -> ");
            for (int[] arista : listaAdyacencia.get(i)) {
                System.out.print("(" + arista[0] + ", peso=" + arista[1] + ") ");
            }
            System.out.println();
        }

     
       
        dijkstraLista(listaAdyacencia, 0);
    }
}
