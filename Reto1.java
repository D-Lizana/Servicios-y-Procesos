// Para solucionar el ejercicio necesitamos tener en cuenta que hay que usar Thread.sleep() y que dicho metodo requiere el tiempo en milisegundos.

// Introducimos la ruta y el tiempo en segundos por el teclado usando la clase Scanner.

// Como Thread.sleep() requiere milisegundos tenemos que multiplicar por 1000 el numero introducido por teclado antes de usarlo.

// Usando Thread.sleep() paramos el hilo durante el tiempo seleccionado para que el programa no siga corriendo durante un tiempo.

// Por último, usamos la clase ProcessBuilder para especificar la ruta del .exe que vamos a ejecutar y los argumentos de configuración si hubiera alguno.

// Con el metodo .start de ProcessBuilder hacemos que el SO ejecute el programa.

// Tenemos que controlar también mediante excepciones que la ruta proporcionada para el ejecutable sea válida, y que nos avise si hay algo que impida parar el hilo durante esos segundos.

import java.io.IOException;
import java.util.Scanner;

public class Reto1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Introduce ruta del ejecutable: ");
            String ruta = sc.nextLine();

            System.out.println("Introduce el tiempo en segundos: ");
            int segundos = Integer.parseInt(sc.nextLine());


            System.out.println("Esperando: Esperando " + segundos + " segundos.");
            Thread.sleep(segundos * 1000);

            ProcessBuilder pb = new ProcessBuilder(ruta);
            pb.start();

            System.out.println("PROGRAMA LANZADO");

        } catch (InterruptedException e) {
            System.err.println("Error: La espera fue interrumpida.");
        } catch (IOException e) {
            System.err.println("Error: No se pudo encontrar el archivo.");
        } finally {
            sc.close();
        }


    }
}
