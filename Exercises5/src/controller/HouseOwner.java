package controller;

import model.People;
import storage.ReadWriteData;
import storage.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class HouseOwner {
    private String name;
    private static ReadWriteData<People> readWriteData = ReadWriteFile.getInstance();
    public static List<People> peopleList = new ArrayList<People>();

    public HouseOwner() {
    }

    public HouseOwner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<People> getPeopleList() {
        return peopleList;
    }

    public static void setPeopleList(List<People> peopleList) {
        HouseOwner.peopleList = peopleList;
    }
}
