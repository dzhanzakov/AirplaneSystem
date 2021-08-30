package BigProject;

import BigProject.ChangePageClasses.*;
import BigProject.Classes.Airplanes;
import BigProject.Classes.Cities;
import BigProject.Classes.Flights;
import BigProject.Classes.PackageData;
import BigProject.CreatePageClasses.CreateAirplane;
import BigProject.CreatePageClasses.CreateCity;
import BigProject.CreatePageClasses.CreateFlight;
import BigProject.CreatePageClasses.CreateMenu;
import BigProject.DeletePageClasses.DeleteAirplane;
import BigProject.DeletePageClasses.DeleteCity;
import BigProject.DeletePageClasses.DeleteFlight;
import BigProject.DeletePageClasses.DeleteMenu;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class GuiAdmin extends JFrame {
    private MainPageForAdmin main;
    private CreateMenu createMenu;
    private CreateAirplane createAirplane;
    private CreateCity createCity;
    private CreateFlight createFlight;
    private ChangeMenu changeMenu;
    private ChangeAirplane changeAirplane;
    private ChangeAirplaneValues changeAirplaneValues;
    private ChangeCity changeCity;
    private ChangeCityValues changeCityValues;
    private ChangeFlight changeFlight;
    private ChangeFlightValues changeFlightValues;
    private DeleteMenu deleteMenu;
    private DeleteAirplane deleteAirplane;
    private DeleteCity deleteCity;
    private DeleteFlight deleteFlight;
    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;


    public GuiAdmin(Socket socket, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream){
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

            changeAirplaneValues = new ChangeAirplaneValues(this);
            changeAirplaneValues.setVisible(false);
            add(changeAirplaneValues);

            changeCity = new ChangeCity(this);
            changeCity.setVisible(false);
            add(changeCity);

            changeCityValues = new ChangeCityValues(this);
            changeCityValues.setVisible(false);
            add(changeCityValues);

            changeFlight = new ChangeFlight(this);
            changeFlight.setVisible(false);
            add(changeFlight);

            changeFlightValues = new ChangeFlightValues(this);
            changeFlightValues.setVisible(false);
            add(changeFlightValues);

            deleteMenu = new DeleteMenu(this);
            deleteMenu.setVisible(false);
            add(deleteMenu);

            deleteAirplane = new DeleteAirplane(this);
            deleteAirplane.setVisible(false);
            add(deleteAirplane);

            deleteCity = new DeleteCity(this);
            deleteCity.setVisible(false);
            add(deleteCity);

            deleteFlight = new DeleteFlight(this);
            deleteFlight.setVisible(false);
            add(deleteFlight);

        }catch (Exception e){ e.printStackTrace(); }
    }

    public DeleteFlight getDeleteFlight() {
        return deleteFlight;
    }

    public void setDeleteFlight(DeleteFlight deleteFlight) {
        this.deleteFlight = deleteFlight;
    }

    public DeleteCity getDeleteCity() {
        return deleteCity;
    }

    public void setDeleteCity(DeleteCity deleteCity) {
        this.deleteCity = deleteCity;
    }

    public DeleteAirplane getDeleteAirplane() {
        return deleteAirplane;
    }

    public void setDeleteAirplane(DeleteAirplane deleteAirplane) {
        this.deleteAirplane = deleteAirplane;
    }

    public DeleteMenu getDeleteMenu() {
        return deleteMenu;
    }

    public void setDeleteMenu(DeleteMenu deleteMenu) {
        this.deleteMenu = deleteMenu;
    }

    public ChangeFlightValues getChangeFlightValues() {
        return changeFlightValues;
    }

    public void setChangeFlightValues(ChangeFlightValues changeFlightValues) {
        this.changeFlightValues = changeFlightValues;
    }

    public ChangeFlight getChangeFlight() {
        return changeFlight;
    }

    public void setChangeFlight(ChangeFlight changeFlight) {
        this.changeFlight = changeFlight;
    }

    public ChangeCity getChangeCity() {
        return changeCity;
    }

    public void setChangeCity(ChangeCity changeCity) {
        this.changeCity = changeCity;
    }

    public ChangeAirplaneValues getChangeAirplaneValues() {
        return changeAirplaneValues;
    }

    public void setChangeAirplaneValues(ChangeAirplaneValues changeAirplaneValues) {
        this.changeAirplaneValues = changeAirplaneValues;
    }

    protected Socket getSocket(){
        return socket;
    }

    public ChangeCityValues getChangeCityValues() {
        return changeCityValues;
    }

    public void setChangeCityValues(ChangeCityValues changeCityValues) {
        this.changeCityValues = changeCityValues;
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

    public void addFlight(Flights flight){
        try{
            PackageData packageData = new PackageData("ADD_FLIGHT",null,null,null,flight,null,null,null,null);
            objectOutputStream.writeObject(packageData);
            System.out.println("flight packageData has been written to the stream -> " + packageData.getOperationType());
        }catch (Exception e){e.printStackTrace();}
    }

    public void addAirplane(Airplanes airplane){
        try{
            PackageData packageData = new PackageData("ADD_AIRPLANE",null,airplane,null,null,null,null,null,null);
            objectOutputStream.writeObject(packageData);
            System.out.println("airplane packageData has been written to the stream -> " + packageData.getOperationType());
        }catch (Exception e){e.printStackTrace();}
    }

    public void addCity(Cities city){
        try{
            PackageData packageData = new PackageData("ADD_CITY", null, null, city,null,null,null,null,null);
            objectOutputStream.writeObject(packageData);
            System.out.println("city packageData has been written to the stream -> " + packageData.getOperationType());
        }catch (Exception e){e.printStackTrace();}
    }

    public void updateAirplane(Airplanes airplane){
        try{
            PackageData packageData = new PackageData("UPDATE_AIRPLANE");
            packageData.setAirplane(airplane);
            objectOutputStream.writeObject(packageData);
            System.out.println("airplane packageData has been written to the stream -> " + packageData.getOperationType());
        }catch (Exception e){e.printStackTrace();}
    }

    public void updateCity(Cities city){
        try{
            PackageData packageData = new PackageData("UPDATE_CITY");
            packageData.setCity(city);
            objectOutputStream.writeObject(packageData);
            System.out.println("city packageData has been written to the stream -> " + packageData.getOperationType());
        }catch (Exception e){e.printStackTrace();}
    }

    public void updateFlight(Flights flight){
        try{
            PackageData packageData = new PackageData("UPDATE_FLIGHT");
            packageData.setFlight(flight);
            objectOutputStream.writeObject(packageData);
            System.out.println("flight packageData has been written to the stream -> " + packageData.getOperationType());
        }catch (Exception e){e.printStackTrace();}
    }

    public void deleteAirplane(Airplanes airplane){
        try{
            PackageData packageData = new PackageData("DELETE_AIRPLANE");
            packageData.setAirplane(airplane);
            objectOutputStream.writeObject(packageData);
            System.out.println("airplane packageData has been written to the stream -> " + packageData.getOperationType());
        }catch (Exception e){e.printStackTrace();}
    }

    public void deleteCity(Cities city){
        try{
            PackageData packageData = new PackageData("DELETE_CITY");
            packageData.setCity(city);
            objectOutputStream.writeObject(packageData);
            System.out.println("city packageData has been written to the stream -> " + packageData.getOperationType());
        }catch (Exception e){e.printStackTrace();}
    }

    public void deleteFlight(Flights flight){
        try{
            PackageData packageData = new PackageData("DELETE_FLIGHT");
            packageData.setFlight(flight);
            objectOutputStream.writeObject(packageData);
            System.out.println("flight packageData has been written to the stream -> " + packageData.getOperationType());
        }catch (Exception e){e.printStackTrace();}
    }
}
