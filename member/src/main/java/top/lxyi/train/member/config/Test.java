package top.lxyi.train.member.config;

public enum Test {
    COMPUTING("1","计算机"),
    LITERATURE("2","文学"),
    HISTORY("1","历史");

    private String code;
    private String desc;


    Test(String code,String desc) {
            this.code =code;
            this.desc =desc;
    }

    public  String  getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public  String  getDesc() {
        return desc;
    }
}
