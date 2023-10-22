package Evidencia2_EstructuraDeDatos.Utils;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Stack;

import Evidencia2_EstructuraDeDatos.Utils.*;
import Evidencia2_EstructuraDeDatos.Utils.Collections.Grafo;
/**
 * Clase que contiene métodos para realizar búsquedas en un grafo y calcular el algoritmo de Dijkstra y el algoritmo PRIM.
 */
public class SearchGraph {

    /**
     * Realiza una búsqueda en amplitud (BFS) en un grafo desde un vértice de inicio hasta un vértice objetivo.
     *
     * @param grafo    El grafo en el que se realizará la búsqueda.
     * @param inicio   El vértice de inicio de la búsqueda.
     * @param objetivo El vértice objetivo al que se desea llegar.
     * @return El vértice objetivo si se encuentra, o null si no se encuentra.
     */
    public static Vertice BusquedaAmplitud(Grafo grafo, String inicio, String objetivo) {

        var target = new Vertice(objetivo);

        if (target.equals(new Vertice(inicio))) return target;

        LinkedList<Arista> visited = new LinkedList<Arista>();
        LinkedList<Arista> queue = new LinkedList<Arista>();

        queue = new LinkedList<Arista>(grafo.getAdyacencias(new Vertice(inicio)));


        while (!queue.isEmpty()) {

            var currentEdge = queue.poll();
            if (currentEdge.getV2().equals(target)) {
                return currentEdge.getV2();
            } else {
                visited.add(currentEdge);
                queue.addAll(new LinkedList<Arista>(grafo.getAdyacencias(currentEdge.getV2())));
                queue.removeAll(visited);
            }
        }

        return null;
    }
    /**
     * Realiza una búsqueda en profundidad (DFS) en un grafo desde un vértice de inicio hasta un vértice objetivo.
     *
     * @param grafo    El grafo en el que se realizará la búsqueda.
     * @param inicio   El vértice de inicio de la búsqueda.
     * @param objetivo El vértice objetivo al que se desea llegar.
     * @return El vértice objetivo si se encuentra, o null si no se encuentra.
     */
    public static Vertice BusquedaProfundidad(Grafo grafo, String inicio, String objetivo){

        var target = new Vertice(objetivo);
        if(target.equals(new Vertice(inicio))) return target;

        var stack = new Stack<Arista>();
        var visited = new Stack<Arista>();

        stack.addAll(grafo.getAdyacencias(new Vertice(inicio)));
        while (!stack.isEmpty()) {
            var current = stack.pop();
            if(current.getV2().equals(target)){
                return current.getV2();
            }
            visited.push(current);
            stack.addAll(grafo.getAdyacencias(current.getV2()));
            stack.removeAll(visited);
        }
        return null;
    }
    /**
     * Calcula la distancia más corta entre un vértice de inicio y un vértice objetivo utilizando el algoritmo de Dijkstra.
     *
     * @param grafo    El grafo en el que se realizará el cálculo.
     * @param inicio   El vértice de inicio del cálculo.
     * @param objetivo El vértice objetivo al que se desea llegar.
     * @return La distancia más corta entre los vértices de inicio y objetivo.
     */
    public static double dijkstra(Grafo grafo, String inicio, String objetivo){
        PriorityQueue<Arista> pq = new PriorityQueue<>();

        pq.add(new Arista(new Vertice(inicio), null, 0));
        HashMap<Vertice, Double> dist = new HashMap();
        dist.put(new Vertice(inicio),0.0);

        while (!pq.isEmpty()) {

            var curr = pq.poll();

            for (var edge : grafo.getAdyacencias(curr.getV1())) {

                var adj_node = edge.getV2();
                var length_to_adjnode = edge.getWeight();

                if (dist.get(adj_node) == null || dist.get(adj_node) > length_to_adjnode + dist.get(curr.getV1())) {

                    if (dist.get(adj_node) != null) {
                        pq.remove(new Arista(adj_node,null, dist.get(adj_node)));
                    }
                    dist.put(adj_node, length_to_adjnode + dist.get(curr.getV1()));
                    pq.add(new Arista(adj_node,null, dist.get(adj_node)));
                }
            }
        }

        return dist.get(new Vertice(objetivo));
    }
    /**
     * Calcula el árbol de expansión mínima de un grafo utilizando el algoritmo de Prim.
     *
     * @param grafo  El grafo en el que se realizará el cálculo del árbol de expansión mínima.
     * @param inicio El vértice de inicio del cálculo.
     * @return El peso total del árbol de expansión mínima.
     */
    public static int PRIM(Grafo grafo, String inicio){
        var pq = new PriorityQueue<Arista>();
        var visited = new LinkedList<Vertice>();

        pq.add(new Arista(new Vertice(inicio), null, 0));
        int s=0;
        while(!pq.isEmpty()){
            var node =pq.poll();
            if(visited.contains(node.getV1()))
                continue;

            var v = node.getV1();
            var wt = node.getWeight();
            s+=wt;
            visited.add(v);

            for(var it:grafo.getAdyacencias(v))
            {
                if(!visited.contains(it.getV2()))
                {
                    pq.add(new Arista(it.getV2(), null, it.getWeight()));
                }
            }
        }
        return s;
    }

}
