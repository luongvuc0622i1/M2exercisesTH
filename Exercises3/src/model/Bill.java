package model;

import java.io.Serializable;

public class Bill implements Serializable {
    private Customer customer;
    private int oldIndex;
    private int newIndex;

    public Bill() {
    }

    public Bill(Customer customer, int oldIndex, int newIndex) {
        this.customer = customer;
        this.oldIndex = oldIndex;
        this.newIndex = newIndex;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getOldIndex() {
        return oldIndex;
    }

    public void setOldIndex(int oldIndex) {
        this.oldIndex = oldIndex;
    }

    public int getNewIndex() {
        return newIndex;
    }

    public void setNewIndex(int newIndex) {
        this.newIndex = newIndex;
    }

    @Override
    public String toString() {
        return "Bill{" +
                customer +
                ", oldIndex=" + oldIndex +
                ", newIndex=" + newIndex +
                '}';
    }
}
