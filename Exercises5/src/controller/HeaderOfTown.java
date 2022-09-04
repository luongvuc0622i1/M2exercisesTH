package controller;

import model.Family;
import model.People;
import storage.ReadWriteData;
import storage.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class HeaderOfTown {
    private String name;
    private static ReadWriteData<Family> readWriteData = ReadWriteFile.getInstance();
    public static List<Family> familyList = new ArrayList<Family>();

    public HeaderOfTown() {
    }

    public HeaderOfTown(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Family> getFamilyList() {
        return familyList;
    }

    public static void setFamilyList(List<Family> familyList) {
        HeaderOfTown.familyList = familyList;
    }
}
