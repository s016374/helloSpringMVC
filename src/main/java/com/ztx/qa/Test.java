package com.ztx.qa;


import com.ztx.qa.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by s016374 on 15/8/10.
 */
@Controller
@RequestMapping("mvc")
public class Test {
    private static final String SUCCESS = "success";

    @RequestMapping("helloWorld")
    public String testHelloWorld() {
        System.out.println("helloWorld:success");
        return SUCCESS;
    }

    @RequestMapping(value = "postMethod", method = RequestMethod.POST)
    public String testPostMethod() {
        System.out.println("postMethed:success");
        return SUCCESS;
    }

    @RequestMapping(value = "paramsAndHeaders", params = {"user=abc", "password!=123"}, headers = {"Accept-Encoding=gzip, deflate, sdch"})
    public String testParamsAndHeader() {
        System.out.println("paramsAndHeaders:success");
        return SUCCESS;
    }

    @RequestMapping("pathVariable/{id}")
    public String testPathVariable(@PathVariable(value = "id") String id) {
        System.out.println("pathVariable:success, id= " + id);
        return SUCCESS;
    }

    @RequestMapping(value = "restGet/{para}", method = RequestMethod.GET)
    public String testRestGet(@PathVariable("para") Integer para) {
        System.out.println("REST-get:success, para= " + para);
        return SUCCESS;
    }

    @RequestMapping(value = "restPost", method = RequestMethod.POST)
    public String testRestPost() {
        System.out.println("REST-post:success");
        return SUCCESS;
    }

    @RequestMapping(value = "restDelete/{para}", method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable("para") Integer para) {
        System.out.println("REST-delete:success, para= " + para);
        return SUCCESS;
    }

    @RequestMapping(value = "restPut/{para}", method = RequestMethod.PUT)
    public String testRestPut(@PathVariable("para") Integer para) {
        System.out.println("REST-put:success, para= " + para);
        return SUCCESS;
    }

    @RequestMapping(value = "requestParam")
    public String testRequestParam(@RequestParam(value = "user", defaultValue = "ztx") String user, @RequestParam(value = "password", required = false) Integer password) {
        System.out.println("requestParam:success");
        System.out.println("user: " + user + "; password: " + password);
        return SUCCESS;
    }

    @RequestMapping(value = "requestHeader")
    public String testRequestHeader(@RequestHeader(value = "Cookie") String header) {
        System.out.println("requestHeader:success, Cookie: " + header);
        return SUCCESS;
    }

    @RequestMapping(value = "requestCookieValue")
    public String testRequestCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println("requestCookieValue:success, cookieValue: " + cookieValue);
        return SUCCESS;
    }

    @RequestMapping(value = "POJO")
    public String testPOJO(User user) {
        System.out.println("POJO:success");
        System.out.println("user: " + user);
        return SUCCESS;
    }

    @RequestMapping(value = "servletAPI")
    public String testServletAPI(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        System.out.println("servletAPI:success");
        System.out.println("httpServletRequest: " +httpServletRequest);
        System.out.println("httpServletResponse" + httpServletResponse);
        return SUCCESS;
    }
}
