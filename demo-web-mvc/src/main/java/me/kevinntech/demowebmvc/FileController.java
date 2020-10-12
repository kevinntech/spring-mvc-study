package me.kevinntech.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileController {

    // "/file" 주소로 GET 요청을 하면 파일 업로드 Form을 보여준다.
    @GetMapping("/file")
    public String fileUploadForm(Model model){
        return "files/index";
    }

    // "/file" 주소로 POST 요청을 하면 파일 업로드 Form을 보여준다.
    @PostMapping("/file")
    public String fileUpload(@RequestParam MultipartFile file, // HTML form의 이름과 동일하게 함 (다르다면 명시해야 됨)
                             RedirectAttributes attributes){
        // save
        String message = file.getOriginalFilename() + " is uploaded";
        attributes.addFlashAttribute("message", message); // 메시지가 세션에 저장되며 리다이렉트 요청을 처리 한 다음, 그 즉시 제거한다

        return "redirect:/file";
    }

}
