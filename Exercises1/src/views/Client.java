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
        System.out.println("Bạn là:");
        System.out.println("1. Quản lý");
        System.out.println("2. Lễ tân/Khách");
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập lựa chọn vào đây: ");
        int index = input.nextInt();
        switch (index) {
            case 1:
                isAManager();
                break;
            case 2:
                isAReceptionist();
                break;
            default:
                System.out.println("Nhập sai lựa chọn!");
        }
    }

    private static void isAManager() {
        HotelController manager = new HotelController("Quản lý");
        System.out.println("1. Thêm 1 phòng mới");
        System.out.println("2. Sửa thông tin của 1 phòng");
        System.out.println("3. Hiển thị danh sách phòng");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập lựa chọn vào đây");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
            case 2:
            case 3:
            default:
                System.out.println("Nhập sai lựa chọn!");
        }
//                Hotel hotel = creatNewHotel();
//                manager.addNewHotel(hotel);
//                manager.editHotelById(1, hotel);
//                System.out.println(HotelController.hotelList);
    }

    private static void isAReceptionist() {
        OrderController receptionist = new OrderController("Lễ tân");
        System.out.println("1. Thêm mới order");
        System.out.println("2. Sửa order");
        System.out.println("3. Xoá order");
        System.out.println("4. Hiển thị danh sách order");
        System.out.println("5. Tính số tiền của một order");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập lựa chọn vào đây: ");
        int index = scanner.nextInt();
        switch (index) {
            case 1:
                addOrder(receptionist);
                break;
            case 2:
                editOrder(receptionist);
                break;
            case 3:
                removeOrder(receptionist);
                break;
            case 4:
                displayOrder(receptionist);
                break;
            case 5:
                caculatorMoneyOrder(receptionist);
                break;
            default:
                System.out.println("Nhập sai lựa chọn!");
        }
    }

    private static void caculatorMoneyOrder(OrderController receptionist) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Nhập tên file nguồn: ");
        String path = scanner1.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Nhập vào số CMND của khách hàng cần tính tiền: ");
        String idCard = scanner2.nextLine();
        int money = receptionist.calculateMoneyOrder(idCard, path);
        System.out.println("Số tiền vị khách này cần thanh toán là: " + money);
    }

    private static void displayOrder(OrderController receptionist) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên file nguồn: ");
        String path = scanner.nextLine();
        receptionist.display(path);
    }

    private static void removeOrder(OrderController receptionist) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Nhập tên file nguồn: ");
        String path = scanner1.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Nhập vào vị trí muốn xoá: ");
        int index = scanner2.nextInt();
        receptionist.removeOrderById(index, path);
    }

    private static void editOrder(OrderController receptionist) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Nhập tên file nguồn: ");
        String path = scanner1.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Nhập vào vị trí muốn sửa: ");
        int index = scanner2.nextInt();
        Order order = creatNewOrder();
        receptionist.editOrderById(index, order, path);
    }

    private static void addOrder(OrderController receptionist) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên file nguồn: ");
        String path = scanner.nextLine();
        Order order = creatNewOrder();
        receptionist.addNewOrder(order, path);
    }

    private static Hotel creatNewHotel() {
        Hotel hotel;
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Nhập vào mã phòng: ");
        int idRoom = scanner1.nextInt();
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Nhập vào loại phòng: ");
        String typeRoom = scanner2.nextLine();
        Scanner scanner3 = new Scanner(System.in);
        System.out.print("Nhập vào giá phòng: ");
        int price = scanner3.nextInt();
        hotel = new Hotel(idRoom, typeRoom, price);
        return hotel;
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
            System.out.print("Nhập vào mã phòng đã chọn: ");
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
