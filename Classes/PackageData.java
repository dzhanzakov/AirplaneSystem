package BigProject.Classes;

import BigProject.Classes.Airplanes;
import BigProject.Classes.Cities;
import BigProject.Classes.Flights;
import BigProject.Classes.Tickets;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;
    private Tickets ticket;
    private Airplanes airplane;
    private Cities city;
    private Flights flight;

    private ArrayList<Flights> flights;
    private ArrayList<Airplanes> airplanes;
    private ArrayList<Cities> cities;
    private ArrayList<Tickets> tickets;

    public PackageData(String operationType, Tickets ticket, Airplanes airplane, Cities city, Flights flight, ArrayList<Flights> flights, ArrayList<Airplanes> airplanes, ArrayList<Cities> cities, ArrayList<Tickets> tickets) {
        this.operationType = operationType;
        this.ticket = ticket;
        this.airplane = airplane;
        this.city = city;
        this.flight = flight;
        this.flights = flights;
        this.airplanes = airplanes;
        this.cities = cities;
        this.tickets = tickets;
    }

    public PackageData(String operationType){
        this.operationType = operationType;
    }

    public PackageData() {
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Tickets getTicket() {
        return ticket;
    }

    public void setTicket(Tickets ticket) {
        this.ticket = ticket;
    }

    public Airplanes getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplanes airplane) {
        this.airplane = airplane;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public Flights getFlight() {
        return flight;
    }

    public void setFlight(Flights flight) {
        this.flight = flight;
    }

    public ArrayList<Flights> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flights> flights) {
        this.flights = flights;
    }

    public ArrayList<Airplanes> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(ArrayList<Airplanes> airplanes) {
        this.airplanes = airplanes;
    }

    public ArrayList<Cities> getCities() {
        return cities;
    }

    public void setCities(ArrayList<Cities> cities) {
        this.cities = cities;
    }

    public ArrayList<Tickets> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Tickets> tickets) {
        this.tickets = tickets;
    }
}
