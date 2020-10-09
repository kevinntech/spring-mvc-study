package me.kevinntech.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    @GetMapping("/events")
    @ResponseBody
    public String events(){
        return "events";
    }

    @GetMapping("/events/{id}")
    @ResponseBody
    public String getAnEvents(@PathVariable int id){
        return "events";
    }


    @DeleteMapping("/events/{id}")
    @ResponseBody
    public String removeAnEvents(@PathVariable int id){
        return "events";
    }

    @GetHelloMapping
    @ResponseBody
    public String hello(){
        return "hello";
    }

}
