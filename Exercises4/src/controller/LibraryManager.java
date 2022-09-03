package controller;

import model.IdCard;
import storage.ReadWriteData;
import storage.ReadWriteFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibraryManager {
    private String name;
    private static ReadWriteData readWriteData = ReadWriteFile.getInstance();
    public static List<IdCard> orderList = new ArrayList<IdCard>();

    public List<IdCard> displayCheckTime(Date checkTime, String path) {
        orderList = readWriteData.readData(path);
        List<IdCard> orderCheckList = new ArrayList<>();
        boolean check = false;
        for (int i = 0 ; i < orderList.size(); i++) {
            if (orderList.get(i).getEndTime().compareTo(checkTime) < 0) {
                orderCheckList.add(orderList.get(i));
            }
        }
        return orderCheckList;
    }

    public void display(String path) {
        orderList = readWriteData.readData(path);
        if(orderList.isEmpty()){
            System.out.println("Chưa có phòng nào được đặt!");
        }else {
            for ( IdCard order : orderList ) {
                System.out.println(order);
            }
        }
    }

    public void addNewOrder(IdCard order, String path) {
        orderList = readWriteData.readData(path);
        orderList.add(order);
        readWriteData.writeData(orderList, path);
    }

    public void editOrderById(int index, IdCard order, String path) {
        orderList = readWriteData.readData(path);
        orderList.set(index, order);
        readWriteData.writeData(orderList, path);
    }

    public void removeOrderById(int index, String path) {
        orderList = readWriteData.readData(path);
        orderList.remove(index);
        readWriteData.writeData(orderList, path);
    }

    public LibraryManager() {
    }

    public LibraryManager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<IdCard> getOrderList() {
        return orderList;
    }

    public static void setOrderList(List<IdCard> orderList) {
        LibraryManager.orderList = orderList;
    }
}
