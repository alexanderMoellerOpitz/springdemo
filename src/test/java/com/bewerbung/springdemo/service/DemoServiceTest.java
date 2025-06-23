package com.bewerbung.springdemo.service;

import com.bewerbung.springdemo.model.dto.DemoEntityDto;
import com.bewerbung.springdemo.mapper.DemoEntityMapper;
import com.bewerbung.springdemo.model.entity.DemoEntity;
import com.bewerbung.springdemo.repository.DemoEntityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DemoServiceTest {
    @Mock
    private DemoEntityRepository demoEntityRepository;
    private DemoEntityMapper demoEntityMapper = new DemoEntityMapper();

    private DemoService demoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        demoService = new DemoService(demoEntityRepository, demoEntityMapper);
    }

    @Test
    void getAllEntries() {
        DemoEntity entity1 = DemoEntity.builder().name("Test1").build();
        DemoEntity entity2 = DemoEntity.builder().name("Test2").build();
        when(demoEntityRepository.findAll()).thenReturn(Arrays.asList(entity1, entity2));

        List<DemoEntityDto> result = demoService.getAllEntries();

        assertEquals(2, result.size());
        assertEquals("Test1", result.get(0).getName());
        assertEquals("Test2", result.get(1).getName());
    }

    @Test
    void clearEntities() {
        demoService.clearEntities();

        verify(demoEntityRepository).deleteAll();
    }

    @Test
    void givenDtoWithName_whenAddEntity_thenDtoWithSameNameIsReturned() {
//        String name = "name";
//        DemoEntity entity = new DemoEntity(name);
//        DemoEntityDto dto = new DemoEntityDto(name);
//
//        // Capture the saved entity and verify conversion
//        ArgumentCaptor<DemoEntity> entityCaptor = ArgumentCaptor.forClass(DemoEntity.class);
//        when(demoEntityMapper.toDto(any(DemoEntity.class))).thenReturn(dto);
//
//        DemoEntityDto result = demoService.addEntity(name);
//
//        verify(demoEntityRepository).save(entityCaptor.capture());
//        DemoEntity savedEntity = entityCaptor.getValue();
//
//        assertEquals(name, savedEntity.getName());
//        assertEquals(dto, result);
//        verify(demoEntityMapper).toDto(savedEntity);
    }
}