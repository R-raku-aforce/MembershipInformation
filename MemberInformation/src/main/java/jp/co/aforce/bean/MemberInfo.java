package jp.co.aforce.bean;

public class MemberInfo implements java.io.Serializable {
    private int MEMBER_ID;
    private String FIRST_NAME;
    private String LAST_NAME;
    private String SEX;
    private int Post_num;
    private String Address;
    private String JOB;
    private long PHONE_NUMBER;
    private String MAIL_ADDRESS;

    // 添加构造函数、getter和setter方法

    public MemberInfo(int MEMBER_ID,  String FIRST_NAME, String LAST_NAME, String SEX, int Post_num, String Address, String JOB, long PHONE_NUMBER, String MAIL_ADDRESS) { // 修改构造函数参数类型
        this.MEMBER_ID = MEMBER_ID;
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.SEX = SEX;
        this.Post_num = Post_num;
        this.Address = Address;
        this.JOB = JOB;
        this.PHONE_NUMBER = PHONE_NUMBER; // 修改属性赋值
        this.MAIL_ADDRESS = MAIL_ADDRESS;
    }
    public int getMEMBER_ID() {
        return MEMBER_ID;
    }

    public void setMEMBER_ID(int MEMBER_ID) {
        this.MEMBER_ID = MEMBER_ID;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public int getPost_num() {
        return Post_num;
    }

    public void setPost_num(int post_num) {
        this.Post_num = post_num;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getJOB() {
        return JOB;
    }

    public void setJOB(String JOB) {
        this.JOB = JOB;
    }

    public long getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

    public void setPHONE_NUMBER(long PHONE_NUMBER) {
        this.PHONE_NUMBER = PHONE_NUMBER;
    }

    public String getMAIL_ADDRESS() {
        return MAIL_ADDRESS;
    }

    public void setMAIL_ADDRESS(String MAIL_ADDRESS) {
        this.MAIL_ADDRESS = MAIL_ADDRESS;
    }
}

