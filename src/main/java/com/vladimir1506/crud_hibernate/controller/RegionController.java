package com.vladimir1506.crud_hibernate.controller;

import com.vladimir1506.crud_hibernate.model.Region;
import com.vladimir1506.crud_hibernate.repository.RegionRepository;
import com.vladimir1506.crud_hibernate.repository.implementation.DBRegionRepositoryImpl;

import java.util.List;

public class RegionController {

    private RegionRepository regionRepository;

    public RegionController() {
        this.regionRepository = new DBRegionRepositoryImpl();
    }

    public RegionController(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public Region createRegion(String name) {
        Region region = new Region(name);
        return regionRepository.save(region);
    }

    public List<Region> getAll() {
        return regionRepository.getAll();
    }

    public void deleteRegion(Long id) {
        regionRepository.delete(id);
    }

    public Region getRegionById(Long id) {
        return regionRepository.getById(id);
    }

    public void updateRegion(Long id, String name) {
        Region updatedRegion = new Region(name);
        updatedRegion.setId(id);
        regionRepository.update(updatedRegion);
    }
}
