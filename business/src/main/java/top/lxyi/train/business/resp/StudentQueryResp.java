package top.lxyi.train.business.resp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class StudentQueryResp {

    /**
    * 
    */
        @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    /**
    * 
    */
    private String name;

    /**
    * 
    */
    private String phonenumber;

    /**
    * 
    */
    private Integer age;

    /**
    * 
    */
    private String email;

    /**
    * 
    */
    private String school;


    public Long getId() {
    return id;
    }

    public void setId(Long id) {
    this.id = id;
    }

    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }

    public String getPhonenumber() {
    return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
    }

    public Integer getAge() {
    return age;
    }

    public void setAge(Integer age) {
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

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(getClass().getSimpleName());
sb.append(" [");
sb.append("Hash = ").append(hashCode());
    sb.append(", id=").append(id);
    sb.append(", name=").append(name);
    sb.append(", phonenumber=").append(phonenumber);
    sb.append(", age=").append(age);
    sb.append(", email=").append(email);
    sb.append(", school=").append(school);
sb.append("]");
return sb.toString();
}
}