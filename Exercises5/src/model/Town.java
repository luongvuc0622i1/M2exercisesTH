package model;

import java.io.Serializable;
import java.util.List;

public class Town implements Serializable {
    private int numberOfFamily;
    private List<Family> families;

    public Town() {
    }

    public Town(int numberOfFamily, List<Family> families) {
        this.numberOfFamily = numberOfFamily;
        this.families = families;
    }

    public int getNumberOfFamily() {
        return numberOfFamily;
    }

    public void setNumberOfFamily(int numberOfFamily) {
        this.numberOfFamily = numberOfFamily;
    }

    public List<Family> getFamilies() {
        return families;
    }

    public void setFamilies(List<Family> families) {
        this.families = families;
    }
}
