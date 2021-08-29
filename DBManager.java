package BigProject;

import BigProject.Classes.Airplanes;
import BigProject.Classes.Cities;
import BigProject.Classes.Flights;
import BigProject.Classes.PackageData;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private Connection connection;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/airlineSystemDatabase?useUnicode=true&serverTimezone=UTC", "root", ""
            );
            DatabaseMetaData metaData = connection.getMetaData();
            String name = metaData.getDatabaseProductName();
            String name1 = connection.getCatalog();
            String version = metaData.getDriverVersion();
            System.out.println("database connected\n" + name1 + "\n" + name + "\n" + version);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Airplanes> getAirplanes(){
        ArrayList<Airplanes> airplanes = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM airplanes");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String model = rs.getString("model");
                int bcc = rs.getInt("business_class_capacity");
                int ecc = rs.getInt("economy_class_capacity");
                airplanes.add(new Airplanes(id, name, model, bcc, ecc));
            }
        }catch (Exception e){e.printStackTrace();}
        return airplanes;
    }

    public ArrayList<Cities> getCities(){
        ArrayList<Cities> cities = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM cities");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String country = rs.getString("country");
                String sn = rs.getString("short_name");
                cities.add(new Cities(id,name,country,sn));
            }
        }catch (Exception e){e.printStackTrace();}
        return cities;
    }

    public void addTheFlight(Flights flights){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO flights(id, aircraft_id, departure_city_id, arrival_city_id, departure_time, economy_place_price, business_place_price) VALUES(NULL,?,?,?,?,?,?)");
            st.setInt(1,flights.getAirplane_id());
            st.setInt(2,flights.getDeparture_city_id());
            st.setInt(3,flights.getArrival_city_id());
            st.setString(4,flights.getDeparture_time());
            st.setInt(5,flights.getEconomy_place_price());
            st.setInt(6,flights.getBusiness_place_price());
            st.executeUpdate();
            st.close();
        }catch (Exception e){e.printStackTrace();}
    }

    public void addTheCity(Cities city){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO cities(id,name,country,short_name) VALUES(NULL,?,?,?)");
            st.setString(1,city.getName());
            st.setString(2,city.getCountry());
            st.setString(3,city.getShort_name());
            st.executeUpdate();
            st.close();
        }catch (Exception ex){ex.printStackTrace();}
    }

    public void addTheAirplane(Airplanes airplane){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO airplanes(id,name,model,business_class_capacity,economy_class_capacity) VALUES(NULL,?,?,?,?)");
            st.setString(1,airplane.getName());
            st.setString(2,airplane.getModel());
            st.setInt(3,airplane.getBusiness_class_capacity());
            st.setInt(4,airplane.getEconomy_class_capacity());
            st.executeUpdate();
            st.close();
        }catch (Exception exception){exception.printStackTrace();}
    }
}