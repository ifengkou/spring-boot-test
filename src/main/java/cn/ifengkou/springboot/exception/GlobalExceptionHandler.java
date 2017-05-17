package cn.ifengkou.springboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: 统一异常处理
 *
 * @author shenlongguang<https://github.com/ifengkou>
 * @date: 2017/5/17 下午5:21.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> errorHandler(HttpServletRequest req, MyException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorStatusCode.ERROR);
        r.setData("Some Data");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseBody
    public ErrorInfo<String> unauthorizedErrorHandler(HttpServletRequest req, UnauthorizedException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorStatusCode.UNAUTHORIZED);
        r.setData("");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }
}
