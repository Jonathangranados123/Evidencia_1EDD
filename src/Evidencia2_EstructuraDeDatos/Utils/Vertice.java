package Evidencia2_EstructuraDeDatos.Utils;

/**
 * Clase que representa un vértice en un grafo.
 */
public class Vertice {
    private final String name;

    /**
     * Constructor que crea un nuevo vértice con el nombre especificado.
     *
     * @param name El nombre del vértice.
     */
    public Vertice(String name) {
        this.name = name;
    }

    /**
     * Compara si este vértice es igual a otro objeto. Dos vértices son iguales si tienen el mismo nombre.
     *
     * @param o El objeto con el que se compara este vértice.
     * @return true si los vértices son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof Vertice && ((Vertice) o).getName().equals(name);
    }

    /**
     * Calcula el código hash de este vértice basado en su nombre.
     *
     * @return El código hash del vértice.
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * Devuelve una representación en cadena de este vértice.
     *
     * @return Una cadena que representa el vértice en el formato "Vertice: nombre".
     */
    public String toString() {
        return "Vertice: " + name;
    }

    /**
     * Obtiene el nombre de este vértice.
     *
     * @return El nombre del vértice.
     */
    public String getName() {
        return name;
    }
}
