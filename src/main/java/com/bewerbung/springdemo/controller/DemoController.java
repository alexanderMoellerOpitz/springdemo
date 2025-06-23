package com.bewerbung.springdemo.controller;

import com.bewerbung.springdemo.model.dto.DemoEntityDto;
import com.bewerbung.springdemo.model.request.CreateDemoEntityRequest;
import com.bewerbung.springdemo.service.DemoService;
import jakarta.validation.Valid;
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
    public List<DemoEntityDto> getAllEntries() {
        return demoService.getAllEntries();
    }

    @PostMapping("/addEntry")
    public DemoEntityDto addEntry(@RequestBody @Valid CreateDemoEntityRequest createDemoEntityRequest) {
        return demoService.addEntity(createDemoEntityRequest);
    }

    @PostMapping("/clearList")
    public void clearList() {
        demoService.clearEntities();
    }
}
