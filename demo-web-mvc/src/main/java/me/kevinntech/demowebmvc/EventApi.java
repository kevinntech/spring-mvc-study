package me.kevinntech.demowebmvc;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/events")
public class EventApi {

    @PostMapping
    public ResponseEntity<Event> createEvent(@Valid @RequestBody Event event,
                                      BindingResult bindingResult){
        // save event
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(event);
    }

}
