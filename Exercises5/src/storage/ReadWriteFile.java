package storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile<T> implements ReadWriteData<T> {
    private static ReadWriteFile instance = null;

    private ReadWriteFile() {
    }

    public static ReadWriteFile getInstance() {
        if (instance == null) instance = new ReadWriteFile();
        return instance;


    }

    @Override
    public List<T> readData(String pathIn) {
        List<T> list = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(pathIn);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            list = (List<T>) obj;
            return list;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeData(List<T> list, String pathOut) {
        try {
            FileOutputStream fos = new FileOutputStream(pathOut);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}