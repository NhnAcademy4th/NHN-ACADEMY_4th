package network.java_Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//TODO 충돌안남 다시 해볼것
public class Exam05 {
    public static void main(String[] args) {
        int port =1234;
        try(ServerSocket serverSocket  = new ServerSocket(port)){
            System.out.println("server opened");
            Socket socket = serverSocket.accept();

            socket.getOutputStream().write("hello".getBytes());
            socket.getOutputStream().flush();

            socket.close();

        }catch(IOException e){
            System.err.println(e);
        }
    }
}
