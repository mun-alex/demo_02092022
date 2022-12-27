package kz.bitlab.demo.services;

import kz.bitlab.demo.models.Magazine;

import java.util.List;

public interface MagazineService {
    List<Magazine> getAllMagazines();
    void addNewMagazine(Magazine magazine);
    Magazine getMagazineById(Long id);
    void deleteMagazineById(Long id);
    void updateNewMagazine(Magazine magazine);
}
