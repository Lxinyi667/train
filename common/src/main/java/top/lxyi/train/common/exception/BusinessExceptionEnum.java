package top.lxyi.train.common.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum BusinessExceptionEnum {
    MEMBER_MOBILE_EXIST("手机号已被注册");

    private String desc;

    BusinessExceptionEnum(String desc){
        this.desc = desc;

    }
    public void setDesc(String desc){
        this.desc = desc;
    }
}
