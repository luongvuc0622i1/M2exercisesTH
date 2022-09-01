package storage;

import model.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFileExcel implements ReadWriteData {
    private static ReadWriteFileExcel instance=null;

    private ReadWriteFileExcel() {
    }

    public static ReadWriteFileExcel getInstance(){
        if (instance == null) instance = new ReadWriteFileExcel();
        return instance;
    }

    @Override
    public List<Order> readData() {
        List<Order> orderList = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("orderList.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            orderList = (List<Order>) obj;
            return orderList;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeData(List<Order> orderList) {
        try {
            FileOutputStream fos = new FileOutputStream("orderList.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(orderList);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}