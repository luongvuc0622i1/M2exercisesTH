package storage;

import model.Bill;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile implements ReadWriteData {
    private static ReadWriteFile instance = null;

    private ReadWriteFile() {
    }

    public static ReadWriteFile getInstance() {
        if (instance == null) instance = new ReadWriteFile();
        return instance;
    }

    @Override
    public void writeData(List<Bill> billList, String pathOut) {
        try {
            FileOutputStream fos = new FileOutputStream(pathOut);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(billList);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Bill> readData(String pathIn) {
        List<Bill> orderList = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(pathIn);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            orderList = (List<Bill>) obj;
            return orderList;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
