package simple_tcp_thread_fred2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

    private Socket socket;
    private ServerMain server_main;

    public ServerThread(Socket socket, ServerMain server_main) {
        this.socket = socket;
        this.server_main = server_main;
    }

    @Override
    public void run() {
        try {

            int client_number = server_main.getClientNumber();
            System.out.println("Client " + client_number + " has connected.");

            // I/O buffers
            BufferedReader in_socket = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            PrintWriter out_socket = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream()),
                    true
            );

            // Saludo especial si el ID es par
            String saludo;
            if (client_number % 2 == 0) {
                saludo = "Welcome! You are client number " + client_number
                        + ". You have a lot of luck 🍀. What's your name?";
            } else {
                saludo = "Welcome! You are client number " + client_number
                        + ". What's your name?";
            }

            out_socket.println(saludo);

            String message = in_socket.readLine(); // receive Client's message
            System.out.println("Client " + client_number + " says: " + message);

            socket.close();
            System.out.println("Client " + client_number + " has disconnected.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
