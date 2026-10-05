package clases;

/**
 * Representa el hilo productor del sistema.
 * Se encarga de generar una secuencia de 10 números enteros, depositándolos uno a uno en el recipiente.
 * 
 */

import java.util.Random;

public class Productor extends Thread {

    private final Recipiente recipiente;
    private final Random random = new Random();

    public Productor(Recipiente recipiente) {
        this.recipiente = recipiente;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            recipiente.produce(i);//Guarda el número de la iteración actual
            try {
                //Simula el tiempo de espera aleatorio entre 1 y 2 segundos
                Thread.sleep(1000 + random.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
