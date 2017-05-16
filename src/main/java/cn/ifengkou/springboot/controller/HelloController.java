package cn.ifengkou.springboot.controller;

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
    @RequestMapping(value = "/hello")
    public String index(){
        return "Hello World";
    }

    @ApiIgnore
    @RequestMapping(value = "/world", method= RequestMethod.GET)
    public String ignoreAPI(){
        return "Hello World";
    }
}
