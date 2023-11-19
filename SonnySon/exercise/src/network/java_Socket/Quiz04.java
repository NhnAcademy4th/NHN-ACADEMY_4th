package network.java_Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import org.w3c.dom.ls.LSOutput;

public class Quiz04 {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;

        if(args.length > 0){
            host = args[0];
        }

        try{
            if(args.length > 1){
                port = Integer.parseInt(args[1]);
            }
        }catch(NumberFormatException e){
            System.err.println("NumberFormatException");
            System.exit(1);
        }

        try(Socket socket = new Socket(host, port);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ){
            System.out.println("서버에 연결되었습니다.");
            while(true){
                String line = br.readLine();
                if("exit".equals(line)) break;
                socket.getOutputStream().write(line.getBytes());
            }
        }catch(IOException e){

        }

    }
}
