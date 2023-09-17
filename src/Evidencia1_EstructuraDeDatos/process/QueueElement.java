package Evidencia1_EstructuraDeDatos.process;
import java.lang.Comparable;

public class QueueElement implements Comparable<QueueElement> {
    private int elementNo; // Número de elemento
    private int priority; // Prioridad del elemento

    /**
     * Constructor de la clase QueueElement.
     * @param elementNo Número de elemento.
     * @param priority Prioridad del elemento.
     */
    public QueueElement( int elementNo, int priority ){
        this.priority = priority;
        this.elementNo = elementNo;
    }

    /**
     * Devuelve una representación en cadena de caracteres del objeto QueueElement.
     * @return Representación en cadena de caracteres del objeto.
     */
    public String toString(){
        return "Element No. " + this.elementNo + " , Priority: " + this.priority + "\n";
    }

    /**
     * Obtiene la prioridad del elemento.
     * @return Prioridad del elemento.
     */
    public int getPriority(){
        return this.priority;
    }

    /**
     * Compara el objeto QueueElement con otro objeto QueueElement.
     * @param anotherQueueElement Objeto QueueElement a comparar.
     * @return Un valor negativo si el objeto actual tiene menor prioridad que otroQueueElement,
     *         cero si tienen la misma prioridad, y un valor positivo si el objeto actual tiene mayor prioridad.
     */
    public int compareTo(QueueElement anotherQueueElement) {
        return  this.getPriority() - anotherQueueElement.getPriority();
    }
}
