package cn.ifengkou.springboot.exception;

/**
 * Description: 自定义异常
 *
 * @author shenlongguang<https://github.com/ifengkou>
 * @date: 2017/5/17 下午5:20.
 */
public class UnauthorizedException extends Exception {
    public UnauthorizedException(String message) {
        super(message);
    }
}
