package controller;

import model.Bill;
import storage.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class ElectricManager {
    private String name;
    private static ReadWriteFile readWriteData = ReadWriteFile.getInstance();
    public static List<Bill> billList = new ArrayList<>();

    public void display(String path) {
        billList = readWriteData.readData(path);
        if(billList.isEmpty()){
            System.out.println("Chưa có dữ kiện về hoá đơn nào!");
        }else {
            for ( Bill bill : billList ) {
                System.out.println(bill);
            }
        }
    }

    public int calulateMoneyBill(int idElectricMeter, String path) {
        billList = readWriteData.readData(path);
        int moneyBill = 1;
        for (int i = 0 ; i < billList.size() ; i++) {
            if (billList.get(i).getCustomer().getIdElectricMeter() == idElectricMeter) {
                moneyBill = (billList.get(i).getNewIndex() - billList.get(i).getOldIndex())*750;
            }
        }
        return moneyBill;
    }

    public void addNewBill(Bill bill, String path) {
        billList = readWriteData.readData(path);
        billList.add(bill);
        readWriteData.writeData(billList, path);
    }

    public void editBillById(int index, Bill bill, String path) {
        billList = readWriteData.readData(path);
        billList.set(index, bill);
        readWriteData.writeData(billList, path);
    }

    public void removeBillById(int index, String path) {
        billList = readWriteData.readData(path);
        billList.remove(index);
        readWriteData.writeData(billList, path);
    }

    public ElectricManager() {
    }

    public ElectricManager(String name) {
        this.name = name;
    }

    public ElectricManager(String name, List<Bill> list) {
        this.name = name;
        this.billList = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bill> getList() {
        return billList;
    }

    public void setList(List<Bill> list) {
        this.billList = list;
    }
}
