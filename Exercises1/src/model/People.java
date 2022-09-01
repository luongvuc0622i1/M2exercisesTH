package model;

public class People {
    private String name;
    private String DateOfBirth;
    private String idCard;

    public People() {
    }

    public People(String name, String dateOfBirth, String idCard) {
        this.name = name;
        DateOfBirth = dateOfBirth;
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                ", idCard='" + idCard +
                "'}";
    }
}
