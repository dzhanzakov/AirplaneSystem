package BigProject;

import BigProject.Classes.*;

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

    public ArrayList<Flights> getFlights(){
        ArrayList<Flights> flights = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM flights");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int ai = rs.getInt("aircraft_id");
                int dci = rs.getInt("departure_city_id");
                int aci = rs.getInt("arrival_city_id");
                String dt = rs.getString("departure_time");
                int epp = rs.getInt("economy_place_price");
                int bpp = rs.getInt("business_place_price");
                flights.add(new Flights(id,ai,dci,aci,dt,epp,bpp));
            }
        }catch (Exception e){e.printStackTrace();}
        return flights;
    }
    public ArrayList<Tickets> getTickets(){
        ArrayList<Tickets> tickets = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM tickets");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int fi = rs.getInt("flight_id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String pn = rs.getString("passport_number");
                String tt = rs.getString("ticket_type");
                tickets.add(new Tickets(id,fi,name,surname,pn,tt));
            }
        }catch (Exception e){e.printStackTrace();}
        return tickets;
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

    public void addTheTicket(Tickets t){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO tickets(id,flight_id,name,surname,passport_number,ticket_type) VALUES(NULL,?,?,?,?,?)");
            st.setInt(1,t.getFlight_id());
            st.setString(2,t.getName());
            st.setString(3,t.getSurname());
            st.setString(4,t.getPassport_number());
            st.setString(5,t.getTicket_type());
            st.executeUpdate();
            st.close();
        }catch (Exception e){e.printStackTrace();}
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

    public void updateTheAirplane(Airplanes airplanes){
        try{
            PreparedStatement st = connection.prepareStatement("UPDATE airplanes SET name = ?, model = ?, business_class_capacity = ?, economy_class_capacity = ? WHERE id = ?");
            st.setString(1, airplanes.getName());
            st.setString(2, airplanes.getModel());
            st.setInt(3,airplanes.getBusiness_class_capacity());
            st.setInt(4,airplanes.getEconomy_class_capacity());
            st.setInt(5,airplanes.getId());
            st.executeUpdate();
            st.close();
        }catch (Exception e){e.printStackTrace();}

    }

    public void updateTheCity(Cities city){
        try{
            PreparedStatement st = connection.prepareStatement("UPDATE cities SET name = ?, country = ?, short_name = ? WHERE id = ?");
            st.setString(1,city.getName());
            st.setString(2,city.getCountry());
            st.setString(3,city.getShort_name());
            st.setInt(4,city.getId());
            st.executeUpdate();
            st.close();
        }catch (Exception e){e.printStackTrace();}
    }

    public void updateTheFlight(Flights f){
        try{
            PreparedStatement st = connection.prepareStatement("UPDATE flights SET aircraft_id = ?,departure_city_id = ?, arrival_city_id = ?, departure_time = ?, economy_place_price = ?, business_place_price = ? WHERE id = ?");
            st.setInt(1,f.getAirplane_id());
            st.setInt(2,f.getDeparture_city_id());
            st.setInt(3,f.getArrival_city_id());
            st.setString(4,f.getDeparture_time());
            st.setInt(5,f.getEconomy_place_price());
            st.setInt(6,f.getBusiness_place_price());
            st.setInt(7,f.getId());
            st.executeUpdate();
            st.close();
        }catch (Exception e){e.printStackTrace();}
    }

    public void deleteTheAirplane(Airplanes x){
        try{
            PreparedStatement st = connection.prepareStatement("DELETE FROM airplanes WHERE id = ?");
            st.setInt(1,x.getId());
            st.executeUpdate();
            st.close();
        }catch (Exception e){e.printStackTrace();}
    }

    public void deleteTheCity(Cities x){
        try{
            PreparedStatement st = connection.prepareStatement("DELETE FROM cities WHERE id = ?");
            st.setInt(1,x.getId());
            st.executeUpdate();
            st.close();
        }catch (Exception e){e.printStackTrace();}
    }

    public void deleteTheFlight(Flights x){
        try{
            PreparedStatement st = connection.prepareStatement("DELETE FROM flights WHERE id = ?");
            st.setInt(1,x.getId());
            st.executeUpdate();
            st.close();
        }catch (Exception e){e.printStackTrace();}
    }
}