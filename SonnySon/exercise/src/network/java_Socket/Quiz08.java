package network.java_Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Quiz08 {
    public static void main(String[] args) {
        int port = 1234;

        if(args.length > 0){
            try{
                port = Integer.parseInt(args[0]);
            }catch (NumberFormatException e){
                System.out.println("Invalid Integer value");
                System.exit(1);
            }
        }

        try(ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept()){
            System.out.println(socket.getInetAddress().getHostAddress() + " : " + socket.getPort() + "가 연결되었습니다.");
            System.out.println("연결을 끊습니다.");
        }catch (IOException e){
            System.out.println("Service Failed");
            System.out.println(e);
        }
    }
}
