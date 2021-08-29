package BigProject;

import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(1901);
            System.out.println("Server Created");
            int id = 0;
            while(true){
                Socket socket = server.accept();
                id++;
                System.out.printf("Client %s connected\n", id);

                Handler handler = new Handler(socket, id);
                handler.start();
            }
        }catch (Exception e) { e.printStackTrace();}
    }
}
