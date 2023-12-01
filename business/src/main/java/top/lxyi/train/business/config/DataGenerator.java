package top.lxyi.train.business.config;

import com.github.javafaker.Faker;
import top.lxyi.train.business.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DataGenerator {
    private Faker faker;

    public DataGenerator() {
        this.faker = new Faker(Locale.CHINA);
    }

    public List<Student> generateStudents(int count) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Student student = new Student();
            student.setId(i + 1);
            student.setName(faker.name().fullName());
            student.setAge(faker.number().numberBetween(18, 25));
            student.setPhoneNumber(faker.phoneNumber().cellPhone());
            student.setEmail(faker.internet().emailAddress());
            student.setSchool(faker.university().name());
            students.add(student);
        }
        return students;
    }
}