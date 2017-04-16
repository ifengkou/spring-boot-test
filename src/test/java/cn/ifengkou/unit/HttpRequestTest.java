package cn.ifengkou.unit;

import cn.ifengkou.springboot.util.HttpRequest;
import org.junit.Test;

/**
 * 描述
 *
 * @author shenlongguang<https://github.com/ifengkou>
 * @date 2017/4/15 23:30
 */

public class HttpRequestTest {

    @Test
    public void testHttpRequest() {
        String url = "http://106.75.23.50:10022/pv";
        String params = "date_time=201701&cate_id=1011002";
        String cookie = "";

        String result = HttpRequest.sendGet(url, params, cookie);
        System.out.println(result);
    }
}
