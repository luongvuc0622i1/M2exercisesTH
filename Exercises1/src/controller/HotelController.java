package controller;

import model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelController {
    private String name;
    public static List<Hotel> hotelList = new ArrayList<>();

    static {
        hotelList.add(new Hotel(101, "Medium", 500));
        hotelList.add(new Hotel(102, "Medium", 500));
        hotelList.add(new Hotel(103, "Doublex", 500));
        hotelList.add(new Hotel(201, "Medium", 500));
        hotelList.add(new Hotel(205, "Vip", 500));
    }

    public HotelController() {
    }

    public HotelController(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Hotel> getHotelList() {
        return hotelList;
    }

    public static void setHotelList(List<Hotel> hotelList) {
        HotelController.hotelList = hotelList;
    }
}
