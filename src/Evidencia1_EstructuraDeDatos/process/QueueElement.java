package Evidencia1_EstructuraDeDatos.process;
import java.lang.Comparable;
/**
 * Esta clase representa un elemento de una cola con un número y una prioridad.
 * Los elementos pueden compararse por prioridad y se utilizan en la simulación de colas.
 */

public class QueueElement implements Comparable<QueueElement> {
    private int numeroDeElemento; // Número de elemento
    private int priority; // Prioridad del elemento

    /**
     * Constructor de la clase QueueElement.
     *
     * @param numeroDeElemento Número de elemento.
     * @param priority         Prioridad del elemento.
     */
    public QueueElement(int numeroDeElemento, int priority) {
        this.priority = priority;
        this.numeroDeElemento = numeroDeElemento;
    }

    /**
     * Devuelve una representación en cadena de caracteres del objeto QueueElement.
     *
     * @return Representación en cadena de caracteres del objeto.
     */
    public String toString() {
        return "Element No. " + this.numeroDeElemento + " , Priority: " + this.priority + "\n";
    }

    /**
     * Obtiene la prioridad del elemento.
     *
     * @return Prioridad del elemento.
     */
    public int getPriority() {
        return this.priority;
    }

    /**
     * Compara el objeto QueueElement con otro objeto QueueElement.
     *
     * @param anotherQueueElement Objeto QueueElement a comparar.
     * @return Un valor negativo si el objeto actual tiene menor prioridad que otroQueueElement,
     * cero si tienen la misma prioridad, y un valor positivo si el objeto actual tiene mayor prioridad.
     */
// Este método compara el objeto actual (this) con otro objeto QueueElement (anotherQueueElement).
    public int compareTo(QueueElement anotherQueueElement) {

        // Se obtiene la prioridad del objeto actual y del otro objeto.
        int thisPriority = this.getPriority();
        int anotherPriority = anotherQueueElement.getPriority();

        // Se realiza la comparación de prioridades y se retorna la diferencia.
        // Si thisPriority es menor, el resultado será negativo, si es igual, será cero, y si es mayor, será positivo.
        return thisPriority - anotherPriority;
    }
}