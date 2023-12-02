package Evidencia2_EstructuraDeDatos.KruskalUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * Clase que implementa el algoritmo de Kruskal para encontrar el árbol de expansión mínima de un grafo.
 */
public class Kruskal {
    /**
     * Encuentra el árbol de expansión mínima de un grafo utilizando el algoritmo de Kruskal.
     *
     * @param V     El número de vértices en el grafo.
     * @param edges La lista de aristas del grafo.
     */
    public static void kruskals(int V, List<Edge> edges)
    {
        int j = 0;
        int noOfEdges = 0;

        Subset subsets[] = new Subset[V];

        Edge results[] = new Edge[V];

        for (int i = 0; i < V; i++) {
            subsets[i] = new Subset(i, 0);
        }

        while (noOfEdges < V - 1) {

            Edge nextEdge = edges.get(j);
            int x = findRoot(subsets, nextEdge.src);
            int y = findRoot(subsets, nextEdge.dest);


            if (x != y) {
                results[noOfEdges] = nextEdge;
                union(subsets, x, y);
                noOfEdges++;
            }

            j++;
        }


        System.out.println(
                "A continuación se detallan las aristas de lo construido kruskal:");
        int minCost = 0;
        for (int i = 0; i < noOfEdges; i++) {
            System.out.println(results[i].src + " -- "
                    + results[i].dest + " == "
                    + results[i].weight);
            minCost += results[i].weight;
        }
        System.out.println("Monto total de kruskal: " + minCost);
    }
    /**
     * Realiza la unión de dos conjuntos en la estructura de conjuntos disjuntos (Disjoint Set).
     *
     * @param subsets El arreglo de conjuntos disjuntos.
     * @param x       El representante del primer conjunto.
     * @param y       El representante del segundo conjunto.
     */
    private static void union(Subset[] subsets, int x,
                              int y)
    {
        int rootX = findRoot(subsets, x);
        int rootY = findRoot(subsets, y);

        if (subsets[rootY].rank < subsets[rootX].rank) {
            subsets[rootY].parent = rootX;
        }
        else if (subsets[rootX].rank
                < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        }
        else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }
    /**
     * Encuentra el representante (raíz) de un conjunto en la estructura de conjuntos disjuntos.
     *
     * @param subsets El arreglo de conjuntos disjuntos.
     * @param i       El índice del elemento cuyo representante se busca.
     * @return El representante (raíz) del conjunto al que pertenece el elemento.
     */
    private static int findRoot(Subset[] subsets, int i)
    {
        if (subsets[i].parent == i)
            return subsets[i].parent;

        subsets[i].parent
                = findRoot(subsets, subsets[i].parent);
        return subsets[i].parent;
    }
}