package Evidencia1_EstructuraDeDatos.CLI;

import Utils.PriorityQueue;
import Evidencia1_EstructuraDeDatos.process.QueueElement;

import java.util.Scanner;
import java.lang.Math;
/**
 * Esta clase simula un sistema de colas con un servidor y clientes.
 * Permite controlar los tiempos de servicio y llegada, y muestra el estado de la cola en tiempo real.
 * La simulación se ejecuta en múltiples hilos para representar un entorno concurrente.
 */

public class QueueSimCli {
    static PriorityQueue<QueueElement> cola; // Cola de prioridad de elementos de tipo QueueElement
    static Scanner in = new Scanner(System.in); // Objeto para leer la entrada del usuario
    static int minService, maxService, minClient, maxClient, simTime, counter; // Variables para configurar la simulación

    /**
     * Inicializa la simulación con la configuración proporcionada por el usuario.
     */
    public static void initCli() {
        // Solicitar y configurar la capacidad de la cola
        System.out.print("Capacidad de la cola: ");
        cola = new PriorityQueue<QueueElement>(in.nextInt());

        // Configurar los tiempos mínimos y máximos de atención del servidor
        System.out.print("Minimo Tiempo de atencion del Servidor: ");
        minService = in.nextInt();
        System.out.print("Maximo Tiempo de atencion del Servidor: ");
        maxService = in.nextInt();

        // Configurar los tiempos mínimos y máximos de llegada del cliente
        System.out.print("Minimo Tiempo de llegada del Cliente: ");
        minClient = in.nextInt();
        System.out.print("Maximo Tiempo de llegada del Cliente: ");
        maxClient = in.nextInt();

        // Configurar el tiempo total de simulación
        System.out.print("Tiempo de Simulacion: ");
        simTime = in.nextInt();
    }

    /**
     * Genera un número aleatorio en el intervalo [min, max].
     *
     * @param min Valor mínimo del intervalo.
     * @param max Valor máximo del intervalo.
     * @return Número aleatorio en el intervalo.
     */
    private static int getRandomInInterval(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    /**
     * Agrega un elemento a la cola de prioridad.
     */
    private static void provideElement() {
        counter++;
        cola.offer(new QueueElement(counter, getRandomInInterval(1, 5)));
    }

    /**
     * Elimina un elemento de la cola de prioridad.
     */
    private static void retirarElemento() {
        cola.poll();
    }

    /**
     * Inicia la simulación con hilos para el servidor, proveedor, impresora y coordinador.
     */
    public static void startSim() {

// Se crea un nuevo hilo llamado 'server' utilizando una expresión lambda.
        final Thread server = new Thread(() -> {
            // El hilo entrará en un bucle que se ejecutará mientras el hilo no sea interrumpido.
            while (!Thread.interrupted()) {
                // Se llama a un método llamado 'retirarElemento()'.
                retirarElemento();
                try {
                    // El hilo espera un tiempo aleatorio antes de la próxima ejecución.
                    // El tiempo está determinado por el valor retornado de
                    // 'getRandomInInterval(minService, maxService)'
                    Thread.sleep(getRandomInInterval(minService, maxService) * 1000);
                } catch (Exception e) {
                    // Si se produce una excepción, el hilo actual se interrumpe.
                    Thread.currentThread().interrupt();
                }
                // Se sugiere al planificador de hilos que permita a otros hilos ejecutar
                // si hay otros disponibles.
                Thread.yield();
            }
            // Cuando el bucle se detiene (debido a que el hilo fue interrumpido),
            // se imprime un mensaje indicando que el servidor se detuvo.
            System.out.println("Server Stopped!");
        });

// Se crea un nuevo hilo llamado 'provider' utilizando una expresión lambda.
        final Thread provider = new Thread(() -> {
            // El hilo entrará en un bucle que se ejecutará mientras el hilo no sea interrumpido.
            while (!Thread.interrupted()) {
                // Se llama a un método llamado 'provideElement()'
                provideElement();
                try {
                    // El hilo espera un tiempo aleatorio antes de la próxima ejecución.
                    // El tiempo está determinado por el valor retornado de
                    // 'getRandomInInterval(minClient, maxClient)'
                    Thread.sleep(getRandomInInterval(minClient, maxClient) * 1000);
                } catch (Exception e) {
                    // Si se produce una excepción, el hilo actual se interrumpe.
                    Thread.currentThread().interrupt();
                }
                // Se sugiere al planificador de hilos que permita a otros hilos ejecutar
                // si hay otros disponibles.
                Thread.yield();
            }
            // Cuando el bucle se detiene (debido a que el hilo fue interrumpido),
            // se imprime un mensaje indicando que el cliente se detuvo.
            System.out.println("Client Stopped!");
        });

        // Se crea un nuevo hilo llamado 'printer' utilizando una expresión lambda.
        final Thread printer = new Thread(() -> {
            // El hilo entrará en un bucle que se ejecutará mientras el hilo no sea interrumpido.
            while (!Thread.interrupted()) {
                try {
                    // Se imprime una línea en blanco y luego se imprime el contenido de la cola
                    // (referenciada como 'cola' en este caso).
                    System.out.println();
                    System.out.println(cola);

                    // El hilo espera 1000 milisegundos (1 segundo) antes de la próxima ejecución.
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // Si se produce una excepción, el hilo actual se interrumpe.
                    Thread.currentThread().interrupt();
                }
            }
        });


// Se crea un nuevo hilo llamado 'coordinator' utilizando una expresión lambda.
        final Thread coordinator = new Thread(() -> {
            try {
                // El hilo espera 'simTime' segundos antes de continuar.
                Thread.sleep(simTime * 1000);
            } catch (InterruptedException ex) {
                // Si se produce una excepción de interrupción, no se hace nada.
            }

            // Una vez que el tiempo de simulación ha pasado, se imprime un mensaje indicando
            // que la simulación ha terminado.
            System.out.println("Terminando Simulacion!");

            // Se interrumpen los hilos 'printer', 'server' y 'provider'.
            printer.interrupt();
            server.interrupt();
            provider.interrupt();
        });

// Se inician los hilos 'server', 'provider', 'printer' y 'coordinator'.
        server.start();
        provider.start();
        printer.start();
        coordinator.start();
    }
}

