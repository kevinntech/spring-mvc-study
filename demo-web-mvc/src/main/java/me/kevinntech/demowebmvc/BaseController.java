package me.kevinntech.demowebmvc;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerAdvice(annotations = RestController.class)
public class BaseController {

    @ExceptionHandler
    public String eventErrorHandler(EventException exception,
                                    Model model){
        model.addAttribute("message", "event error");
        return "error";
    }

    @InitBinder
    public void initEventBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id"); // 바인딩을 하고 싶지 않은 필드를 지정한다.
        webDataBinder.addValidators(new EventValidator());
    }

    @ModelAttribute
    public void categories(Model model) {
        model.addAttribute("categories", List.of("study", "seminar", "hobby", "social"));
    }

}
