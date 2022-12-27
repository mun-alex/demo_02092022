package kz.bitlab.demo.services.impl;

import kz.bitlab.demo.models.Magazine;
import kz.bitlab.demo.repositories.MagazineRepository;
import kz.bitlab.demo.services.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagazineServiceImpl implements MagazineService {

    @Autowired
    private MagazineRepository magazineRepository;
    @Override
    public List<Magazine> getAllMagazines() {
        return magazineRepository.findAll();
    }

    @Override
    public void addNewMagazine(Magazine magazine) {
        magazineRepository.save(magazine);
    }

    @Override
    public Magazine getMagazineById(Long id) {
        return magazineRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteMagazineById(Long id) {
        magazineRepository.deleteById(id);
    }

    @Override
    public void updateNewMagazine(Magazine magazine) {
        magazineRepository.save(magazine);
    }
}
