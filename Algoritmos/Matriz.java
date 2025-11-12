package Algoritmos;

import java.util.*;

public class Matriz {

   
    static List<List<int[]>> convertirALista(int[][] grafo) {
        List<List<int[]>> lista = new ArrayList<>();
        for (int i = 0; i < grafo.length; i++) {
            lista.add(new ArrayList<>());
            for (int j = 0; j < grafo.length; j++) {
                if (grafo[i][j] != 0) lista.get(i).add(new int[]{j, grafo[i][j]});
            }
        }
        return lista;
    }

    
    static int minimo(int[] dist, boolean[] vis) {
        int min = Integer.MAX_VALUE, idx = -1;
        for (int i = 0; i < dist.length; i++)
            if (!vis[i] && dist[i] < min) { min = dist[i]; idx = i; }
        return idx;
    }

    
    static void dijkstra(List<List<int[]>> lista, int inicio) {
        int n = lista.size();
        int[] dist = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[inicio] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = minimo(dist, vis);
            vis[u] = true;
            for (int[] arista : lista.get(u)) {
                int v = arista[0], peso = arista[1];
                if (!vis[v] && dist[u] + peso < dist[v])
                    dist[v] = dist[u] + peso;
            }
        }

        System.out.println("Distancias desde " + inicio + ": " + Arrays.toString(dist));
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

        List<List<int[]>> lista = convertirALista(grafo);
        dijkstra(lista, 0);
    }
}