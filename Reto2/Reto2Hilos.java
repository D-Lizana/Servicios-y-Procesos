package Reto2;

public class Reto2Hilos {
    public static void main(String[] args){

        Sumatorio s1 = new Sumatorio(20);
        Sumatorio s2 = new Sumatorio(23);
        Sumatorio s3 = new Sumatorio(12);

        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);
        Thread t3 = new Thread(s3);

        // Arrancar los hilos (esto inicia el metodo run() en paralelo)
        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join();
            t1.join();
            t1.join();

            double formula = (s1.getResultado() + s2.getResultado() + s3.getResultado())/8;

            System.out.println("El resultado es: "+formula);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
