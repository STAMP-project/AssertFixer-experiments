package com.mum.news.ea.blog;

import com.mum.news.ea.blog.controllers.UserController;
import com.mum.news.ea.blog.models.User;
import com.mum.news.ea.blog.services.user.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.math.BigDecimal;
import java.util.Collection;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

/**
 * User: franc
 * Date: 22/09/2018
 * Time: 11:10
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = { UserController.class } , secure = false)
//@AutoConfigureMockMvc
public class LoginTest {
    private MockMvc mockMvc;


    @MockBean
    private FilterChainProxy springSecurityFilterChain;


    @MockBean
    private UserService userService;

    public LoginTest() {
    }

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void testInitial() throws Exception {
        assertThat(this.userService).isNotNull();
        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("user/login"))
                .andExpect(MockMvcResultMatchers.view().name("user/login"))
                //.andExpect(content().string(Matchers.containsString("email")))
                .andDo(print());
    }

    @Test
    public void testFormError() throws Exception {

        RequestBuilder requestBuilder = formLogin().user("edwin@gmail.com").password("xjuanjuan");
        MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilter(springSecurityFilterChain)
                .build()
                .perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(cookie().doesNotExist("JSESSIONID"));


//        MvcResult result= mockMvc.perform(get("/product/{id}/", 1))
//                .andExpect(status().isOk())
//                .andExpect(view().name("productshow"))
//                .andExpect(MockMvcResultMatchers.model().attributeExists("product"))
//                .andExpect(model().attribute("product", hasProperty("id", is(1))))
//                .andExpect(model().attribute("product", hasProperty("productId", is("235268845711068308"))))
//                .andExpect(model().attribute("product", hasProperty("description", is("Spring Framework Guru Shirt"))))
//                .andExpect(model().attribute("product", hasProperty("price", is(new BigDecimal("18.95")))))
//                .andExpect(model().attribute("product", hasProperty("imageUrl", is("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg"))))
//                .andReturn();
//        assertThat(this.userService).isNotNull();
        //https://javatalks.ru/topics/44989


//        mockMvc.perform(post("/login").param("email", "edwin@gmail.com").param("password", "test description"))
//                .andExpect(status().isOk())
        //                .andExpect(view().name("user/login"))
//                .andExpect(MockMvcResultMatchers.view().name("user/login"))
                //.andExpect(content().string(Matchers.containsString("email")))
//                .andDo(print());



    }
}
