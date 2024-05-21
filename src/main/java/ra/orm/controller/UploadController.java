package ra.orm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    private static final  String uploadPath= "C:\\Users\\AD\\IdeaProjects\\mvc-hibernate-config\\src\\main\\webapp\\uploads";
    @PostMapping("/upload")
    public String doUpload(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        // đối tượng đại diện cho file upload lên là MultipartFile
        // xử lí upload
        // b1 : lấy ra tên file
        String fileName =null;
        if(file.getSize() !=0){
             fileName= file.getOriginalFilename(); // lấy ra tên file trong thư mục máy tinh
            FileCopyUtils.copy(file.getBytes(),new File(uploadPath+File.separator+fileName));
        }
        // upload thành công
        model.addAttribute("fileName",fileName);
        return "success";
    }

    @GetMapping("/upload")
    public String uploadForm(){
        return "upload";
    }
}
