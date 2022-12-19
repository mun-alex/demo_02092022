package kz.bitlab.demo.controllers;

import kz.bitlab.demo.db.DBManager;
import kz.bitlab.demo.models.Magazine;
import kz.bitlab.demo.repositories.MagazineRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/magazines")
@Slf4j
public class MagazineController {

    @Autowired
    private MagazineRepository magazineRepository;

    @Autowired
    private Magazine magazine;

    @GetMapping
    String getIndex(Model model) {
//        model.addAttribute("magazineList", DBManager.getAllMagazines());
        model.addAttribute("magazineList", magazineRepository.findAll());
        return "magazines";
    }

    @PostMapping(value = "/add-magazine")
    String addNewMagazine(@RequestParam(name = "magazineName") String name,
                          @RequestParam(name = "magazineDescription") String description,
                          @RequestParam(name = "magazinePrice") double price) {
//        Magazine magazine = new Magazine(null, name, description, price);
        magazine.setId(null);
        magazine.setName(name);
        magazine.setDescription(description);
        magazine.setPrice(price);
        magazineRepository.save(magazine);
//        DBManager.addMagazine(magazine);
//        MagazineRepositoryImpl magazineRepository = new MagazineRepositoryImpl();
        return "redirect:/magazines";
    }

    @GetMapping(value = "/details/{magazineId}")
    String getEditForm(@PathVariable(name = "magazineId") Long magazineId,
                       Model model) {
        log.info("MagazineController, getEditForm, id: " + magazineId);
        Magazine magazine = new Magazine();
        magazine = DBManager.getMagazineById(45L);
        model.addAttribute("magazine", magazine);
        return "magazineDetails";
    }

    @PostMapping(value = "/update")
    String updateMagazine(@RequestParam(name = "magazineId") Long id,
                          @RequestParam(name = "magazineName") String name,
                          @RequestParam(name = "magazineDescription") String description,
                          @RequestParam(name = "magazinePrice") double price) {
        Magazine magazine = new Magazine(id, name, description, price);
        DBManager.updateMagazine(magazine);
        return "redirect:/magazines";
    }

    @GetMapping(value = "/delete/{magazineId}")
    String deleteMagazineById(@PathVariable(name = "magazineId") Long magazineId) {
        DBManager.deleteMagazine(magazineId);
        return "redirect:/magazines";
    }
}
