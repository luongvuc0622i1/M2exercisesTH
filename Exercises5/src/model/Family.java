package model;

import java.io.Serializable;
import java.util.List;

public class Family implements Serializable {
    private int numberOfPeople;
    private String adress;
    private List<People> people;

    public Family() {
    }

    public Family(int numberOfPeople, String adress, List<People> people) {
        this.numberOfPeople = numberOfPeople;
        this.adress = adress;
        this.people = people;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<People> getPeople() {
        return people;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Family{" +
                "numberOfPeople=" + numberOfPeople +
                ", adress='" + adress + '\'' +
                ", people=" + people +
                '}';
    }
}
