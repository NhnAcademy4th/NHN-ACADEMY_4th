package network.java_Socket;

import java.net.Socket;

public class Quiz03 {

    private static void checkHost(){
        checkHost("localhost",1234);
    }
    private static void checkHost(String hostName){
        checkHost(hostName,1234);
    }

    private static void checkHost(String hostName,int port){
        try(Socket socket = new Socket(hostName,port)){
            System.out.println("서버에 연결 되었습니다.");
            System.out.println("Local address: " + socket.getLocalAddress());
            System.out.println("Local port: " + socket.getLocalPort());
            System.out.println("Remote address: " + socket.getRemoteSocketAddress());
            System.out.println("Remote port: " + socket.getPort());
        }catch(Exception e){
            System.out.println(hostName + "::" + port +"에 연결할 수 없습니다.");
        }
    }
    public static void main(String[] args) {
        checkHost(args[0],Integer.parseInt(args[1]));
    }
}
