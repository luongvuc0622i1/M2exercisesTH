package storage;

import model.Order;

import java.util.List;

public class TestRead {
    public static void main(String[] args) {
        ReadWriteData readWriteData = ReadWriteFile.getInstance();
        List<Order> orderList = readWriteData.readData();
        for (int i=0 ; i < orderList.size() ; i++) {
            System.out.println(orderList.get(i));
        }
    }
}
