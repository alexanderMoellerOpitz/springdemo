package com.bewerbung.springdemo.mapper;

import com.bewerbung.springdemo.model.dto.DemoEntityDto;
import com.bewerbung.springdemo.model.request.CreateDemoEntityRequest;
import com.bewerbung.springdemo.model.entity.DemoEntity;
import org.springframework.stereotype.Component;

@Component
public class DemoEntityMapper {
    public DemoEntityDto toDto(DemoEntity demoEntity) {
        DemoEntityDto dto = DemoEntityDto.builder().name(demoEntity.getName()).build();
        return dto;
    }

    public DemoEntity requestToEntity(CreateDemoEntityRequest createDemoEntityRequest) {
        DemoEntity entity = DemoEntity.builder().name(createDemoEntityRequest.getName()).build();
        return entity;
    }
}
