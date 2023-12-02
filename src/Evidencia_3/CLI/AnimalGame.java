package Evidencia_3.CLI;
import Evidencia_3.utils.BTNode;

import java.util.*;

/**
 * Clase que implementa un juego de adivinanzas de animales utilizando un árbol binario.
 */
public class AnimalGame {

    private static Scanner stdin = new Scanner(System.in);

    /**
     * Muestra instrucciones iniciales para el juego.
     */
    public static void instruct() {
        System.out.println("Piensa en un animal.");
        System.out.println("Haré algunas preguntas de sí/no para intentar adivinar");
        System.out.println("el animal que estás pensando.");
    }

    /**
     * Inicia el juego de adivinanzas a partir de un nodo específico en el árbol.
     *
     * @param current Nodo actual en el árbol.
     */
    public static void play(BTNode<String> current) {
        while (!current.isLeaf()) {
            if (query(current.getData()))
                current = current.getLeft();
            else
                current = current.getRight();
        }

        System.out.print("Creo que piensas en un " + current.getData() + ". ");
        if (!query("¿Estoy en lo correcto?"))
            learn(current);
        else
            System.out.println("¡Lo sabía!");
    }

    /**
     * Construye y devuelve el árbol inicial para el juego de adivinanzas.
     *
     * @return Raíz del árbol de adivinanzas.
     */
    public static BTNode<String> beginningTree() {
        BTNode<String> root;
        BTNode<String> child;

        final String ROOT_QUESTION = "¿Tiene Cuernos?";
        final String LEFT_QUESTION = "¿Tiene Manchas?";
        final String RIGHT_QUESTION = "¿Ladra?";
        final String ANIMAL1 = "Vaca";
        final String ANIMAL2 = "Toro";
        final String ANIMAL3 = "Perro";
        final String ANIMAL4 = "Gato";

        root = new BTNode<String>(ROOT_QUESTION, null, null);

        child = new BTNode<String>(LEFT_QUESTION, null, null);
        child.setLeft(new BTNode<String>(ANIMAL1, null, null));
        child.setRight(new BTNode<String>(ANIMAL2, null, null));
        root.setLeft(child);

        // Crear y adjuntar el subárbol derecho.
        child = new BTNode<String>(RIGHT_QUESTION, null, null);
        child.setLeft(new BTNode<String>(ANIMAL3, null, null));
        child.setRight(new BTNode<String>(ANIMAL4, null, null));
        root.setRight(child);

        return root;
    }

    /**
     * Permite al usuario agregar un nuevo animal y una pregunta para mejorar el árbol.
     *
     * @param current Nodo actual en el árbol.
     */
    public static void learn(BTNode<String> current) {
        String guessAnimal;
        String correctAnimal;
        String newQuestion;

        guessAnimal = current.getData();
        System.out.println("Me doy. ¿Qué animal es? ");
        correctAnimal = stdin.nextLine();
        System.out.println("Por favor ingrese una pregunta sí/no que distinga un ");
        System.out.println(correctAnimal + " de un " + guessAnimal + ".");
        newQuestion = stdin.nextLine();

        current.setData(newQuestion);
        System.out.println("El animal: " + correctAnimal + ", " + newQuestion);
        if (query("Conteste sí o no")) {
            current.setLeft(new BTNode<String>(correctAnimal, null, null));
            current.setRight(new BTNode<String>(guessAnimal, null, null));
        } else {
            current.setLeft(new BTNode<String>(guessAnimal, null, null));
            current.setRight(new BTNode<String>(correctAnimal, null, null));
        }
    }

    /**
     * Realiza una pregunta al usuario y espera una respuesta sí o no.
     *
     * @param prompt Pregunta para el usuario.
     * @return true si la respuesta es sí, false si la respuesta es no.
     */
    public static boolean  query(String prompt) {
        String answer;

        System.out.print(prompt + " [S o N]: ");
        answer = stdin.nextLine().toUpperCase();
        while (!answer.startsWith("S") && !answer.startsWith("N")) {
            System.out.print("Respuesta inválida. Conteste S o N: ");
            answer = stdin.nextLine().toUpperCase();
        }

        return answer.startsWith("S");
    }
}