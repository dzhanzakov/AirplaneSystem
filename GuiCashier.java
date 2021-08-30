package BigProject;

import BigProject.Classes.*;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class GuiCashier extends JFrame {
    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private MainPageForCashier mainPageForCashier;
    private ChangeTicket changeTicket;
    private CreateTicket createTicket;

    public GuiCashier(Socket socket, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream){
        try{
            this.socket = socket;
            this.objectOutputStream = objectOutputStream;
            this.objectInputStream = objectInputStream;

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    try {
                        socket.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            });
            setTitle("Cashier Application");
            setSize(700, 600);
            setLayout(null);

            mainPageForCashier = new MainPageForCashier(this);
            mainPageForCashier.setVisible(true);
            add(mainPageForCashier);

            createTicket = new CreateTicket(this);
            createTicket.setVisible(false);
            add(createTicket);

            changeTicket = new ChangeTicket(this);
            changeTicket.setVisible(false);
            add(changeTicket);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ChangeTicket getChangeTicket() {
        return changeTicket;
    }

    public void setChangeTicket(ChangeTicket changeTicket) {
        this.changeTicket = changeTicket;
    }

    public MainPageForCashier getMainPageForCashier() {
        return mainPageForCashier;
    }

    public void setMainPageForCashier(MainPageForCashier mainPageForCashier) {
        this.mainPageForCashier = mainPageForCashier;
    }

    public CreateTicket getCreateTicket() {
        return createTicket;
    }

    public void setCreateTicket(CreateTicket createTicket) {
        this.createTicket = createTicket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ArrayList<Flights> getFlights(){
        ArrayList<Flights> flights = new ArrayList<>();
        try{
            PackageData packageDataToSent = new PackageData("LIST_FLIGHTS");
            objectOutputStream.writeObject(packageDataToSent);
            PackageData packageData = (PackageData) objectInputStream.readObject();
            flights = packageData.getFlights();
        }catch (Exception e){e.printStackTrace();}
        return flights;
    }

    public ArrayList<Cities> getCities(){
        ArrayList<Cities> cities = new ArrayList<>();
        try{
            PackageData packageDataToSent = new PackageData("LIST_CITIES");
            objectOutputStream.writeObject(packageDataToSent);
            PackageData packageData = (PackageData) objectInputStream.readObject();
            cities = packageData.getCities();
        }catch (Exception e){e.printStackTrace();}
        return cities;
    }

    public void addFlight(Flights flight){
        try{
            PackageData packageData = new PackageData("ADD_FLIGHT",null,null,null,flight,null,null,null,null);
            objectOutputStream.writeObject(packageData);
            System.out.println("flight packageData has been written to the stream -> " + packageData.getOperationType());
        }catch (Exception e){e.printStackTrace();}
    }

    public void addTicket(Tickets ticket){
        try{
            PackageData packageData = new PackageData("ADD_TICKET",ticket,null,null,null,null,null,null,null);
            objectOutputStream.writeObject(packageData);
            System.out.println("ticket packageData has been written to the stream -> " + packageData.getOperationType());
        }catch (Exception e){e.printStackTrace();}
    }

    public ArrayList<Tickets> getTickets(){
        ArrayList<Tickets> tickets = new ArrayList<>();
        try{
            PackageData packageDataToSent = new PackageData("LIST_TICKETS");
            objectOutputStream.writeObject(packageDataToSent);
            PackageData packageData = (PackageData) objectInputStream.readObject();
            tickets = packageData.getTickets();
        }catch (Exception e){e.printStackTrace();}
        return tickets;
    }

    public ArrayList<Airplanes> getAirplanes() {
        ArrayList<Airplanes> result = new ArrayList<>();
        try {
            PackageData packageDataToSent = new PackageData("LIST_AIRPLANES");
            objectOutputStream.writeObject(packageDataToSent);
            PackageData packageData = (PackageData) objectInputStream.readObject();
            result = packageData.getAirplanes();
        } catch (Exception e) {e.printStackTrace();}
        return result;
    }
}
