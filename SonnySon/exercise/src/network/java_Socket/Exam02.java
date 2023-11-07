package network.java_Socket;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Exam02 {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;

        if(args.length > 0){
            host = args[0];
        }
        try{
            if(args.length > 1){
                port = Integer.parseInt(args[1]);
            }
        }catch(NumberFormatException e){
            System.err.println("Invalid port number");
            System.exit(1);
        }

        try(Socket socket = new Socket(host, port);){
            System.out.println("서버에 연결되었습니다.");
            socket.getOutputStream().write("Hello World!".getBytes());
        } catch(ConnectException e){
            System.err.println(host+":"+port+"에 연결할 수 없습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
