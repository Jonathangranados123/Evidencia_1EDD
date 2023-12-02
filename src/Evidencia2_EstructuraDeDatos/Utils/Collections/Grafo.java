package Evidencia2_EstructuraDeDatos.Utils.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import Evidencia2_EstructuraDeDatos.Utils.*;
/**
 * Clase que representa un grafo con vértices y aristas.
 */
public class Grafo {
    private final HashMap<Vertice, ArrayList<Arista>> vertices;

    /**
     * Constructor que crea un nuevo grafo vacío.
     */
    public Grafo() {
        this.vertices = new HashMap<>();
    }

    /**
     * Agrega un vértice al grafo con el nombre especificado.
     *
     * @param name El nombre del vértice que se agregará al grafo.
     */
    public void addVertice(String name) {
        vertices.put(new Vertice(name), new ArrayList<Arista>());
    }

    /**
     * Agrega una arista al grafo con los vértices de inicio, fin y peso especificados.
     *
     * @param v1     El nombre del vértice de inicio de la arista.
     * @param v2     El nombre del vértice de fin de la arista.
     * @param weight El peso de la arista.
     */
    public void addArista(String v1, String v2, double weight) {
        vertices.get(new Vertice(v1)).add(new Arista(new Vertice(v1), new Vertice(v2), weight));
    }

    /**
     * Obtiene las aristas adyacentes a un vértice especificado.
     *
     * @param vertice El vértice del cual se desean obtener las aristas adyacentes.
     * @return Una lista de aristas adyacentes al vértice.
     */
    public ArrayList<Arista> getAdyacencias(Vertice vertice) {
        return vertices.get(vertice);
    }

    /**
     * Obtiene la cantidad de vértices en el grafo.
     *
     * @return El número de vértices en el grafo.
     */
    public int Size() {
        return vertices.size();
    }

    /**
     * Devuelve una representación en cadena del grafo, mostrando los vértices y sus aristas.
     *
     * @return Una cadena que representa el contenido del grafo.
     */
    @Override
    public String toString() {
        return vertices.toString();
    }
}
