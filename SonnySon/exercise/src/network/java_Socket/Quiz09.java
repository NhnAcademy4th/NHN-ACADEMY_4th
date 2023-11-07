package network.java_Socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.NumberFormat;

public class Quiz09 {
    public static void main(String[] args) {
        int port = 1234;
        int bufferSize = 2048;

        if(args.length > 0){
            try{
                port = Integer.parseInt(args[0]);
            }catch(NumberFormatException e){
                System.out.println(e);
            }
        }

        try(ServerSocket serverSocket  = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            BufferedInputStream socketIn = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream socketOut = new BufferedOutputStream(socket.getOutputStream());
        ){
            byte[] buffer = new byte[bufferSize];
            int length;

            while((length = socketIn.read(buffer)) > 0){
                socketOut.write(buffer,0,length);
                socketOut.flush();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
