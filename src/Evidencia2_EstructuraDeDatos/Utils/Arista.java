package Evidencia2_EstructuraDeDatos.Utils;

import java.lang.Comparable;

/**
 * Clase que representa una arista en un grafo ponderado, con vértices de inicio y fin, y un peso asociado.
 */
public class Arista implements Comparable<Arista> {
    private final Vertice v1; // Vértice de inicio de la arista
    private final Vertice v2; // Vértice de fin de la arista
    private final double weight; // Peso de la arista

    /**
     * Constructor que crea una nueva arista con los vértices de inicio, fin y peso especificados.
     *
     * @param v1     El vértice de inicio de la arista.
     * @param v2     El vértice de fin de la arista.
     * @param weight El peso de la arista.
     */
    public Arista(Vertice v1, Vertice v2, double weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    /**
     * Devuelve una representación en cadena de la arista en el formato "v1 -> (weight) -> v2".
     *
     * @return Una cadena que representa la arista.
     */
    @Override
    public String toString() {
        return v1.getName() + " -> (" + weight + ") -> " + v2.getName();
    }

    /**
     * Obtiene el vértice de inicio de la arista.
     *
     * @return El vértice de inicio de la arista.
     */
    public Vertice getV1() {
        return v1;
    }

    /**
     * Obtiene el vértice de fin de la arista.
     *
     * @return El vértice de fin de la arista.
     */
    public Vertice getV2() {
        return v2;
    }

    /**
     * Obtiene el peso de la arista.
     *
     * @return El peso de la arista.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Compara esta arista con otra arista en función de sus pesos.
     *
     * @param a2 La arista con la que se compara esta arista.
     * @return Un valor negativo si esta arista tiene un peso menor, un valor positivo si tiene un peso mayor y 0 si son iguales.
     */
    @Override
    public int compareTo(Arista a2) {
        if (weight < a2.getWeight())
            return -1;
        if (weight > a2.getWeight())
            return 1;
        return 0;
    }

    /**
     * Compara si esta arista es igual a otra arista. Dos aristas son iguales si comparten los mismos vértices de inicio y fin.
     *
     * @param o La arista con la que se compara esta arista.
     * @return true si las aristas son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (v2 == null || ((Arista) o).getV2() == null) {
            return v1.equals(((Arista) o).getV1());
        }
        return o instanceof Arista && ((Arista) o).getV1().equals(v2) || ((Arista) o).getV2().equals(v2);
    }
}
