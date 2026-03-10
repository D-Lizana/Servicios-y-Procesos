package Reto4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {

        int puerto = 6000;

        try(ServerSocket servidor = new ServerSocket(puerto)){
            System.out.println("--SE INICIA EL SERVICIO POR EL PUERTO: " + puerto+" --");

            try(
                    Socket cliente = servidor.accept();
                    ObjectOutputStream escribirDatos = new ObjectOutputStream(cliente.getOutputStream());
                    ObjectInputStream leerDatos = new ObjectInputStream(cliente.getInputStream());
            ){

                Rectangulo rectangulo = (Rectangulo) leerDatos.readObject();
                System.out.println("Datos recibidos: "+rectangulo);

                int area = rectangulo.calcularArea();
                int perimetro = rectangulo.calcularPerimetro();

                escribirDatos.writeObject("El área del rectángulo es "+area+" y el perímetro es "+perimetro);
                System.out.println("Resultado enviado.");

            }catch(IOException e){
                System.err.println();
            }

        }catch(IOException | ClassNotFoundException e){
            System.err.println(e.getMessage());
        }

        System.out.println("-- SE APAGA EL SERVICIO --");
    }
}