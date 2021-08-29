package BigProject;

import BigProject.Classes.Airplanes;
import BigProject.Classes.Cities;
import BigProject.Classes.Flights;
import BigProject.Classes.PackageData;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Gui extends JFrame {
    private MainPageForAdmin main;
    private CreateMenu createMenu;
    private CreateAirplane createAirplane;
    private CreateCity createCity;
    private CreateFlight createFlight;
    private ChangeMenu changeMenu;
    private ChangeAirplane changeAirplane;
    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;


    public Gui(Socket socket, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream){
        try{
            this.socket = socket;
            this.objectInputStream = objectInputStream;
            this.objectOutputStream = objectOutputStream;

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("Admin");
            setSize(700, 600);
            setLayout(null);

            main = new MainPageForAdmin(this);
            main.setVisible(true);
            add(main);

            createMenu = new CreateMenu(this);
            createMenu.setVisible(false);
            add(createMenu);

            createAirplane = new CreateAirplane(this);
            createAirplane.setVisible(false);
            add(createAirplane);

            createCity = new CreateCity(this);
            createCity.setVisible(false);
            add(createCity);

            createFlight = new CreateFlight(this);
            createFlight.setVisible(false);
            add(createFlight);

            changeMenu = new ChangeMenu(this);
            changeMenu.setVisible(false);
            add(changeMenu);

            changeAirplane = new ChangeAirplane(this);
            changeAirplane.setVisible(false);
            add(changeAirplane);

        }catch (Exception e){ e.printStackTrace(); }
    }

    public ChangeAirplane getChangeAirplane() {
        return changeAirplane;
    }

    public void setChangeAirplane(ChangeAirplane changeAirplane) {
        this.changeAirplane = changeAirplane;
    }

    public ChangeMenu getChangeMenu() {
        return changeMenu;
    }

    public void setChangeMenu(ChangeMenu changeMenu) {
        this.changeMenu = changeMenu;
    }

    public CreateFlight getCreateFlight() {
        return createFlight;
    }

    public void setCreateFlight(CreateFlight createFlight) {
        this.createFlight = createFlight;
    }

    public CreateCity getCreateCity() {
        return createCity;
    }

    public void setCreateCity(CreateCity createCity) {
        this.createCity = createCity;
    }

    public MainPageForAdmin getMain() {
        return main;
    }

    public void setMain(MainPageForAdmin main) {
        this.main = main;
    }

    public CreateMenu getCreateMenu() {
        return createMenu;
    }

    public void setCreateMenu(CreateMenu createMenu) {
        this.createMenu = createMenu;
    }

    public CreateAirplane getCreateAirplane() {
        return createAirplane;
    }

    public void setCreateAirplane(CreateAirplane createAirplane) {
        this.createAirplane = createAirplane;
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
            System.out.println("flight packageData has been sent");
        }catch (Exception e){e.printStackTrace();}
    }

    public void addAirplane(Airplanes airplane){
        try{
            PackageData packageData = new PackageData("ADD_AIRPLANE",null,airplane,null,null,null,null,null,null);
            objectOutputStream.writeObject(packageData);
            System.out.println("airplane packageData has been sent");
        }catch (Exception e){e.printStackTrace();}
    }

    public void addCity(Cities city){
        try{
            PackageData packageData = new PackageData("ADD_CITY", null, null, city,null,null,null,null,null);
            objectOutputStream.writeObject(packageData);
            System.out.println("city packageData has been sent");
        }catch (Exception e){e.printStackTrace();}
    }
}
