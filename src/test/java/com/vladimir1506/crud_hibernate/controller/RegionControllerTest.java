package com.vladimir1506.crud_hibernate.controller;

import com.vladimir1506.crud_hibernate.model.Region;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RegionControllerTest {
    RegionController regionController;

    @Before
    public void setUp() {
        List<Region> regions = new ArrayList<>();
        Region region = new Region("US");
        region.setId(1L);
        regions.add(region);
        regionController = mock(RegionController.class);
        when(regionController.getAll()).thenReturn(regions);
        when(regionController.getRegionById(1L)).thenReturn(region);
    }

    @Test
    public void getAllTest() {
        List<Region> regionsForTest = new ArrayList<>();
        Region region = new Region("US");
        region.setId(1L);
        regionsForTest.add(region);
        List<Region> regions = regionController.getAll();
        assertEquals(regionsForTest.size(), regions.size());
        assertEquals(regionsForTest.get(0).getId(),
                regions.get(0).getId());
        assertEquals(regionsForTest.get(0).getName(),
                regions.get(0).getName());
        verify(regionController).getAll();
    }

    @Test
    public void getByIdTest() {
        Region region = new Region("US");
        region.setId(1L);
        Region regionById = regionController.getRegionById(1L);

        assertEquals(region.getId(), regionById.getId());
        assertEquals(region.getName(), regionById.getName());

        verify(regionController, atLeastOnce()).getRegionById(1L);
    }

    @Test
    public void updateTest() {
        Region region = new Region("US");
        region.setId(1L);
        region.setName("EU");
        regionController.updateRegion(region.getId(), region.getName());
        verify(regionController).updateRegion(region.getId(), region.getName());
    }

}