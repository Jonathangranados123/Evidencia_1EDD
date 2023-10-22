package Evidencia2_EstructuraDeDatos.KruskalUtils;

/**
 * Clase que representa una arista en un grafo ponderado con un vértice de inicio, un vértice de fin y un peso.
 */
public class Edge {
    int src;       // Vértice de inicio de la arista
    int dest;      // Vértice de fin de la arista
    public int weight; // Peso de la arista

    /**
     * Constructor que crea una nueva arista con el vértice de inicio, vértice de fin y peso especificados.
     *
     * @param src    El vértice de inicio de la arista.
     * @param dest   El vértice de fin de la arista.
     * @param weight El peso de la arista.
     */
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}
