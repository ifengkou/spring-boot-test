package cn.ifengkou.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author shenlongguang
 * @date: 2017/5/16 下午2:16.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index(){
        return "Hello World";
    }
}
