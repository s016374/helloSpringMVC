package com.ztx.qa;


import com.ztx.qa.dao.DepartmentDao;
import com.ztx.qa.dao.EmployeeDao;
import com.ztx.qa.entities.Address;
import com.ztx.qa.entities.Employee;
import com.ztx.qa.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by s016374 on 15/8/10.
 */
@Controller
@RequestMapping("mvc")
@SessionAttributes(value = "user")
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
        System.out.println("httpServletRequest: " + httpServletRequest);
        System.out.println("httpServletResponse" + httpServletResponse);
        return SUCCESS;
    }

    @RequestMapping(value = "modelAndView")
    public ModelAndView testModelAndView() {
        String viewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject("time", new Date());
        System.out.println(modelAndView);
        return modelAndView;
    }

    @RequestMapping(value = "modelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("name", "Tom, Mike, Mary, Jane");
        System.out.println("modelMap:success");
        System.out.println(modelMap.getClass().getName());
        return SUCCESS;
    }

    @RequestMapping(value = "sessionAttributes")
    public String testSessionAttributes(ModelMap modelMap) {
        modelMap.addAttribute("user", new User(1, "Jack", "123", 30, "jack@mail.com", new Address("ShanDong", "QinDao")));
        return SUCCESS;
    }

    @RequestMapping(value = "modelAttribute")
//    public String testModelAttribute(User user) {
    public String testModelAttribute(@ModelAttribute(value = "abc") User user) {
        System.out.println("modelAttribute:success");
        System.out.println("user: " + user);
        return SUCCESS;
    }

    @ModelAttribute
    public void getUser(@RequestParam(value = "id", required = false) Integer id, ModelMap modelMap) {
        if (id != null) {
//            modelMap.addAttribute("user", new User(1, "Tim", "123456", 25, "Tim@mail.com", new Address("JiangSu", "SuZhou")));
            modelMap.addAttribute("abc", new User(1, "Tim", "123456", 25, "Tim@mail.com", new Address("JiangSu", "SuZhou")));
        }
        System.out.println("ModelAttribute doing");
    }

    @RequestMapping(value = "helloView")
    public String testHelloView() {
        return "helloView";
    }

    @RequestMapping(value = "redirect")
    public String testRedirect() {
        System.out.println("redirect:hello");
        return "redirect:/done.jsp";
    }

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "emps")
    public String listEmployees(ModelMap modelMap) {
        modelMap.addAttribute("employees", employeeDao.getAll());
        return "list";
    }

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping(value = "emp", method = RequestMethod.GET)
    public String input(ModelMap modelMap) {
        modelMap.put("employee", new Employee());
        modelMap.addAttribute("departments", departmentDao.getDepartments());
        return "input";
    }

    @RequestMapping(value = "emp", method = RequestMethod.POST)
    public String save(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/mvc/emps";
    }
}
