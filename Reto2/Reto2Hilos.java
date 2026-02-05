package Reto2;

public class Reto2Hilos {
    public static void main(String[] args) {

        Sumatorio s1 = new Sumatorio(20);
        Sumatorio s2 = new Sumatorio(23);
        Sumatorio s3 = new Sumatorio(12);

        // 2. Arrancar los hilos (esto inicia el metodo run() en paralelo)
        s1.start();
        s2.start();
        s3.start();




    }
}
