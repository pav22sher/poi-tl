package com.example.poitl.controller;

import com.example.poitl.service.TemplateService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateController {

    @Autowired
    private TemplateService service;

    @SneakyThrows
    @GetMapping("/hello")
    public void hello(HttpServletResponse response) {
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=hello.docx");
        ServletOutputStream outputStream = response.getOutputStream();
        service.hello(outputStream);
        outputStream.close();
    }

    @SneakyThrows
    @GetMapping("/template")
    public void template(HttpServletResponse response) {
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=template.docx");
        ServletOutputStream outputStream = response.getOutputStream();
        service.template(outputStream);
        outputStream.close();
    }
}
