package com.bewerbung.springdemo.service;

import com.bewerbung.springdemo.dto.DemoEntityDto;
import com.bewerbung.springdemo.mapper.DemoEntityMapper;
import com.bewerbung.springdemo.model.DemoEntity;
import com.bewerbung.springdemo.repository.DemoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<DemoEntity> entites = demoEntityRepository.findAll();
        return entites.stream().map(demoEntityMapper::toDto).toList();
    }

    public void clearEntities() {
        demoEntityRepository.deleteAll();
    }

    public DemoEntityDto addEntity(String name) {
        DemoEntity demoEntity = new DemoEntity(name);
        demoEntityRepository.save(demoEntity);
        return demoEntityMapper.toDto(demoEntity);
    }
}
