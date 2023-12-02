package Evidencia_3;

import Evidencia_3.CLI.AnimalGame;
import Evidencia_3.utils.BTNode;

/**
 * Clase principal que contiene el método main para ejecutar el juego de adivinanzas de animales.
 */
 public class Main {

    /**
     * Método principal que inicia el juego de adivinanzas de animales.
     *
     * @param args Argumentos de línea de comandos (no se utilizan).
     */
    public static void  main(String[] args) {
        BTNode<String> root;

        // Muestra las instrucciones del juego.
        AnimalGame.instruct();

        // Inicializa el árbol de adivinanzas.
        root = AnimalGame.beginningTree();

        // Realiza el juego hasta que el usuario decida no jugar más.
        do {
            AnimalGame.play(root);
        } while (AnimalGame.query("¿Volvemos a jugar?"));

        System.out.println("Gracias por enseñarme una que otra cosa.");
    }
}