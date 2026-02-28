package Reto3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClienteTriangulo {

    public static void main(String[] args) {

        int puerto = 5001;
        System.out.println("##CLIENTE SE INTENTA CONECTAR AL SERVER POR EL PUERTO: "+puerto);

        try(
                Socket servidor = new Socket("localhost",puerto);
                DataOutputStream escribirDatos = new DataOutputStream(servidor.getOutputStream());
                DataInputStream leerDatos = new DataInputStream(servidor.getInputStream());
        ){

            System.out.println("Cliente conectado al servidor por el puerto: "+puerto);

            escribirDatos.writeUTF("TRIANGULO");

            String respuesta = leerDatos.readUTF();
            System.out.println(respuesta);

            int base = 50;
            int altura = 10;

            escribirDatos.writeInt(base);
            escribirDatos.writeInt(altura);

            String resultado = leerDatos.readUTF();
            System.out.println(resultado);

        }catch(IOException e){
            System.err.println(e.getMessage());
        }

        System.out.println("##CLIENTE DESCONECTADO");
    }
}
