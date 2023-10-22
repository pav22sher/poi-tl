package com.example.poitl.service;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.plugin.table.LoopRowTableRenderPolicy;
import com.example.poitl.domain.Goal;
import jakarta.servlet.ServletOutputStream;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.HashMap;

@Service
public class TemplateService {
    @SneakyThrows
    public void hello(ServletOutputStream outputStream) {
        File file = ResourceUtils.getFile("classpath:hello-template.docx");
        XWPFTemplate template = XWPFTemplate.compile(file).render(
                new HashMap<String, Object>() {{
                    put("title", "Hello, poi-tl!");
                }});
        template.writeAndClose(outputStream);
    }
    @SneakyThrows
    public void template(ServletOutputStream outputStream) {
        File file = ResourceUtils.getFile("classpath:goal-template.docx");
        LoopRowTableRenderPolicy policy = new LoopRowTableRenderPolicy();
        Configure config = Configure.builder().bind("goals", policy).build();
        XWPFTemplate template = XWPFTemplate.compile(file, config).render(
                new HashMap<String, Object>() {{
                    put("goals", Goal.getGoals());
                }});
        template.writeAndClose(outputStream);
    }
}
