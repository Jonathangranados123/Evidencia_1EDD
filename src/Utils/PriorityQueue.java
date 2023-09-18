package Utils;

import java.util.ArrayList;
import java.util.List;
/**
 * Esta clase implementa una cola de prioridad genérica.
 * Los elementos en la cola deben ser comparables.
 * La cola tiene una capacidad máxima y ofrece métodos para agregar, retirar y consultar elementos.
 */

public class PriorityQueue<T extends Comparable<T>> {
    private List<T> data; // Lista que almacena los elementos de la cola de prioridad
    private int capacidad; // Capacidad máxima de la cola de prioridad

    /**
     * Constructor de la cola de prioridad.
     * @param capacidad Capacidad máxima de la cola de prioridad.
     */
    public PriorityQueue( int capacidad) {
        this.capacidad = capacidad;
        this.data = new ArrayList<T>(capacidad);
    }

    /**
     * Agrega un elemento a la cola de prioridad.
     * @param item Elemento a agregar.
     */
    public synchronized void offer(T item) {
        if(data.size() >= capacidad) {
            System.out.println("Elemento Rechazado. La cola esta llena");
            return;
        }
         // Este bucle itera a través de los elementos de la lista 'data'.
        for(int i=0; i< data.size(); i++){

            // Se verifica si el elemento actual en la posición 'i' es menor que el elemento que se está intentando
            // agregar ('item').
            if(data.get(i).compareTo(item) < 0){

                // Si el elemento actual es menor, entonces 'item' debe ser insertado en esta posición 'i'.
                data.add(i, item);

                // La operación se completa y no es necesario continuar buscando.
                return;
            }
        }

        // Si no se encontró ningún elemento menor, 'item' se añade al final de la lista.
        data.add(item);

        System.out.println("Elemento insertado. Esperando servidor");
    }

    /**
     * Muestra y elimina el elemento de mayor prioridad de la cola.
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
