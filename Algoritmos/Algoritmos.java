package Algoritmos;

import java.util.Arrays;

public class Algoritmos {

    // -------------------- ALGORITMO DE DIJKSTRA --------------------
    public static void dijkstra(int[][] grafo, int inicio) {
        int n = grafo.length;
        int[] distancia = new int[n];
        boolean[] visitado = new boolean[n];

        // Inicializar distancias
        for (int i = 0; i < n; i++) {
            distancia[i] = Integer.MAX_VALUE;
            visitado[i] = false;
        }
        distancia[inicio] = 0;

        // Calcular las distancias más cortas
        for (int i = 0; i < n - 1; i++) {
            int u = verticeMinimo(distancia, visitado, n);
            visitado[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visitado[v] && grafo[u][v] != 0 &&
                    distancia[u] != Integer.MAX_VALUE &&
                    distancia[u] + grafo[u][v] < distancia[v]) {
                    distancia[v] = distancia[u] + grafo[u][v];
                }
            }
        }

        // Mostrar resultados
        System.out.println("Distancias más cortas desde el vértice " + inicio + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Hasta " + i + " = " + distancia[i]);
        }
    }

    public static int verticeMinimo(int[] distancia, boolean[] visitado, int n) {
        int min = Integer.MAX_VALUE, indiceMin = -1;
        for (int v = 0; v < n; v++) {
            if (!visitado[v] && distancia[v] <= min) {
                min = distancia[v];
                indiceMin = v;
            }
        }
        return indiceMin;
    }

    // -------------------- ORDENAMIENTO BURBUJA --------------------
    public static void burbuja(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // -------------------- ORDENAMIENTO POR INSERCIÓN --------------------
    public static void insercion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int clave = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > clave) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = clave;
        }
    }

    // -------------------- ORDENAMIENTO POR SELECCIÓN --------------------
    public static void seleccion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    // -------------------- QUICK SORT --------------------
    public static void quickSort(int[] arr, int izq, int der) {
        if (izq < der) {
            int pi = particion(arr, izq, der);
            quickSort(arr, izq, pi - 1);
            quickSort(arr, pi + 1, der);
        }
    }

    public static int particion(int[] arr, int izq, int der) {
        int pivote = arr[der];
        int i = (izq - 1);
        for (int j = izq; j < der; j++) {
            if (arr[j] < pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[der];
        arr[der] = temp;
        return i + 1;
    }

    // -------------------- MERGE SORT --------------------
    public static void mergeSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            mergeSort(arr, inicio, medio);
            mergeSort(arr, medio + 1, fin);
            merge(arr, inicio, medio, fin);
        }
    }

    public static void merge(int[] arr, int inicio, int medio, int fin) {
        int n1 = medio - inicio + 1;
        int n2 = fin - medio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[inicio + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[medio + 1 + j];

        int i = 0, j = 0, k = inicio;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // -------------------- PROGRAMA PRINCIPAL --------------------
    public static void main(String[] args) {

        // --- Dijkstra ---
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

        System.out.println("==== Algoritmo de Dijkstra ====");
        dijkstra(grafo, 0);

        // --- Ordenamientos ---
        int[] datos = {64, 25, 12, 22, 11};

        System.out.println("\n==== Métodos de Ordenamiento ====");
        System.out.println("Arreglo original: " + Arrays.toString(datos));

        int[] copia = datos.clone();
        burbuja(copia);
        System.out.println("Burbuja: " + Arrays.toString(copia));

        copia = datos.clone();
        insercion(copia);
        System.out.println("Inserción: " + Arrays.toString(copia));

        copia = datos.clone();
        seleccion(copia);
        System.out.println("Selección: " + Arrays.toString(copia));

        copia = datos.clone();
        quickSort(copia, 0, copia.length - 1);
        System.out.println("Quick Sort: " + Arrays.toString(copia));

        copia = datos.clone();
        mergeSort(copia, 0, copia.length - 1);
        System.out.println("Merge Sort: " + Arrays.toString(copia));
    }
}

