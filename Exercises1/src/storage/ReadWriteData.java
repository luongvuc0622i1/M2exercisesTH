package storage;

import model.Order;

import java.util.List;

public interface ReadWriteData {
    List<Order> readData();
    void writeData(List<Order> books);
}
