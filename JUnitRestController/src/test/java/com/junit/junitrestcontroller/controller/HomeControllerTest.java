package com.junit.junitrestcontroller.controller;

import com.junit.junitrestcontroller.service.HomeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(value = HomeController.class)
class HomeControllerTest {

    MockMvc mockMvc;

    @MockBean
    HomeService homeService;

    @Autowired
    public void setMockMvc(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void postIndexWorks() throws Exception {
        String body = "FReni";
        String path = "/";
        Mockito.when(homeService.nameCheck(Mockito.any(String.class))).thenReturn(body);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                                            .post(path)
                                            .accept(MediaType.TEXT_PLAIN)
                                            .content(body)
                                            .contentType(MediaType.TEXT_PLAIN);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String output = mockHttpServletResponse.getContentAsString();

        assertThat(output).isEqualTo("FReni");
        assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
    }
}