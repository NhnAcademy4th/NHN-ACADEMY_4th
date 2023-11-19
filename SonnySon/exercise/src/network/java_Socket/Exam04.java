package network.java_Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Exam04 {
    public static void main(String[] args) {
        int port = 1234;
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server Opened");

            Socket socket = serverSocket.accept();

            socket.getOutputStream().write("Hello!".getBytes());
            socket.getOutputStream().flush();

            socket.close();

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Invalid Port Number");
        }
    }
}
