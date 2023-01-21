package com.example.bootio.app.web;

import com.example.bootio.app.model.Company;
import com.example.bootio.app.model.Person;
import com.example.bootio.app.model.User;
import com.example.bootio.app.validation.PersonValidator;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Objects;

@Controller
public class JspController {

//    @Autowired
//    PersonValidator validator;

    @GetMapping("test/jsp")
    public String index() {
        return "test";
    }

    @GetMapping("user/jsp")
    public String userForm() {
        return "user";
    }

    @PostMapping(path="user/addForm")
   // @ResponseBody
    public String addUserByForm(@Valid User user, BindingResult result) {
        ModelMap resultMap = new ModelMap();
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "user";
        }

        System.out.println("Result: 성공");
        return "redirect:/user/jsp";
    }

    @PostMapping(path="user/addJson")
    // @ResponseBody
    public ResponseEntity<Void> addUserByJson(@RequestBody @Valid User user) {
        // UserService userService.add(user) ;
        return ResponseEntity.noContent().build();
    }

    @GetMapping("person/jsp")
    public ModelAndView personForm() {
        return new ModelAndView("person","person", new Person());
    }
    @PostMapping(path="person/jsp")
    // @ResponseBody
    public String getPerson(@Valid Person person, BindingResult result) {
        // !더  연구해야 함
        BeanWrapper company = new BeanWrapperImpl(new Company());
      //  System.out.println(company.getPropertyValue("name"));

        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "person";
        }

        System.out.println("Result: 성공");
        return "redirect:/person/jsp";
    }

    @GetMapping("data/jsp")
    public String api() {
        return "data";
    }
}
