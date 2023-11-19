package network.java_Socket;

import java.net.Socket;

public class Exam01 {
    public static void main(String[] args) {
        try{
            Socket socket;
            socket = new Socket("localhost",12345);
            System.out.println("서버 연결");
            socket.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }
}
