package views;

import controller.ElectricManager;
import model.Bill;

import java.util.List;
import java.util.Scanner;

public class Client {
    private static List<Bill> billList = ElectricManager.billList;

    public static void main(String[] args) {
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

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            default:
                System.out.println("Nhập sai lựa chọn!");
        }
    }
}
