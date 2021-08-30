package BigProject;

import BigProject.CashierSideClasses.GuiCashier;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CashierClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 1901);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            GuiCashier guiCashier = new GuiCashier(socket, inputStream, outputStream);
            guiCashier.setVisible(true);

        }catch (Exception e) { e.printStackTrace();}
    }
}


