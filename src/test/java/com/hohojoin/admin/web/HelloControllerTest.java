package com.hohojoin.admin.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;    //java.lang.invoke 추가(AutoImport)
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/*
* 테스트를 진행할 떄 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킨다.
* 여기서는 SpringRunner라는 스프링 실행자를 사용한다.
* 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 한다.
* */
@RunWith(SpringRunner.class)
/*
* 여러 스프링 테스트 어노테이션 중 Web에 집중할 수 있는 어노테이션
* 선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있다.(@Service, @Component, @Repository는 사용 불가)
* */
@WebMvcTest
public class HelloControllerTest {
    /*
    * 스프링이 관리하는 빈(Bean)을 주입받는다.
    * */
    @Autowired
    /*
    * 웹 API를 테스트할 때 사용한다.
    * 스프링 MVC 테스트의 시작점
    * 이 클래스를 통해 HTTP GET,POST 등에 대한 API 테스트를 할 수 있다.
    * */
    private MockMvc mvc;

    @Test
    public void Hello가_리턴된다() throws Exception{
        String hello = "hello";
        /*
        * MockMvc를 통해 /hello 주소로 HTTP GET 요정을 한다.
        * 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언할 수 있다.
        * */
        mvc.perform(get("/hello"))
                /*
                * mvc.perform의 결과를 검증한다.
                * HTTP Header의 Status를 검증한다.
                * isOk : 200, isNotFound() : 404, isMethodNotAllowed() : 405, isInternalServerError() : 500
                * */
                .andExpect(status().isOk())
                /*
                * 응답에 대한 정보를 검증
                * */
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                                        .andExpect(status().isOk())
                                        .andExpect(jsonPath("$.name", is(name)))
                                        .andExpect(jsonPath("$.amount", is(amount)));
    }
}
