package ra.orm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UploadController {
//    private static final  String uploadPath= "C:\\Users\\AD\\IdeaProjects\\mvc-hibernate-config\\src\\main\\webapp\\uploads";
    @Autowired
    private ServletContext   servletContext;
    @PostMapping("/upload")
    public String doUpload(@RequestParam("file") List<MultipartFile> files, Model model){
        // đối tượng đại diện cho file upload lên là MultipartFile
        // xử lí upload
        // lấy ra dia chi upload trên server
        String uploadPath = servletContext.getRealPath("/uploads");
        File fileUpload = new File(uploadPath);
        if (!fileUpload.exists()){
            fileUpload.mkdirs();
        }

        // b1 : lấy ra tên file
        List<String> fileNames = new ArrayList<>();
        files.forEach(file -> {
            String fileName =null;
            if(file.getSize() !=0){
                fileName= file.getOriginalFilename(); // lấy ra tên file trong thư mục máy tinh
                try {
                    FileCopyUtils.copy(file.getBytes(),new File(uploadPath+File.separator+fileName));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            fileNames.add(fileName);
        });
        // upload thành công
        model.addAttribute("fileNames",fileNames);
        return "success";
    }

    @GetMapping("/upload")
    public String uploadForm(){
        return "upload";
    }
}
