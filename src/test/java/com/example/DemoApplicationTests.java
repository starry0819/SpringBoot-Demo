package com.example;

import com.alibaba.fastjson.JSON;
import com.example.controller.DemoController;
import com.example.response.ResultData;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class DemoApplicationTests {

	private MockMvc mvc;

	@Before
	public void init() {
		mvc = MockMvcBuilders.standaloneSetup(new DemoController()).build();
	}

	@Test
	public void testDemoController() throws Exception {
		RequestBuilder request;
		request = MockMvcRequestBuilders.get("/api/demo");
        ResultData resultData = getResultData(request);
        System.out.println(resultData);
    }


    @Test
    public void testDemoController2() throws Exception {
        RequestBuilder request;
        request = MockMvcRequestBuilders.get("/api/demoWithName").param("name", "Tom");
        ResultData resultData = getResultData(request);
        System.out.println(resultData);
    }

    /**
     * 获取请求的响应数据
     * @param request 请求
     * @return 响应结果数据
     * @throws Exception 异常
     */
    private ResultData getResultData(RequestBuilder request) throws Exception {
        MvcResult mvcResult = mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        return JSON.parseObject(contentAsString, ResultData.class);
    }
}
