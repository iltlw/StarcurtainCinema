package com.buka.controller;

import com.buka.service.DownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@ResponseBody
@RequestMapping("/down")
public class DownController {
    @Autowired
    private DownService downService;
    @GetMapping("/movie/img/{filename}")
    public void movieImg(@PathVariable("filename") String filename, HttpServletResponse response) throws IOException {
        downService.movieImg(filename,response);

    }

}
