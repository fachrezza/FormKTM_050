/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.ktm;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author A S U S
 */
@Controller
public class myController {
    
    @RequestMapping("/getData")
    public String getData(@RequestParam("name") String text,
                          @RequestParam("image") MultipartFile file,
                          @RequestParam("tanggal")@DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                          @RequestParam("nim") String nim,
                          @RequestParam("jurusan") String jurusan,
                          @RequestParam("email") String email,
                          
                          Model model) throws IOException{
        
        SimpleDateFormat tanggal = new SimpleDateFormat("EEEE,dd-MMMM-yyyy");
        String newTanggal = tanggal.format(date);
        
        String blob = Base64.encodeBase64String(file.getBytes());
        String gambar = "data:image/jpeg;base64,".concat(blob);
        
        model.addAttribute("nm", text);
        model.addAttribute("n", nim);
        model.addAttribute("mail", email);
        model.addAttribute("jrsn", jurusan);
        model.addAttribute("tgl", newTanggal);
        model.addAttribute("img", gambar);
        
        return "halaman";
    }

}
    

