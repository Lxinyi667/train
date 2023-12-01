package top.lxyi.train.business.req;


import top.lxyi.train.common.req.PageReq;

public class StudentQueryReq extends PageReq {
    String name;
    String school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "StudentQueryReq{" +
        "} " + super.toString();
    }
}