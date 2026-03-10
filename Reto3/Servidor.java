package Reto3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {

        int puerto = 6000;

        try(ServerSocket servidor = new ServerSocket(puerto)){
            System.out.println("--SE INICIA EL SERVICIO POR EL PUERTO: " + puerto+" --");

            try(
                    Socket cliente = servidor.accept();
                    DataOutputStream escribirDatos = new DataOutputStream(cliente.getOutputStream());
                    DataInputStream leerDatos = new DataInputStream(cliente.getInputStream());
            ){

                String tipoDeCliente= leerDatos.readUTF();

                if(tipoDeCliente.equalsIgnoreCase("TRIANGULO")) {

                    escribirDatos.writeUTF("Perfecto triángulo, envíame tu base y tu altura: ");

                    int base = leerDatos.readInt();
                    int altura = leerDatos.readInt();

                    int area= (base*altura)/2;
                    int perimetro = base*3;

                    escribirDatos.writeUTF("Tu área es "+area+" y tu perímetro es "+perimetro);

                }
                else if(tipoDeCliente.equalsIgnoreCase("RECTANGULO")){

                    escribirDatos.writeUTF("Perfecto rectángulo, envíame tu lado 1 y tu lado 2: ");

                    int lado1 = leerDatos.readInt();
                    int lado2 = leerDatos.readInt();

                    int area= lado1 * lado2;
                    int perimetro = (lado1*2)+(lado2*2);

                    escribirDatos.writeUTF("Tu área es "+area+" y tu perímetro es "+perimetro);

                }
                else{
                    System.err.println("CLIENTE NO AUTORIZADO, ACCESO DENEGADO.");
                }


            }catch(IOException e){
                System.err.println();
            }

        }catch(IOException e){
            System.err.println(e.getMessage());
        }

        System.out.println("-- SE APAGA EL SERVICIO --");
    }
}
