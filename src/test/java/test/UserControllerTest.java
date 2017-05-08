package test;

import com.mdachu.controller.BaseController;
import com.mdachu.controller.UserController;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by mm on 2017/5/6.
 */
public class UserControllerTest extends BaseControllerTest{

    @Autowired
    private WebApplicationContext wc;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();
    }

    @Test
    public void listUsers() throws Exception {
    }

    @Test
    public void listAllUser() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/listAllUser"))
                .andExpect(MockMvcResultMatchers.view().name("users"))
                .andExpect(model().attributeExists("userName"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        Assert.assertNotNull(result.getModelAndView().getViewName());
    }

    @Test
    public void fileUploadTest() throws Exception {
        //文件上传
        byte[] bytes = new byte[] {1, 2};
        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/user/{id}/icon", 1L).file("icon", bytes)) //执行文件上传
                .andExpect(model().attribute("icon", bytes)) //验证属性相等性
                .andExpect(MockMvcResultMatchers.view().name("success")); //验证视图

    }

    @Test
    public void normalTest()throws Exception{
        //测试普通控制器
        mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", 1)) //执行请求
                .andExpect(model().attributeExists("user")) //验证存储模型数据
                .andExpect(MockMvcResultMatchers.view().name("user/view")) //验证viewName
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/jsp/user/view.jsp"))//验证视图渲染时forward到的jsp
                .andExpect(status().isOk())//验证状态码
                .andDo(MockMvcResultHandlers.print()); //输出MvcResult到控制台
    }

    @Test
    public void flashActinTest()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/user").param("name", "zhang")) //执行传递参数的POST请求(也可以post("/user?name=zhang"))
                .andExpect(MockMvcResultMatchers.handler().handlerType(UserController.class)) //验证执行的控制器类型
                .andExpect(MockMvcResultMatchers.handler().methodName("create")) //验证执行的控制器方法名
                .andExpect(MockMvcResultMatchers.model().hasNoErrors()) //验证页面没有错误
                .andExpect(MockMvcResultMatchers.flash().attributeExists("success")) //验证存在flash属性
                .andExpect(MockMvcResultMatchers.view().name("redirect:/user")); //验证视图
    }

    @Test
    public void jsonTest()throws Exception{
        String requestBody = "{\"id\":1, \"name\":\"zhang\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON).content(requestBody)
                .accept(MediaType.APPLICATION_JSON)) //执行请求
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)) //验证响应contentType
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/

        String errorBody = "{id:1, name:zhang}";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON).content(errorBody)
                .accept(MediaType.APPLICATION_JSON)) //执行请求
                .andExpect(status().isBadRequest()) //400错误请求
                .andReturn();

        Assert.assertTrue(HttpMessageNotReadableException.class.isAssignableFrom(result.getResolvedException().getClass()));//错误的请求内容体

    }

    @Test
    public void xmlTest()throws Exception{
        //XML请求/响应
        String requestBody = "<user><id>1</id><name>zhang</name></user>";
        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_XML).content(requestBody)
                .accept(MediaType.APPLICATION_XML)) //执行请求
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_XML)) //验证响应contentType
                .andExpect(MockMvcResultMatchers.xpath("/user/id/text()").string("1")); //使用XPath表达式验证XML 请参考http://www.w3school.com.cn/xpath/

        String errorBody = "<user><id>1</id><name>zhang</name>";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_XML).content(errorBody)
                .accept(MediaType.APPLICATION_XML)) //执行请求
                .andExpect(status().isBadRequest()) //400错误请求
                .andReturn();

        Assert.assertTrue(HttpMessageNotReadableException.class.isAssignableFrom(result.getResolvedException().getClass()));//错误的请求内容体
    }

    @Test
    public void staticJsTest()throws Exception{
        //静态资源
        mockMvc.perform(MockMvcRequestBuilders.get("/static/app.js")) //执行请求
                .andExpect(status().isOk()) //验证状态码200
                .andExpect(MockMvcResultMatchers.content().string(CoreMatchers.containsString("var")));//验证渲染后的视图内容包含var

        mockMvc.perform(MockMvcRequestBuilders.get("/static/app1.js")) //执行请求
                .andExpect(status().isNotFound());  //验证状态码404
    }

}