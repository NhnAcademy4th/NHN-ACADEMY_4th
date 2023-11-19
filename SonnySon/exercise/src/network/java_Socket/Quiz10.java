package network.java_Socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Quiz10 {
    static final int bufferSize = 2048;

    static void service(ServerSocket serverSocket){
        try(Socket socket = serverSocket.accept();
            BufferedInputStream socketInput = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream socketOutput = new BufferedOutputStream(socket.getOutputStream());
        ){
            System.out.println(socket.getInetAddress().getHostAddress() + " : " + socket.getPort() + "가 연결되었습니다.");
            byte[] buffer = new byte[bufferSize];
            int length;
            while((length = socketInput.read(buffer)) > 0){
                socketOutput.write(buffer,0,length);
                socketOutput.flush();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        int port = 1234;

        if(args.length  > 0){
            try{
                port = Integer.parseInt(args[0]);
            }catch(NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }

        try(
                ServerSocket serverSocket = new ServerSocket(port);
        ){
            while (!Thread.currentThread().isInterrupted()){
                Quiz10.service(serverSocket);
            }
        }catch (IOException ignore){
            System.out.println("서비스 열기에 실패 하였습니다.");
        }
    }
}
