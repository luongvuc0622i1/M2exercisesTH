package storage;

import java.util.List;

public interface ReadWriteData<T> {
    List<T> readData(String pathIn);
    void writeData(List<T> books, String pathOut);
}
