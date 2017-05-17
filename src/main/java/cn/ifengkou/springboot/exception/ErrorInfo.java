package cn.ifengkou.springboot.exception;

/**
 * Description:
 *
 * @author shenlongguang<https://github.com/ifengkou>
 * @date: 2017/5/17 下午5:13.
 */
public class ErrorInfo<T> {
    private ErrorStatusCode code;// 异常代码
    private String message;// 异常描述
    private String url;
    private T data;

    public ErrorStatusCode getCode() {
        return code;
    }

    public void setCode(ErrorStatusCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
