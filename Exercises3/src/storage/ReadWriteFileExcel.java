package storage;

import model.Bill;

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

    @Override
    public void writeData(List<Bill> orderList, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
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
