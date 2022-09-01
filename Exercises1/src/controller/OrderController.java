package controller;

import model.Order;
import storage.ReadWriteData;
import storage.ReadWriteFile;
import storage.ReadWriteFileExcel;

import java.util.ArrayList;
import java.util.List;

public class OrderController {
    private String name;
    private static ReadWriteData readWriteData = ReadWriteFile.getInstance();
    public static List<Order> orderList = readWriteData.readData();

    public void display() {
        if(orderList.isEmpty()){
            System.out.println("Chưa có phòng nào được đặt!");
        }else {
            for ( Order order : orderList ) {
                System.out.println(order);
            }
        }
    }

    public void addNewOrder(Order order) {
        orderList.add(order);
        readWriteData.writeData(orderList);
    }

    public void editOrderById(int index, Order order) {
        orderList.set(index, order);
        readWriteData.writeData(orderList);
    }

    public void removeOrderById(int index) {
        orderList.remove(index);
        readWriteData.writeData(orderList);
    }

    public OrderController() {
    }

    public OrderController(String name) {
        this.name = name;
    }

    public OrderController(String name, List<Order> list) {
        this.name = name;
        this.orderList = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getList() {
        return orderList;
    }

    public void setList(List<Order> list) {
        this.orderList = list;
    }
}
