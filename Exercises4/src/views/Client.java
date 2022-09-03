package views;

import controller.LibraryManager;
import model.IdCard;
import model.Student;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Client {
    private static List<IdCard> orderList = LibraryManager.orderList;

    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager("Thủ thư");
        System.out.println("1. Thêm 1 thẻ mượn mới");
        System.out.println("2. Sửa 1 thẻ mượn");
        System.out.println("3. Xoá 1 thẻ mượn");
        System.out.println("4. In ra danh sách các thẻ sách đang mượn");
        System.out.println("5. In ra danh sách các thẻ sách cần trả vào 1 thời điểm nhập");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập lựa chọn vào đây: ");
        int index = scanner.nextInt();
        switch (index) {
            case 1:
                addOrder(libraryManager);
                break;
            case 2:
                editOrder(libraryManager);
                break;
            case 3:
                removeOrder(libraryManager);
                break;
            case 4:
                displayOrder(libraryManager);
                break;
            case 5:
                displayCheckOrder(libraryManager);
                break;
            default:
                System.out.println("Nhập sai lựa chọn!");
        }
    }

    private static void displayCheckOrder(LibraryManager libraryManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên file nguồn: ");
        String path = scanner.nextLine();
        Date checkTime = inputCheckTime();
        List<IdCard> orderCheckList = libraryManager.displayCheckTime(checkTime, path);
        for (IdCard order : orderCheckList) {
            System.out.println(order);
        }
    }

    private static void displayOrder(LibraryManager libraryManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên file nguồn: ");
        String path = scanner.nextLine();
        libraryManager.display(path);
    }

    private static void removeOrder(LibraryManager libraryManager) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Nhập tên file nguồn: ");
        String path = scanner1.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Nhập vào vị trí muốn xoá: ");
        int index = scanner2.nextInt();
        libraryManager.removeOrderById(index, path);
    }

    private static void editOrder(LibraryManager libraryManager) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Nhập tên file nguồn: ");
        String path = scanner1.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Nhập vào vị trí muốn sửa: ");
        int index = scanner2.nextInt();
        IdCard order = creatNewOrder();
        libraryManager.editOrderById(index, order, path);
    }

    private static void addOrder(LibraryManager libraryManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên file nguồn: ");
        String path = scanner.nextLine();
        IdCard order = creatNewOrder();
        libraryManager.addNewOrder(order, path);
    }

    private static IdCard creatNewOrder() {
        int id = inputId();
        Date startTime = inputStartTime();
        Date endTime = inputEndTime();
        String bookName = inputBookName();
        Student student = creatNewStudent();
        IdCard order = new IdCard(id, startTime, endTime, bookName, student);
        return order;
    }

    private static int inputId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số phiếu mượn: ");
        int id = scanner.nextInt();
        return id;
    }

    public static Date inputStartTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ngày, tháng, năm mượn sách:");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        Date startTime = calendar.getTime();
        return startTime;
    }

    public static Date inputEndTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ngày, tháng, năm trả sách:");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        Date endTime = calendar.getTime();
        return endTime;
    }

    public static Date inputCheckTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ngày, tháng, năm mốc kiểm tra:");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        Date endTime = calendar.getTime();
        return endTime;
    }

    private static String inputBookName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào tên sách mượn: ");
        String bookName = scanner.nextLine();
        //kiểm tra
        return bookName;
    }

    private static Student creatNewStudent() {
        Scanner input1 = new Scanner(System.in);
        System.out.println("Nhập vào tên của sinh viên: ");
        String name = input1.nextLine();
        Scanner input2 = new Scanner(System.in);
        System.out.println("Nhập vào mã sinh viên: ");
        int id = input2.nextInt();
        Scanner input3 = new Scanner(System.in);
        System.out.println("Nhập ngày tháng năm sinh của sinh viên: ");
        String dateOfBirth = input3.nextLine();
        Scanner input4 = new Scanner(System.in);
        System.out.println("Nhập lớp của sinh viên: ");
        String className = input4.nextLine();
        Student student = new Student(name, id, dateOfBirth, className);
        return student;
    }
}
