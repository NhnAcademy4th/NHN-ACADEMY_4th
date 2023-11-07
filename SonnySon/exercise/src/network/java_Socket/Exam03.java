package network.java_Socket;

import java.net.Socket;

public class Exam03 {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",12345)){
            System.out.println("서버에 연결되었습니다.");
            int ch;
            while((ch = socket.getInputStream().read()) >= 0){
                System.out.write(ch);
            }
        }catch(Exception e){
            System.err.println(e);
        }
    }
}
