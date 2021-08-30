package BigProject.GeneralClasses;


import BigProject.GeneralClasses.*;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Handler extends Thread {
    private Socket socket;
    private int id;

    public Handler(Socket socket, int id) {
        this.socket = socket;
        this.id = id;
    }

    @Override
    public void run(){
        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            DBManager db = new DBManager();
            db.connect();
            PackageData data = null;

            while((data = (PackageData) inputStream.readObject()) != null){
                if(data.getOperationType().equalsIgnoreCase("LIST_AIRPLANES")){
                    System.out.println("Airplanes ArrayList request received");
                    ArrayList<Airplanes> airplanes = db.getAirplanes();
                    PackageData packageData = new PackageData();
                    packageData.setAirplanes(airplanes);
                    outputStream.writeObject(packageData);
                    System.out.println("Airplanes ArrayList was sent to the stream");
                }
                if(data.getOperationType().equalsIgnoreCase("LIST_CITIES")){
                    System.out.println("Cities ArrayList request received");
                    ArrayList<Cities> cities = db.getCities();
                    PackageData packageData = new PackageData();
                    packageData.setCities(cities);
                    outputStream.writeObject(packageData);
                    System.out.println("Cities ArrayList was sent to the stream");
                }
                if(data.getOperationType().equalsIgnoreCase("LIST_FLIGHTS")){
                    System.out.println("Flights ArrayList request received");
                    ArrayList<Flights> flights = db.getFlights();
                    PackageData packageData = new PackageData();
                    packageData.setFlights(flights);
                    outputStream.writeObject(packageData);
                    System.out.println("Flights ArrayList was sent to the stream");
                }
                if(data.getOperationType().equalsIgnoreCase("ADD_FLIGHT")){
                    Flights flight = data.getFlight();
                    db.addTheFlight(flight);
                    System.out.println("Flight Object was received and sent to the database");
                }
                if(data.getOperationType().equalsIgnoreCase("LIST_TICKETS")){
                    System.out.println("Tickets ArrayList request received");
                    ArrayList<Tickets> tickets = db.getTickets();
                    PackageData packageData = new PackageData();
                    packageData.setTickets(tickets);
                    outputStream.writeObject(packageData);
                    System.out.println("Tickets ArrayList was sent to the stream");
                }
                if(data.getOperationType().equalsIgnoreCase("ADD_CITY")){
                    Cities city = data.getCity();
                    db.addTheCity(city);
                    System.out.println("City object was received and sent to the database");
                }
                if(data.getOperationType().equalsIgnoreCase("ADD_AIRPLANE")){
                    Airplanes airplane = data.getAirplane();
                    db.addTheAirplane(airplane);
                    System.out.println("Airplane object was received and sent to the database");
                }
                if(data.getOperationType().equalsIgnoreCase("UPDATE_AIRPLANE")){
                    Airplanes airplane = data.getAirplane();
                    db.updateTheAirplane(airplane);
                    System.out.println("Airplane object was received and sent to the database");
                }
                if(data.getOperationType().equalsIgnoreCase("UPDATE_CITY")){
                    Cities city = data.getCity();
                    db.updateTheCity(city);
                    System.out.println("City object was received and sent to the database");
                }
                if(data.getOperationType().equalsIgnoreCase("UPDATE_TICKET")){
                    Tickets ticket = data.getTicket();
                    db.updateTheTicket(ticket);
                    System.out.println("Ticket object was received and sent to the database");
                }
                if(data.getOperationType().equalsIgnoreCase("UPDATE_FLIGHT")){
                    Flights flight = data.getFlight();
                    db.updateTheFlight(flight);
                    System.out.println("Flight object was received and sent to the database");
                }
                if(data.getOperationType().equalsIgnoreCase("DELETE_AIRPLANE")){
                    Airplanes airplane = data.getAirplane();
                    db.deleteTheAirplane(airplane);
                    System.out.println("Delete Airplane object query was received and sent to the database");
                }
                if(data.getOperationType().equalsIgnoreCase("DELETE_CITY")){
                    Cities x = data.getCity();
                    db.deleteTheCity(x);
                    System.out.println("Delete City object query was received and sent to the database");
                }
                if(data.getOperationType().equalsIgnoreCase("DELETE_FLIGHT")){
                    Flights x = data.getFlight();
                    db.deleteTheFlight(x);
                    System.out.println("Delete Flight object query was received and sent to the database");
                }
                if(data.getOperationType().equalsIgnoreCase("ADD_TICKET")){
                    Tickets x = data.getTicket();
                    db.addTheTicket(x);
                    System.out.println("Ticket Object was received and sent to the database");
                }
                if(data.getOperationType().equalsIgnoreCase("DELETE_TICKET")){
                    Tickets x = data.getTicket();
                    db.deleteTheTicket(x);
                    System.out.println("Ticket Object was received and sent to the database");
                }
            }
        }catch (EOFException eof) {
            System.out.println("The end of the Stream has been reached");
        }
        catch (Exception e) {e.printStackTrace();}
    }
}
