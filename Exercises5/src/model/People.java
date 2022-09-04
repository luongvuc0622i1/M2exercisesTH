package model;

import java.io.Serializable;

public class People implements Serializable {
    private String name;
    private String dateOfBirth;
    private String job;

    public People() {
    }

    public People(String name, String dateOfBirth, String job) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "people{" +
                "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
