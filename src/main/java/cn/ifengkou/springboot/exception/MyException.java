package cn.ifengkou.springboot.exception;

/**
 * Description: 自定义异常
 *
 * @author shenlongguang<https://github.com/ifengkou>
 * @date: 2017/5/17 下午5:20.
 */
public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
