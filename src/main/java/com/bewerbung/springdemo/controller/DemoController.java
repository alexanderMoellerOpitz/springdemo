package com.bewerbung.springdemo.controller;

import com.bewerbung.springdemo.dto.DemoEntityDto;
import com.bewerbung.springdemo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoservice){
        this.demoService = demoservice;
    }

    @GetMapping("/getAllEntries")
    public List<DemoEntityDto> getList() {
        return demoService.getAllEntries();
    }

    @PostMapping("/addEntry")
    public DemoEntityDto addEntry(@RequestParam String name) {
        return demoService.addEntity(name);
    }

    @PostMapping("/clearList")
    public void clearList() {
        demoService.clearEntities();
    }
}
