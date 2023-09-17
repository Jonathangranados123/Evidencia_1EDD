package Evidencia1_EstructuraDeDatos.Utils;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<T extends Comparable<T>> {
    private List<T> data; // Lista que almacena los elementos de la cola de prioridad
    private int cap; // Capacidad máxima de la cola de prioridad

    /**
     * Constructor de la cola de prioridad.
     * @param cap Capacidad máxima de la cola de prioridad.
     */
    public PriorityQueue(int cap) {
        this.cap = cap;
        this.data = new ArrayList<T>(cap);
    }

    /**
     * Agrega un elemento a la cola de prioridad.
     * @param item Elemento a agregar.
     */
    public synchronized void offer(T item) {
        if(data.size() >= cap) {
            System.out.println("Elemento Rechazado. La cola esta llena");
            return;
        }

        for(int i=0; i< data.size(); i++){
            if(data.get(i).compareTo(item) < 0){
                data.add(i, item);
                return;
            }
        }
        data.add(item);
        System.out.println("Elemento insertado. Esperando servidor");
    }

    /**
     * Extrae y devuelve el elemento de mayor prioridad de la cola.
     * @return Elemento de mayor prioridad.
     */
    public synchronized T poll() {
        if(isEmpty()){
            System.out.println("La Cola esta vacia. No Hay Elementos que atender");
            return null;
        }

        System.out.println("Elemento atendido.");
        return data.remove(0);
    }

    /**
     * Devuelve el elemento de mayor prioridad sin extraerlo de la cola.
     * @return Elemento de mayor prioridad.
     */
    public T Peek() {
        return data.get(0);
    }

    /**
     * Obtiene el tamaño actual de la cola de prioridad.
     * @return Tamaño de la cola de prioridad.
     */
    public int size(){
        return data.size();
    }

    /**
     * Verifica si la cola de prioridad está vacía.
     * @return True si la cola está vacía, False en caso contrario.
     */
    public boolean isEmpty() {
        return data.size() == 0;
    }

    /**
     * Convierte la cola de prioridad a una representación en cadena de caracteres.
     * @return Representación en cadena de caracteres de la cola de prioridad.
     */
    public synchronized String toString(){
        return String.valueOf(data);
    }
}
