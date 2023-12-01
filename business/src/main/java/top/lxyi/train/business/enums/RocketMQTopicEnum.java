package top.lxyi.train.business.enums;

public enum RocketMQTopicEnum {
    // 如果用我的消息队列，可以修改下这个枚举值，打上自己的logo，方便在MQ查找消息！
    CONFIRM_ORDER("CONFIRM_ORDER", "确认订单排队");

    private String code;

    private String desc;

    RocketMQTopicEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "RocketMQTopicEnum{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                "} " + super.toString();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
