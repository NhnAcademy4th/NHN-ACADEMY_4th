package network.java_Socket;

import java.io.IOException;
import java.net.Socket;

public class Quiz01 {
    private static void checkSocket(int start,int end){
        for(int i = start; i < end + 1; i++){
            try(Socket socket = new Socket("localhost",i);){
                System.out.println("Port" + socket.getPort()+ "열려 있습니다.");
            }catch(Exception e){
//                System.out.println("Port " + i +" 닫혀 있습니다");
            }
        }
    }

    private void checkSocket(int start){
        checkSocket(start,start);
    }

    public static void main(String[] args) throws IOException {
        checkSocket(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
    }
}
