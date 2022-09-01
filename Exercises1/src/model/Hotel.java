package model;

public class Hotel {
    private int idRoom;
    private String typeRoom;
    private int price;

    public Hotel() {
    }

    public Hotel(int idRoom, String typeRoom, int price) {
        this.idRoom = idRoom;
        this.typeRoom = typeRoom;
        this.price = price;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "idRoom=" + idRoom +
                ", typeRoom='" + typeRoom + '\'' +
                ", price=" + price +
                '}';
    }
}
