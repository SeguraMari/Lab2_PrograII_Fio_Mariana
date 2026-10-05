package principal;

import clases.Consumidor;
import clases.Productor;
import clases.Recipiente;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Recipiente recipiente = new Recipiente();
        Productor productor = new Productor(recipiente);
        Consumidor consumidor = new Consumidor(recipiente);

        productor.start();
        consumidor.start();
    }

}
