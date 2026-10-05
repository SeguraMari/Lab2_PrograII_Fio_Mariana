package clases;

/**
 * Representa el hilo consumidor del sistema.
 * Se encarga de retirar secuencialmente los 10 valores generados por el productor desde el recipiente.
 */

import java.util.Random;

public class Consumidor extends Thread {

    private final Recipiente recipiente;
    private final Random random = new Random();

    public Consumidor(Recipiente recipiente) {
        this.recipiente = recipiente;
    }

    /**
     * Realiza las 10 iteraciones extrayendo y procesando el valor disponible en el recipiente.
     */
    public void run() {
        //Iteraciones para retirar los 10 datos producidos
        for (int i = 1; i <= 10; i++) {
            recipiente.consume();
            try {
                Thread.sleep(1000 + random.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
