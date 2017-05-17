package cn.ifengkou.springboot.exception;

/**
 * Description:
 *
 * @author shenlongguang<https://github.com/ifengkou>
 * @date: 2017/5/17 下午5:19.
 */
public enum ErrorStatusCode {
    ERROR(100, "失败"),
    UNAUTHORIZED(101, "无授权");
    private int code;// 异常代码
    private String desc;// 异常描述

    ErrorStatusCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
