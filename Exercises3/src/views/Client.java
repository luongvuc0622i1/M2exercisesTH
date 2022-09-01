package views;

import controller.ElectricManager;
import model.Bill;
import model.Customer;

import java.util.List;
import java.util.Scanner;

public class Client {
    private static List<Bill> billList = ElectricManager.billList;

    public static void main(String[] args) {
        ElectricManager manager = new ElectricManager("Quản lý");
        System.out.println("1. Thêm hoá đơn cho 1 hộ");
        System.out.println("2. Sửa hoá đơn");
        System.out.println("3. Xoá hoá đơn");
        System.out.println("4. Hiển thị danh sách hoá đơn");
        System.out.println("5. Tính số tiền hoá đơn của 1 hộ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập lựa chọn vào đây: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addBill(manager);
                break;
            case 2:
                editBill(manager);
                break;
            case 3:
                removeBill(manager);
                break;
            case 4:
                displayBill(manager);
                break;
            case 5:
                caculatorMoneyBill(manager);
                break;
            default:
                System.out.println("Nhập sai lựa chọn!");
        }
    }

    private static void caculatorMoneyBill(ElectricManager manager) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Nhập tên file nguồn: ");
        String path = scanner1.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Nhập vào số máx công tơ cần tính tiền: ");
        int idElectricMeter = scanner2.nextInt();
        int money = manager.calulateMoneyBill(idElectricMeter, path);
        System.out.println("Số tiền vị khách này cần thanh toán là: " + money);
    }

    private static void displayBill(ElectricManager manager) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên file nguồn: ");
        String path = scanner.nextLine();
        manager.display(path);
    }

    private static void removeBill(ElectricManager manager) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Nhập tên file nguồn: ");
        String path = scanner1.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Nhập vào vị trí muốn xoá: ");
        int index = scanner2.nextInt();
        manager.removeBillById(index, path);
    }

    private static void editBill(ElectricManager manager) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Nhập tên file nguồn: ");
        String path = scanner1.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Nhập vào vị trí muốn sửa: ");
        int index = scanner2.nextInt();
        Bill bill = createBill();
        manager.editBillById(index, bill, path);
    }

    private static void addBill(ElectricManager manager) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên file nguồn: ");
        String path = scanner.nextLine();
        Bill bill = createBill();
        manager.addNewBill(bill, path);
    }

    private static Bill createBill() {
        Bill bill;
        Customer customer = createNewCustomer();
        Scanner input1 = new Scanner(System.in);
        System.out.print("Nhập vào chỉ số cũ: ");
        int oldIndex = input1.nextInt();
        Scanner input2 = new Scanner(System.in);
        System.out.print("Nhập vào chỉ số mới: ");
        int newIndex = input2.nextInt();
        bill = new Bill(customer, oldIndex, newIndex);
        return bill;
    }

    private static Customer createNewCustomer() {
        Customer customer;
        Scanner input1 = new Scanner(System.in);
        System.out.print("Nhập vào tên của chủ hộ: ");
        String ownerName = input1.nextLine();
        Scanner input2 = new Scanner(System.in);
        System.out.print("Nhập vào địa chỉ: ");
        String address = input2.nextLine();
        Scanner input3 = new Scanner(System.in);
        System.out.print("Nhập vào mã số công tơ: ");
        int idElectricMeter = input3.nextInt();
        customer = new Customer(ownerName, address, idElectricMeter);
        return customer;
    }
}
