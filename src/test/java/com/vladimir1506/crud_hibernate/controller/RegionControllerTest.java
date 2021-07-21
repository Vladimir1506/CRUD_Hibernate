package com.vladimir1506.crud_hibernate.controller;

import com.vladimir1506.crud_hibernate.model.Region;
import com.vladimir1506.crud_hibernate.repository.implementation.DBRegionRepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RegionControllerTest {
    @Mock
    DBRegionRepositoryImpl dbRegionRepository;
    @InjectMocks
    private RegionController regionController;

    @Before
    public void setUp() {
        List<Region> regions = new ArrayList<>();
        Region region = new Region("US");
        region.setId(1L);
        regions.add(region);
        regionController.setRegionRepository(dbRegionRepository);
        when(dbRegionRepository.getAll()).thenReturn(regions);
        when(dbRegionRepository.getById(1L)).thenReturn(region);
    }

    @Test
    public void getAllTest() {
        List<Region> regionsForTest = new ArrayList<>();
        Region regionForTest = new Region("US");
        regionForTest.setId(1L);
        regionsForTest.add(regionForTest);
        List<Region> regions = regionController.getAll();
        assertEquals(regionsForTest.size(), regions.size());
        assertEquals(regionsForTest.get(0).getId(),
                regions.get(0).getId());
        assertEquals(regionsForTest.get(0).getName(),
                regions.get(0).getName());
        verify(dbRegionRepository).getAll();
    }

    @Test
    public void getByIdTest() {
        Region region = new Region("US");
        region.setId(1L);
        Region regionById = regionController.getRegionById(1L);

        assertEquals(region.getId(), regionById.getId());
        assertEquals(region.getName(), regionById.getName());

        verify(dbRegionRepository, atLeastOnce()).getById(1L);
    }

}