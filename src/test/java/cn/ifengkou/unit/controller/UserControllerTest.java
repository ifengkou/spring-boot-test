package cn.ifengkou.unit.controller;

import cn.ifengkou.springboot.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;
/**
 * Description:
 *
 * @author shenlongguang
 * @date: 2017/5/16 下午2:04.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MockServletContext.class)
public class UserControllerTest {
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserController() throws Exception {
        // 测试UserController
        RequestBuilder request = null;

        // 1、get查一下user列表，应该为空
        request = get("/users/");
        mvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo("[]")));

        // 2、post提交一个user
        request = post("/users/")
            .param("id", "1")
            .param("name", "测试大师")
            .param("age", "20");
        mvc.perform(request)
            .andExpect(content().string(equalTo("success")));

        // 3、get获取user列表，应该有刚才插入的数据
        request = get("/users/");
        mvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));

        // 4、put修改id为1的user
        request = put("/users/1")
            .param("name", "测试终极大师")
            .param("age", "30");
        mvc.perform(request)
            .andExpect(content().string(equalTo("success")));

        // 5、get一个id为1的user
        request = get("/users/1");
        mvc.perform(request)
            .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));

        // 6、del删除id为1的user
        request = delete("/users/1");
        mvc.perform(request)
            .andExpect(content().string(equalTo("success")));

        // 7、get查一下user列表，应该为空
        request = get("/users/");
        mvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo("[]")));

    }
}
