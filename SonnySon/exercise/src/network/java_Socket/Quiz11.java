package network.java_Socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Quiz11 {
    static final int bufferSize = 2048;
    private static class Service extends Thread{

        Socket socket;

        public Service(Socket socket) throws IOException {
            this.socket = socket;
        }

        @Override
        public void run(){
            try(
                    BufferedInputStream socketInput = new BufferedInputStream(socket.getInputStream());
                    BufferedOutputStream socketOutput = new BufferedOutputStream(socket.getOutputStream());
            ){
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

    }

    public static void main(String[] args) {
        int port = 1234;

        if(args.length > 0){
            try{
                port = Integer.parseInt(args[0]);
            }catch (NumberFormatException e){
                System.out.println("Invalid Port Number");
                System.exit(1);
            }
        }

        try(ServerSocket serverSocket  = new ServerSocket(port)){
            while(!Thread.currentThread().isInterrupted()){
                Socket socket = serverSocket.accept();
                Service service = new Service(socket);
                service.start();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
