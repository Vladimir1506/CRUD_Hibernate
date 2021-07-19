package com.vladimir1506.crud_hibernate.repository.implementation;

import com.vladimir1506.crud_hibernate.model.Region;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DBRegionRepositoryImplTest {
    DBRegionRepositoryImpl dbRegionRepository;
    Region reg;

    @Before
    public void setUp() {
        List<Region> regions = new ArrayList<>();
        reg = new Region("US");
        reg.setId(1L);
        regions.add(reg);
        dbRegionRepository = mock(DBRegionRepositoryImpl.class);
        when(dbRegionRepository.getAll()).thenReturn(regions);
        when(dbRegionRepository.getById(1L)).thenReturn(reg);
        Region updatedRegion = new Region("EU");
        updatedRegion.setId(1L);
        doReturn(updatedRegion).when(dbRegionRepository).update(reg);
    }

    @Test
    public void getAllTest() {
        List<Region> regionsForTest = new ArrayList<>();
        Region region = new Region("US");
        region.setId(1L);
        regionsForTest.add(region);
        List<Region> regions = dbRegionRepository.getAll();
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
        Region regionById = dbRegionRepository.getById(1L);

        assertEquals(region.getId(), regionById.getId());
        assertEquals(region.getName(), regionById.getName());

        verify(dbRegionRepository, atLeastOnce()).getById(1L);
    }

    @Test
    public void updateTest() {
        Region region = new Region("US");
        region.setId(1L);
        region.setName("EU");
        Region updatedRegion = dbRegionRepository.
                update(reg);

        assertEquals(region.getId(), updatedRegion.getId());
        assertEquals(region.getName(), updatedRegion.getName());

        verify(dbRegionRepository).update(reg);
    }

}