package controller;

import model.People;

import java.util.ArrayList;
import java.util.List;

public class PeopleController {
    private String name;
    public static List<People> peopleList = new ArrayList<>();

    public void addNewPeople(People people) {
        peopleList.add(people);
    }

    public void editPeopleById(int index, People people) {
        peopleList.set(index, people);
    }

    public PeopleController() {
    }

    public PeopleController(String name) {
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
        PeopleController.peopleList = peopleList;
    }

    @Override
    public String toString() {
        return "PeopleController{" +
                "name='" + name + '\'' +
                '}';
    }
}
