package top.lxyi.train.business.config;

import com.github.javafaker.Faker;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.lxyi.train.business.domain.Student;
import top.lxyi.train.business.mapper.StudentMapper;
import top.lxyi.train.common.util.SnowUtil;

import java.util.Locale;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentServiceTest {
    @Resource
    private StudentMapper studentMapper;

    @Test
    void save(){
//        Faker faker1=new Faker();
//        for(int i=0;i<100000;i++){
//            Faker faker =new Faker(new Locale("zh-CN"));
//
//            Student student=new Student();
//            student.setId(SnowUtil.getSnowflakeNextId());
//            student.setAge(new Random().nextInt(30)+1);
//            student.setName(faker.name().fullName());
//            student.setPhonenumber(faker.phoneNumber().cellPhone());
//            student.setEmail(faker.internet().emailAddress());
//            student.setSchool(faker.university().name());
//            studentMapper.insert(student);
//    }
}
}