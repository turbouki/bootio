package com.example.bootio.app.web;

import com.example.bootio.app.model.AccountCreateForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Controller
@RequestMapping("account")
public class AccountController {

//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//        binder.registerCustomEditor(Date.class,
//                new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true, 10));
//    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute(new AccountCreateForm()); // 폼 객체를 모델에 저장한다, 속성명은 생략할 수 있다, 생략한 경우 기본 속성명 적용(클래스명의 첫글자 소문자로 한 이름)
        return "account/createForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String add(AccountCreateForm accountCreateForm, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "account/createForm";
        }
        log.info("Form: {}", accountCreateForm);
        log.info("Model: {}", model);
        log.info("Model: {}", result);
        return "account/accountView";
    }
}
