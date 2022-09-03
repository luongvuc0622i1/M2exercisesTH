package model;

import java.io.Serializable;
import java.util.Date;

public class IdCard implements Serializable {
    private int id;
    private Date startTime;
    private Date endTime;
    private String bookName;
    private Student student;

    public IdCard() {
    }

    public IdCard(int id, Date startTime, Date endTime, String bookName, Student student) {
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
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
