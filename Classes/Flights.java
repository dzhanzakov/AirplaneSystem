package BigProject.Classes;

import java.io.Serializable;

public class Flights implements Serializable {
    private int id;
    private int airplane_id;
    private int departure_city_id;
    private int arrival_city_id;
    private String departure_time;
    private int economy_place_price;
    private int business_place_price;

    public Flights(int id, int airplane_id, int departure_city_id, int arrival_city_id, String departure_time, int economy_place_price, int business_place_price) {
        this.id = id;
        this.airplane_id = airplane_id;
        this.departure_city_id = departure_city_id;
        this.arrival_city_id = arrival_city_id;
        this.departure_time = departure_time;
        this.economy_place_price = economy_place_price;
        this.business_place_price = business_place_price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAirplane_id() {
        return airplane_id;
    }

    public void setAirplane_id(int airplane_id) {
        this.airplane_id = airplane_id;
    }

    public int getDeparture_city_id() {
        return departure_city_id;
    }

    public void setDeparture_city_id(int departure_city_id) {
        this.departure_city_id = departure_city_id;
    }

    public int getArrival_city_id() {
        return arrival_city_id;
    }

    public void setArrival_city_id(int arrival_city_id) {
        this.arrival_city_id = arrival_city_id;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public int getEconomy_place_price() {
        return economy_place_price;
    }

    public void setEconomy_place_price(int economy_place_price) {
        this.economy_place_price = economy_place_price;
    }

    public int getBusiness_place_price() {
        return business_place_price;
    }

    public void setBusiness_place_price(int business_place_price) {
        this.business_place_price = business_place_price;
    }
}
