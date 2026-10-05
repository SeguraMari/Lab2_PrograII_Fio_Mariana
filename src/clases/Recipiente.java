package clases;

/**
 * Representa el recurso compartido(búfer) entre productor y consumidor
 * 
 * Esta clase gestiona la comunicación entre hilos mediante métodos sincronizados y
 * los mecanismos de control de espera/notificación.
 * 
 * @author Graciela
 */

public class Recipiente {

    private int contenido;
    private boolean disponible = false;

    //Método sincronizado para producir
    public synchronized void produce(int valor) {
        //Si el valor ya tiene un valor, el productor espera
        while (disponible) {
            try {
                wait();//Libera y duerme hasta que consuman
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        //Se guarda el valor y se marca como disponible
        this.contenido = valor;
        this.disponible = true;
        System.out.println("[Productor] Produjo el valor: " + valor);

        //Despierta al consumidor que estaba esperando
        notifyAll();
    }

    //Método sincronizado para consumir
    public synchronized int consume() {
        //Si el recipiente está vacío, el consumidor espera
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.disponible = false;
        System.out.println("[Consumidor] Consumió el valor de: " + contenido);

        notifyAll();
        return contenido;
    }
}
