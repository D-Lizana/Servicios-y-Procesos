package Reto2;

public class Sumatorio extends Thread{
    private int numero;
    private double resultado;

    public Sumatorio(int numero){
        this.numero = numero;
    }

    @Override
    public void run(){
        if (numero % 2 == 0) {
            numero = numero - 1;
        }

        double total = 0;
        for (int i = numero; i >= 1; i = i - 2) {
            total += i;
        }
        this.resultado = total;
    }

    public double getResultado(){
        return  resultado;
    }



}
