package Evidencia2_EstructuraDeDatos;
import Evidencia2_EstructuraDeDatos.KruskalUtils.*;
import Evidencia2_EstructuraDeDatos.Utils.Collections.Grafo;
import Evidencia2_EstructuraDeDatos.Utils.SearchGraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Clase principal que contiene el método `main` para ejecutar las operaciones en un grafo y el algoritmo de Kruskal.
 */
public class Main {
    /**
     * Método principal que ejecuta las operaciones en un grafo y el algoritmo de Kruskal.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        // Definición de constantes y creación de un grafo
        final double peso = 0;
        final String CINCO = "5";
        final String CUATRO = "4";
        final String TRES = "3";
        final String OCHO = "8";
        final String QUINCE = "15";
        final String DIEZ = "10";
        final String NUEVE = "9";

        // Agregando vértices al grafo
        var grafo = new Grafo();
        grafo.addVertice(CINCO);
        grafo.addVertice(CUATRO);
        grafo.addVertice(TRES);
        grafo.addVertice(OCHO);
        grafo.addVertice(QUINCE);
        grafo.addVertice(DIEZ);
        grafo.addVertice(NUEVE);

        // Agregando aristas al grafo
        grafo.addArista(CINCO, OCHO, 5);
        grafo.addArista(OCHO, CINCO, 5);

        grafo.addArista(CINCO, CUATRO, 3);
        grafo.addArista(CUATRO, CINCO, 3);

        grafo.addArista(CUATRO, OCHO, 1);
        grafo.addArista(OCHO, CUATRO, 1);

        grafo.addArista(CUATRO, TRES, peso);
        grafo.addArista(TRES, CUATRO, peso);

        grafo.addArista(TRES, OCHO, peso);
        grafo.addArista(OCHO, TRES, peso);

        grafo.addArista(TRES, DIEZ, peso);
        grafo.addArista(DIEZ, TRES, peso);

        grafo.addArista(OCHO, QUINCE, peso);
        grafo.addArista(QUINCE, OCHO, peso);

        grafo.addArista(NUEVE, QUINCE, peso);
        grafo.addArista(QUINCE, NUEVE, peso);

        grafo.addArista(NUEVE, DIEZ, peso);
        grafo.addArista(DIEZ, NUEVE, peso);
// Realizar cálculo de distancia más corta utilizando Dijkstra o PRIM
        var ans = SearchGraph.dijkstra(grafo,CINCO, DIEZ);
        System.out.println(ans);



        //----------------------KRUSKAL------------------//
        int V = 4;
        List<Edge> graphEdges = new ArrayList<Edge>(
                List.of(new Edge(0, 1, 10), new Edge(0, 2, 6),
                        new Edge(0, 3, 5), new Edge(1, 3, 15),
                        new Edge(2, 3, 4)));
        // Ordenar las aristas por peso
        graphEdges.sort(new Comparator<Edge>() {
            public int compare(Edge o1, Edge o2)
            {
                return o1.weight - o2.weight;
            }
        });
        // Ejecutar el algoritmo de Kruskal
        Kruskal.kruskals(V, graphEdges);

    }
}