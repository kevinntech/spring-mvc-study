package me.kevinntech.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
public class SampleController {

    @RequestMapping({"/kevin.*", "/kevin"})
    @ResponseBody
    public String helloKevin(){
        return "hello kevin";
    }

}
