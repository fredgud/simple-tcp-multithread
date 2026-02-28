package simple_tcp_thread_fred2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

    private Socket socket;
    private ServerMain servidor;

    public ServerThread(Socket socket, ServerMain servidor) {
        this.socket = socket;
        this.servidor = servidor;
    }

    @Override
    public void run() {
        try {
            int idCliente = servidor.obtenerNumeroCliente();
            System.out.println("Cliente " + idCliente + " conectado.");

            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            PrintWriter salida = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream()),
                    true
            );

            String saludo;
            if (idCliente % 2 == 0) {
                saludo = "¡Bienvenido cliente " + idCliente + "! Tienes mucha suerte 🍀 ¿Cuál es tu nombre?";
            } else {
                saludo = "Bienvenido cliente " + idCliente + ". ¿Cuál es tu nombre?";
            }

            salida.println(saludo);

            String mensajeCliente = entrada.readLine();
            System.out.println("Cliente " + idCliente + " dice: " + mensajeCliente);

            socket.close();
            System.out.println("Cliente " + idCliente + " desconectado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
