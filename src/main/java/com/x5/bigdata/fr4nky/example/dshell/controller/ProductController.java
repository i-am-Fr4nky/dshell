package com.x5.bigdata.fr4nky.example.dshell.controller;

import com.x5.bigdata.fr4nky.example.dshell.service.ExcelUnloadService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("data")
@RequiredArgsConstructor
@Slf4j
public class ProductController {


    private final ExcelUnloadService excelUnloadService;

    @GetMapping("/download")
    public void unload(HttpServletResponse response) {
        log.debug("Unload excel");
        excelUnloadService.unload(response);
    }

    @GetMapping("create/{countRecords}")
    public void create(@PathVariable int countRecords) {
        log.debug("Unload excel");
        excelUnloadService.create(countRecords);
    }
}
