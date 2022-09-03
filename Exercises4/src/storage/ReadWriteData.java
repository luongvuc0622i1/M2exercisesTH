package storage;

import model.IdCard;

import java.util.List;

public interface ReadWriteData {
    List<IdCard> readData(String path);
    void writeData(List<IdCard> databooks, String path);
}
