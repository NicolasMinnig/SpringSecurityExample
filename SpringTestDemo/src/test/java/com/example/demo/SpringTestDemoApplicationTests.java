package com.example.demo;


import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;


import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.controller.HomeController;
import com.example.demo.controller.LoginController;
import com.example.demo.models.User;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringTestDemoApplication.class, webEnvironment=WebEnvironment.RANDOM_PORT)//use random port to test
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
@AutoConfigureMockMvc
public class SpringTestDemoApplicationTests {

	

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private HomeController homeController;
    
    @Autowired
    private LoginController loginController;
    
	
	@Test
	public void homeTest() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Get your greeting")));
		
		
	}
	
    @Test
    public void testHomeController() {
        String result = homeController.home();
        Assert.assertEquals(result,"index");
    }
    
    @Test
    public void testLoginController() {
        ModelAndView result = loginController.login();
        Assert.assertEquals(result.getViewName(),"login");
    }
    
    @Test
    public void testAdd() {
        Assert.assertEquals(4,loginController.add(2, 2));
    }

}
