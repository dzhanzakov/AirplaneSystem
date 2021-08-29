package BigProject;


import BigProject.Classes.Airplanes;
import BigProject.Classes.Cities;
import BigProject.Classes.Flights;
import BigProject.Classes.PackageData;

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
                    System.out.println("Airplanes ArrayList was sent");
                }
                if(data.getOperationType().equalsIgnoreCase("LIST_CITIES")){
                    System.out.println("Cities ArrayList request received");
                    ArrayList<Cities> cities = db.getCities();
                    PackageData packageData = new PackageData();
                    packageData.setCities(cities);
                    outputStream.writeObject(packageData);
                    System.out.println("Cities ArrayList was sent");
                }
                if(data.getOperationType().equalsIgnoreCase("ADD_FLIGHT")){
                    Flights flight = data.getFlight();
                    db.addTheFlight(flight);
                    System.out.println("Flight Object was received and sent to the database");
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
            }
        }catch (Exception e) {e.printStackTrace();}
    }
}
