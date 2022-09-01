package model;

import java.io.Serializable;

public class Order implements Serializable {
    private int dateRent;
    private People people;
    private Hotel hotel;

    public Order() {
    }

    public Order(int dateRent, People people, Hotel hotel) {
        this.dateRent = dateRent;
        this.people = people;
        this.hotel = hotel;
    }

    public int getDateRent() {
        return dateRent;
    }

    public void setDateRent(int dateRent) {
        this.dateRent = dateRent;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Order{" +
                "dateRent=" + dateRent +
                ", " + people +
                ", " + hotel +
                '}';
    }
}
