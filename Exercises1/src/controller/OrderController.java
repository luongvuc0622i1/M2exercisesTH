package controller;

import model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderController {
    private String name;
    public static List<Order> orderList = new ArrayList<>();

    public void addNewOrder(Order order) {
        orderList.add(order);
    }

    public void editOrderById(int index, Order order) {
        orderList.set(index, order);
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
