package BigProject;

import BigProject.AdminSideClasses.GuiAdmin;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AdminClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 1901);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            GuiAdmin guiAdmin = new GuiAdmin(socket, inputStream, outputStream);
            guiAdmin.setVisible(true);

        }catch (Exception e) { e.printStackTrace();}
    }
}
