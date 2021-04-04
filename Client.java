package ex1b;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client() throws IOException {
        Socket socket = new Socket("127.0.0.1", 2020);
        System.out.println("Succesfull conection to the server");

        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        Scanner keyboard = new Scanner(System.in);

        String message = in_socket.readLine();
        System.out.println(message);
        System.out.println("type 'exit' to leave");

        while(!(message.equalsIgnoreCase("TIXE"))){
            System.out.print("Sentence: ");
            message = keyboard.nextLine();
            out_socket.println(message);
            message = in_socket.readLine();
            System.out.println("Server: " + message);
        }
        socket.close();
        System.out.println("Socket closed");
    }

    public static void main(String[] args) {
        try{
            new Client();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
