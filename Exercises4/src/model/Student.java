package model;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int id;
    private String dateOfBirth;
    private String className;

    public Student() {
    }

    public Student(String name, int id, String dateOfBirth, String className) {
        this.name = name;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
