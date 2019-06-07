package com.gmail.etauroginskaya.finalcontrolwork;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.gmail.etauroginskaya.finalcontrolwork.constants.UrlConstants.API_DENIED_URL;
import static com.gmail.etauroginskaya.finalcontrolwork.constants.UrlConstants.API_DISCOUNTS_URL;
import static com.gmail.etauroginskaya.finalcontrolwork.constants.UrlConstants.API_DISCOUNT_ADD_URL;
import static com.gmail.etauroginskaya.finalcontrolwork.constants.UrlConstants.API_DISCOUNT_URL;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DiscountAPIControllerIntegrationTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void shouldGetSucceedWith401ForDiscountsAPI() throws Exception {
        mvc.perform(get(API_DISCOUNTS_URL))
                .andExpect(status().isUnauthorized());
    }

    @WithMockUser
    @Test
    public void shouldGetSucceedWith302ForDiscountsAPI() throws Exception {
        mvc.perform(get(API_DISCOUNTS_URL))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(API_DENIED_URL));
    }

    @WithMockUser(authorities = "CUSTOMER_USER")
    @Test
    public void shouldGetSucceedWith200ForDiscountsAPI() throws Exception {
        mvc.perform(get(API_DISCOUNTS_URL))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldSucceedWith401ForDiscountAddAPI() throws Exception {
        mvc.perform(post(API_DISCOUNT_ADD_URL))
                .andExpect(status().isUnauthorized());
    }

    @WithMockUser
    @Test
    public void shouldSucceedWith302ForDiscountAddAPI() throws Exception {
        mvc.perform(post(API_DISCOUNT_ADD_URL))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(API_DENIED_URL));
    }

    @WithMockUser(authorities = "SUPER_USER")
    @Test
    public void shouldSucceedWith201ForDiscountAddAPI() throws Exception {
        mvc.perform(post(API_DISCOUNT_ADD_URL)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"userID\": \"1\", " +
                        "\"title\": \"test\", " +
                        "\"percent\": \"10\", " +
                        "\"expirationDate\": \"2021-06-07T21:55:46.850\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldSucceedWith401ForDiscountDeleteAPI() throws Exception {
        mvc.perform(delete(API_DISCOUNT_URL, 1))
                .andExpect(status().isUnauthorized());
    }

    @WithMockUser
    @Test
    public void shouldSucceedWith302ForDiscountDeleteAPI() throws Exception {
        mvc.perform(delete(API_DISCOUNT_URL, 1))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(API_DENIED_URL));
    }

    @WithMockUser(authorities = "SUPER_USER")
    @Test
    public void shouldSucceedWith200ForDiscountDeleteAPI() throws Exception {
        mvc.perform(delete(API_DISCOUNT_URL, 1))
                .andExpect(status().isOk());
    }

    @WithMockUser(authorities = "SUPER_USER")
    @Test
    public void shouldSucceedWith404ForDiscountDeleteAPI() throws Exception {
        mvc.perform(delete(API_DISCOUNT_URL, 100))
                .andExpect(status().isNotFound());
    }
}