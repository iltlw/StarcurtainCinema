package com.buka.service;

import com.buka.http.AppInfo;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class DownService {

    public void movieImg(String filename, HttpServletResponse response) throws IOException {
        File file=new File(AppInfo.MOVIE_IMG_PATH,filename);
        if(file.exists()){
            response.setHeader("Content-Disposition","attachment; filename="+filename);
            FileInputStream fis=null;
            ServletOutputStream outputStream = response.getOutputStream();
            try{
                response.setContentLengthLong(file.length());
                fis=new FileInputStream(file);
                byte[] bytes=new byte[1024*1024];
                int len =0;
                while((len=fis.read(bytes))!=-1){
                    outputStream.write(bytes,0,len);
                }
            }finally {
                if(fis!=null){
                    fis.close();
                }
            }
        }
    }
}
