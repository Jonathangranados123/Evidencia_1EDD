package Evidencia2_EstructuraDeDatos.KruskalUtils;

/**
 * Clase que representa un conjunto (subset) utilizado en la estructura de datos de conjuntos disjuntos (Disjoint Set).
 * Cada conjunto disjunto tiene un representante (parent) y un valor de rango (rank) utilizado para la optimización.
 */
public class Subset {
    int parent; // Representante del conjunto (vértice principal)
    int rank;   // Valor de rango del conjunto

    /**
     * Constructor que crea un nuevo conjunto disjunto con el representante (parent) y el valor de rango (rank) especificados.
     *
     * @param parent Representante del conjunto (vértice principal).
     * @param rank   Valor de rango del conjunto para optimización.
     */
    public Subset(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }
}
