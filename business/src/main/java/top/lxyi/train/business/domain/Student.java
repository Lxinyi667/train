package top.lxyi.train.business.domain;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Student {
    private long id;
    private String phoneNumber;
    private String name;
    private int age;
    private String email;
    private String school;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }



    // Constructors, getters, setters, and toString methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && Objects.equals(phoneNumber, student.phoneNumber)
                && Objects.equals(name, student.name) && Objects.equals(email, student.email)
                && Objects.equals(school, student.school);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phoneNumber, name, age, email, school);
    }
//    public Student(long id, String name, int age, String phoneNumber, String email, String school) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.phoneNumber = phoneNumber;
//        this.email = email;
//        this.school = school;
//    }
// 数据生成类
}
