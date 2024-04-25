package org.Launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

//    @GetMapping ("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!" ;
//    }
    //lives /hello/goodbye
    @GetMapping ("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!" ;
    }
    //lives /hello/hello
    //Handles request of the form/hello?name=LaunchCode
   @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello," + name + "!" ;
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("Hello/{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!" ;
    }

    @GetMapping("form")
    public String helloform(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name= 'name'>" +
                "<input type='submit' value= 'Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";

    }
}