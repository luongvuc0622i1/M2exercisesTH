package views;

import controller.HotelController;
import controller.OrderController;
import model.Hotel;
import model.Order;
import model.People;
import java.util.List;
import java.util.Scanner;

public class Client {
    private static List<Order> orderList = OrderController.orderList;
    private static List<Hotel> hotelList = HotelController.hotelList;

    public static void main(String[] args) {
        HotelController manager1 = new HotelController("manager1");
        OrderController letan = new OrderController("letan");

        Order order = creatNewOrder();
        letan.addNewOrder(order);
        System.out.println(OrderController.orderList);
    }

    private static Order creatNewOrder() {
        Order order;
        People people = creatNewPeople();

        String typeRoom = inputTypeRoom();
        Hotel roomChecked = inputIdRoom(typeRoom);
        int dateRent = inputDateRent();

        order = new Order(dateRent, people, roomChecked);
        return order;
    }

    private static int inputDateRent() {
        Scanner input6 = new Scanner(System.in);
        System.out.print("Nhập số ngày muốn thuê: ");
        int dateRent = input6.nextInt();
        return dateRent;
    }

    private static Hotel inputIdRoom(String typeRoom) {
        System.out.print("Chọn số phòng trong danh sách sau: ");
        for ( int i = 0 ; i < hotelList.size() ; i++ ) {
            if (hotelList.get(i).getTypeRoom().equals(typeRoom)) {
                System.out.println(hotelList.get(i));
            }
        }

        boolean check2 = false;
        Hotel roomChecked = null;
        do {
            Scanner input5 = new Scanner(System.in);
            System.out.print("Nhập vào số phòng đã chọn: ");
            int idRoom = input5.nextInt();
            for ( int i = 0 ; i < hotelList.size() ; i++ ) {
                if (hotelList.get(i).getTypeRoom().equals(typeRoom)) {
                    if (hotelList.get(i).getIdRoom() == idRoom) {
                        check2 = true;
                        roomChecked = hotelList.get(i);
                    }
                }
            }
        } while (!check2);
        return roomChecked;
    }

    private static String inputTypeRoom() {
        boolean check1 = true;
        String typeRoom = null;
        do {
            Scanner input4 = new Scanner(System.in);
            System.out.print("Nhập loại phòng muốn thuê: ");
            String inputRoom = input4.nextLine();
            for ( int i = 0 ; i < hotelList.size() ; i++ ) {
                if (hotelList.get(i).getTypeRoom().equals(inputRoom)) {
                    typeRoom = inputRoom;
                    check1 = false;
                }
            }
        } while (check1);
        return typeRoom;
    }

    private static People creatNewPeople() {
        Scanner input1 = new Scanner(System.in);
        System.out.print("Nhập tên của khách hàng: ");
        String name = input1.nextLine();
        Scanner input2 = new Scanner(System.in);
        System.out.print("Nhập ngày/tháng/năm sinh: ");
        String dateOfBirth = input2.nextLine();
        Scanner input3 = new Scanner(System.in);
        System.out.print("Nhập số Căn cước công dân/Hộ chiếu: ");
        String idCard = input3.nextLine();
        People people = new People(name, dateOfBirth, idCard);
        return people;
    }
}
