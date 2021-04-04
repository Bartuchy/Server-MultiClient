package ex1b;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int client_number = 1;

    public int getClient_number() {
        return client_number++;
    }

    public Server() throws IOException {
        ServerSocket server_socket = new ServerSocket(2020);
        System.out.println("Port 2020 is now open");

        while (true){
            Socket socket = server_socket.accept();
            ServerThread server_thread = new ServerThread(socket, this);
            Thread thread = new Thread(server_thread);
            thread.start();
        }
    }

    public static void main(String[] args) {
        try {
            new Server();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
