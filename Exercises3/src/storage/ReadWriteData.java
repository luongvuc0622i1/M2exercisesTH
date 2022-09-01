package storage;

import model.Bill;

import java.util.List;

public interface ReadWriteData {
    List<Bill> readData(String path);
    void writeData(List<Bill> billList, String path);
}
