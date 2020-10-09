package me.kevinntech.demobootweb;

import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

    /*  1) preHandle 1
        2) preHandle 2
        3) 요청 처리 (핸들러)
        4) postHandle 2
        5) postHandle 1
        6) 뷰 렌더링
        7) afterCompletion 2
        8) afterCompletion 1    */

    @GetMapping("/hello")
    public String hello(@RequestParam("id") Person person) {
        return "hello " + person.getName();
    }

    @GetMapping("/message")
    public @ResponseBody String message(@RequestBody String body){
        return body;
    }

    @GetMapping("/jsonMessage")
    public Person jsonMessage(@RequestBody Person person){ // HTTP 요청 본문으로 들어오는 JSON 문자열을 Person 객체로 변환
        return person; // 그리고 그대로 리턴함
    }

}
