package spring.tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Robert on 10/11/2015.
 */

@Controller
public class BasicController extends WebMvcConfigurerAdapter {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm() {
        return "index";
    }

}
