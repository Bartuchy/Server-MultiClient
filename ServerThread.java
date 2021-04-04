package ex1b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Socket socket;
    private Server server;

    public ServerThread(Socket socket, Server server){
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try{
            int client_number = server.getClient_number();

            System.out.println("Client " + client_number + " has connected.");

            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            String message = "";

            out_socket.println("Write some sentence that i can turn it into ALL CAPS");
            while(!(message.equalsIgnoreCase("TIXE"))){
                message = in_socket.readLine();
                StringBuilder mes = new StringBuilder(message);
                out_socket.println(mes.reverse().toString());
            }

            socket.close();
            System.out.println("Client " + client_number + ". has disconnected.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
