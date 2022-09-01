package storage;

import model.Order;

import java.util.List;

public interface ReadWriteData {
    List<Order> readData(String pathIn);
    void writeData(List<Order> books, String pathOut);
}
