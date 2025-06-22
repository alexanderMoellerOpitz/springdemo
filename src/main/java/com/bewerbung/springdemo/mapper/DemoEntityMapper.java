package com.bewerbung.springdemo.mapper;

import com.bewerbung.springdemo.dto.DemoEntityDto;
import com.bewerbung.springdemo.model.DemoEntity;
import org.springframework.stereotype.Component;

@Component
public class DemoEntityMapper {
    public DemoEntityDto toDto(DemoEntity demoEntity) {
        return new DemoEntityDto(demoEntity.getName());
    }
}
