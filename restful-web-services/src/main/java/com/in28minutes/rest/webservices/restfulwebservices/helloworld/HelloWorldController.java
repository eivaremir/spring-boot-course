package com.in28minutes.rest.webservices.restfulwebservices.helloworld;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    //@RequestMapping(method= RequestMethod.GET,path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloworld(){
        return "hello world";
    }



    @GetMapping(path = "/hello-world-i")
    public String helloworldInternationalized(
            //@RequestHeader(name="Accept-Language",required = false) Locale locale
    ){

        return messageSource.getMessage("good.morning.message",null,"Default msg",
                //locale
                LocaleContextHolder.getLocale()
        );
        //return new HelloWorldBean("hello-world");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloworldbean2(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello, %s",name));
    }
}
