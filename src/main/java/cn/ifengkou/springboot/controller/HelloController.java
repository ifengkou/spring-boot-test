package cn.ifengkou.springboot.controller;

import cn.ifengkou.springboot.exception.ErrorStatusCode;
import cn.ifengkou.springboot.exception.MyException;
import cn.ifengkou.springboot.exception.UnauthorizedException;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Description:
 *
 * @author shenlongguang<https://github.com/ifengkou>
 * @date: 2017/5/16 下午2:16.
 */
@RestController
public class HelloController {
    @ApiOperation(value="测试接口", notes="直接反馈Hello World")
    @RequestMapping(value = "/hello", method= RequestMethod.GET)
    public String index(){
        return "Hello World";
    }

    @ApiIgnore
    @RequestMapping(value = "/world", method= RequestMethod.GET)
    public String ignoreAPI(){
        return "Hello World";
    }

    @ApiOperation(value="测试接口", notes="直接反馈Hello World")
    @RequestMapping(value = "/exception", method= RequestMethod.GET)
    public String exception(int code) throws Exception{
        if(code == ErrorStatusCode.ERROR.getCode()){
            throw new MyException("普通异常");
        }else if (code == ErrorStatusCode.UNAUTHORIZED.getCode())
        {
            throw new UnauthorizedException("当前操作无权限");
        }
        return "100:普通异常；101:无授权";
    }
}
