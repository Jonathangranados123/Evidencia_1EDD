package Evidencia1_EstructuraDeDatos.CLI;

import Evidencia1_EstructuraDeDatos.Utils.PriorityQueue;
import Evidencia1_EstructuraDeDatos.process.QueueElement;

import java.util.Scanner;
import java.lang.Math;

public class QueueSimCli {
    static PriorityQueue<QueueElement> q; // Cola de prioridad de elementos de tipo QueueElement
    static Scanner in = new Scanner(System.in); // Objeto para leer la entrada del usuario
    static int minService, maxService, minClient, maxClient, simTime, counter; // Variables para configurar la simulación

    /**
     * Inicializa la simulación con la configuración proporcionada por el usuario.
     */
    public static void initCli(){
        // Solicitar y configurar la capacidad de la cola
        System.out.print("Capacidad de la cola: ");
        q = new PriorityQueue<QueueElement>(in.nextInt());

        // Configurar los tiempos mínimos y máximos de atención del servidor
        System.out.print("Minimo Tiempo de atencion del Servidor: ");
        minService = in.nextInt();
        System.out.print("Maximo Tiempo de atencion del Servidor: ");
        maxService = in.nextInt();

        // Configurar los tiempos mínimos y máximos de llegada del cliente
        System.out.print("Minimo Tiempo de llegada del Cliente: ");
        minClient= in.nextInt();
        System.out.print("Maximo Tiempo de llegada del Cliente: ");
        maxClient = in.nextInt();

        // Configurar el tiempo total de simulación
        System.out.print("Tiempo de Simulacion: ");
        simTime = in.nextInt();
    }

    /**
     * Genera un número aleatorio en el intervalo [min, max].
     * @param min Valor mínimo del intervalo.
     * @param max Valor máximo del intervalo.
     * @return Número aleatorio en el intervalo.
     */
    private static int getRandomInInterval(int min, int max){
        return (int) Math.floor(Math.random() *(max - min + 1) + min);
    }

    /**
     * Agrega un elemento a la cola de prioridad.
     */
    private static void provideElement(){
        counter++;
        q.offer(new QueueElement(counter, getRandomInInterval(1,5)));
    }

    /**
     * Atiende un elemento de la cola de prioridad.
     */
    private static void serveElement(){
        q.poll();
    }

    /**
     * Inicia la simulación con hilos para el servidor, proveedor, impresora y coordinador.
     */
    public static void startSim(){

        final Thread server = new Thread(()-> {
            while (!Thread.interrupted()) {
                serveElement();
                try{
                    Thread.sleep(getRandomInInterval(minService, maxService) * 1000);
                }catch(Exception e){
                    Thread.currentThread().interrupt();
                }
                Thread.yield();
            }
            System.out.println("Server Stopped!");
        });

        final Thread provider = new Thread(()-> {
            while (!Thread.interrupted()) {
                provideElement();
                try{
                    Thread.sleep(getRandomInInterval(minClient, maxClient) * 1000);
                }catch(Exception e){
                    Thread.currentThread().interrupt();
                }
                Thread.yield();
            }
            System.out.println("Client Stopped!");
        });

        final Thread printer = new  Thread(()-> {
            while (!Thread.interrupted()) {
                try{
                    System.out.println();
                    System.out.println(q);
                    Thread.sleep(1000);
                }catch(Exception e){
                    Thread.currentThread().interrupt();
                }
            }
        });

        final Thread coordinator = new  Thread(()-> {
            try {
                Thread.sleep(simTime*1000);
            } catch (InterruptedException ex) { }
            System.out.println("Terminando Simulacion!");
            printer.interrupt();
            server.interrupt();
            provider.interrupt();
        });

        server.start();
        provider.start();
        printer.start();
        coordinator.start();
    }
}
