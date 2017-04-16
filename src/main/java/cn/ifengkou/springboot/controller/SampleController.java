package cn.ifengkou.springboot.controller;

import cn.ifengkou.springboot.util.HttpRequest;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 描述
 *
 * @author shenlongguang<https://github.com/ifengkou>
 * @date 2017/4/11 17:43
 */
@Controller
@EnableAutoConfiguration
public class SampleController {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }

    @RequestMapping("/test")
    @ResponseBody
    JSONPObject home(@RequestParam("callback") String callback) {
        return new JSONPObject(callback, "hello world! hi, yufei !");
    }

    @RequestMapping("/api")
    @ResponseBody
    JSONPObject transApi(HttpServletRequest request, @RequestParam("callback") String callback, String url, String params) {
        Cookie[] cookies = request.getCookies();
        String cookies_str = "";
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                String ckname = cookie.getName();
                String ckvalue = cookie.getValue();
                cookies_str += ";" + ckname + "=" + ckvalue;
            }
        }

        params = null != params ? params.replaceAll(",", "&"):"";
        cookies_str = cookies_str.length() > 1 ? cookies_str.substring(1) : cookies_str;
        System.out.println("发起请求，url=" + url + "; params=" + params + "; cookie=" + cookies_str);
        String returnStr = HttpRequest.sendGet(url, params, cookies_str);

        return new JSONPObject(callback, returnStr);
    }
}
