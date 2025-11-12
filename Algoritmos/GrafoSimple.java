package Algoritmos;

import java.util.*;

public class GrafoSimple {

    public static List<int[]> convertirALista(int[][] grafo) {
        List<int[]> lista = new ArrayList<>();
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo[i].length; j++) {
                if (grafo[i][j] != 0) {
                    lista.add(new int[]{i, j, grafo[i][j]}); // {origen, destino, peso}
                }
            }
        }
        return lista;
    }

    public static int[] dijkstra(int[][] grafo, int inicio) {
        int n = grafo.length;
        int[] dist = new int[n];
        boolean[] visitado = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[inicio] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = minimo(dist, visitado);
            if (u == -1) break;
            visitado[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visitado[v] && grafo[u][v] != 0 &&
                        dist[u] + grafo[u][v] < dist[v]) {
                    dist[v] = dist[u] + grafo[u][v];
                }
            }
        }
        return dist;
    }

    public static int minimo(int[] dist, boolean[] visitado) {
        int min = Integer.MAX_VALUE, idx = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visitado[i] && dist[i] < min) {
                min = dist[i];
                idx = i;
            }
        }
        return idx;
    }

  
    public static void quickSort(int[] arr, int izq, int der) {
        if (izq < der) {
            int pi = particion(arr, izq, der);
            quickSort(arr, izq, pi - 1);
            quickSort(arr, pi + 1, der);
        }
    }

    public static int particion(int[] arr, int izq, int der) {
        int pivote = arr[der];
        int i = izq - 1;
        for (int j = izq; j < der; j++) {
            if (arr[j] < pivote) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[der]; arr[der] = temp;
        return i + 1;
    }

    public static int obtenerMenor(int[] dist) {
        int[] validos = Arrays.stream(dist)
                .filter(x -> x != 0 && x != Integer.MAX_VALUE)
                .toArray();
        quickSort(validos, 0, validos.length - 1);
        return validos[0];
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

       
        List<int[]> lista = convertirALista(grafo);
        System.out.println(" Lista de conexiones ");
        for (int[] c : lista) {
            System.out.println("De " + c[0] + " a " + c[1] + " (peso " + c[2] + ")");
        }

       
        int[] distancias = dijkstra(grafo, 0);

       
        System.out.println("\nDistancias calculadas: " + Arrays.toString(distancias));

        System.out.println("La menor distancia encontrada es: " + obtenerMenor(distancias));
    }
}