package model;

import java.io.Serializable;

public class Customer implements Serializable {
    private String ownerName;
    private String Address;
    private int idElectricMeter;

    public Customer() {
    }

    public Customer(String ownerName, String address, int idElectricMeter) {
        this.ownerName = ownerName;
        Address = address;
        this.idElectricMeter = idElectricMeter;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getIdElectricMeter() {
        return idElectricMeter;
    }

    public void setIdElectricMeter(int idElectricMeter) {
        this.idElectricMeter = idElectricMeter;
    }

    @Override
    public String toString() {
        return "customer{" +
                "ownerName='" + ownerName + '\'' +
                ", Address='" + Address + '\'' +
                ", idElectricMeter=" + idElectricMeter +
                '}';
    }
}
