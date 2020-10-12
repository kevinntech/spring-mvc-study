package me.kevinntech.demowebmvc;

import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
public class FileController {

    @Autowired
    private ResourceLoader resourceLoader;

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

    @GetMapping("/file/{filename}")
    public ResponseEntity<Resource> fileDownload(@PathVariable String filename) throws
            IOException {
        Resource resource = resourceLoader.getResource("classpath:" + filename); File file = resource.getFile();
        Tika tika = new Tika(); // Tika를 빈으로 등록해서 재사용 할 수도 있다.
        String type = tika.detect(file); // detect()를 사용하면 미디어 타입을 알 수 있다.
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachement; filename=\"" +
                        resource.getFilename() + "\"")
                .header(HttpHeaders.CONTENT_TYPE, type) .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(file.length())) .body(resource);
    }

}
