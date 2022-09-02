package model;

import javax.smartcardio.Card;
import java.io.Serializable;
import java.time.LocalDate;

public class IdCard implements Serializable {
    private int id;
    private LocalDate startTime;
    private LocalDate endTime;
    private String bookName;
    private Student student;

    public IdCard() {
    }

    public IdCard(int id, LocalDate startTime, LocalDate endTime, String bookName, Student student) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookName = bookName;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "IdCard{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", bookName='" + bookName + '\'' +
                ", " + student +
                '}';
    }
}
