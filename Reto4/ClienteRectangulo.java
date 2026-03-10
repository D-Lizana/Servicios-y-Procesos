package Reto4;

import java.io.*;
import java.net.Socket;

public class ClienteRectangulo {

    public static void main(String[] args) {

        int puerto = 6000;

        try(Socket servidor = new Socket("localhost", puerto);
            ObjectOutputStream escribirDatos = new ObjectOutputStream(servidor.getOutputStream());
            ObjectInputStream leerDatos = new ObjectInputStream(servidor.getInputStream());

        ) {

            System.out.println("Cliente conectado al servidor por el puerto: "+puerto);

            Rectangulo rectangulo = new Rectangulo(12, 66);

            escribirDatos.writeObject(rectangulo);

            String resultado = (String) leerDatos.readObject();
            System.out.println("Resultado: "+resultado);


        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
