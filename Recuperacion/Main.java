package Recuperacion;

import java.util.*;

public class Main {

   

    static class Node {
        String name;
        Node(String name) { this.name = name; }
        public String toString() { return name; }
    }

    static class Edge {
        Node destino;
        int peso;

        Edge(Node destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }


    static class Graph {
        Map<Node, ArrayList<Edge>> adj = new HashMap<>();

        void addNode(Node n) {
            adj.putIfAbsent(n, new ArrayList<>());
        }

        void addEdge(Node a, Node b, int peso) {
            adj.get(a).add(new Edge(b, peso));
            adj.get(b).add(new Edge(a, peso)); 
        }

        Map<Node, ArrayList<Edge>> getAdj() {
            return adj;
        }
    }

    
    static Map<Node, Integer> dijkstra(Graph graph, Node inicio) {

        Map<Node, Integer> dist = new HashMap<>();

        for (Node n : graph.getAdj().keySet()) {
            dist.put(n, Integer.MAX_VALUE);
        }

        dist.put(inicio, 0);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));
        pq.add(inicio);

        while (!pq.isEmpty()) {
            Node actual = pq.poll();

            for (Edge e : graph.getAdj().get(actual)) {

                int nuevaDist = dist.get(actual) + e.peso;

                if (nuevaDist < dist.get(e.destino)) {
                    dist.put(e.destino, nuevaDist);
                    pq.add(e.destino);
                }
            }
        }

        return dist;
    }


    static void quickSort(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr.get(j) < pivot) {
                i++;
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        int temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i + 1;
    }

  

    public static void main(String[] args) {

        Graph g = new Graph();

        // Crear nodos (ciudades)
        Node cali = new Node("Cali");
        Node buga = new Node("Buga");
        Node tulua = new Node("Tuluá");
        Node armenia = new Node("Armenia");
        Node pereira = new Node("Pereira");
        Node manizales = new Node("Manizales");
        Node medellin = new Node("Medellín");
        Node monteria = new Node("Montería");
        Node sincelejo = new Node("Sincelejo");
        Node cartagena = new Node("Cartagena");

        Node[] ciudades = { cali, buga, tulua, armenia, pereira, manizales, medellin, monteria, sincelejo, cartagena };

        for (Node c : ciudades) g.addNode(c);

        // Agregar rutas con distancias
        g.addEdge(cali, buga, 60);
        g.addEdge(buga, tulua, 25);
        g.addEdge(tulua, armenia, 90);
        g.addEdge(armenia, pereira, 50);
        g.addEdge(pereira, manizales, 52);
        g.addEdge(manizales, medellin, 190);
        g.addEdge(medellin, monteria, 420);
        g.addEdge(monteria, sincelejo, 55);
        g.addEdge(sincelejo, cartagena, 190);

      
        Map<Node, Integer> distancias = dijkstra(g, cali);

        System.out.println("Distancias desde Cali:\n");

        List<Integer> valores = new ArrayList<>();

        for (Map.Entry<Node, Integer> e : distancias.entrySet()) {
            System.out.println(e.getKey().name + " -> " + e.getValue());
            valores.add(e.getValue());
        }

       
        quickSort(valores, 0, valores.size() - 1);

        System.out.println("\nRecorridos ordenados (menor a mayor):");
        System.out.println(valores);
    }
}
