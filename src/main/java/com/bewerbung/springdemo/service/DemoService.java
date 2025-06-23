package com.bewerbung.springdemo.service;

import com.bewerbung.springdemo.model.dto.DemoEntityDto;
import com.bewerbung.springdemo.mapper.DemoEntityMapper;
import com.bewerbung.springdemo.model.request.CreateDemoEntityRequest;
import com.bewerbung.springdemo.model.entity.DemoEntity;
import com.bewerbung.springdemo.repository.DemoEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {
    private DemoEntityRepository demoEntityRepository;
    private DemoEntityMapper demoEntityMapper;

    DemoService(DemoEntityRepository demoEntityRepository, DemoEntityMapper demoEntityMapper) {
        this.demoEntityRepository = demoEntityRepository;
        this.demoEntityMapper = demoEntityMapper;
    }

    public List<DemoEntityDto> getAllEntries() {
        List<DemoEntity> entities = demoEntityRepository.findAll();
        return entities.stream().map(demoEntityMapper::toDto).toList();
    }

    public void clearEntities() {
        demoEntityRepository.deleteAll();
    }

    public DemoEntityDto addEntity(CreateDemoEntityRequest createDemoEntityRequest) {
        DemoEntity demoEntity = demoEntityMapper.requestToEntity(createDemoEntityRequest);
        return demoEntityMapper.toDto(demoEntityRepository.save(demoEntity));
    }
}
