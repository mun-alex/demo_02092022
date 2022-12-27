package kz.bitlab.demo.controllers;

import kz.bitlab.demo.db.DBManager;
import kz.bitlab.demo.models.Magazine;
import kz.bitlab.demo.services.MagazineService;
import kz.bitlab.demo.services.PublishingService;
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
    private MagazineService magazineService;

    @Autowired
    private PublishingService publishingService;

    @Autowired
    private Magazine magazine;

    @GetMapping
    String getIndex(Model model) {
//        model.addAttribute("magazineList", DBManager.getAllMagazines());

        model.addAttribute("magazineList", magazineService.getAllMagazines());
        model.addAttribute("publishingList", publishingService.getAllPublishings());
        return "magazines";
    }

    @PostMapping(value = "/add-magazine")
    String addNewMagazine(@RequestParam(name = "magazineName") String name,
                          @RequestParam(name = "magazineDescription") String description,
                          @RequestParam(name = "magazinePrice") double price,
                          @RequestParam(name = "publishing") Long publishingId) {
//        Magazine magazine = new Magazine(null, name, description, price);
//        Publishing publishing = publishingRepository.findById(publishingId).orElseThrow();
//        DBManager.addMagazine(magazine);
//        MagazineRepositoryImpl magazineRepository = new MagazineRepositoryImpl();

        magazine.setId(null);
        magazine.setName(name);
        magazine.setDescription(description);
        magazine.setPrice(price);
        magazine.setPublishing(publishingService.getPublishingById(publishingId));
        magazineService.addNewMagazine(magazine);
        return "redirect:/magazines";
    }

    /**
     * Метод для возвращения формы "детали журнала"
     *
     * @param magazineId
     * @param model
     * @return
     */
    @GetMapping(value = "/details/{magazineId}")
    String getEditForm(@PathVariable(name = "magazineId") Long magazineId,
                       Model model) {
        log.info("MagazineController, getEditForm, id: " + magazineId);
//        Magazine magazine = new Magazine();
//        magazine = DBManager.getMagazineById(45L);
        magazine = magazineService.getMagazineById(magazineId);
        model.addAttribute("publishingList", publishingService.getAllPublishings());
        model.addAttribute("magazine", magazine);
        return "magazineDetails";
    }

    @PostMapping(value = "/update")
    String updateMagazine(@RequestParam(name = "magazineId") Long id,
                          @RequestParam(name = "magazineName") String name,
                          @RequestParam(name = "magazineDescription") String description,
                          @RequestParam(name = "magazinePrice") double price,
                          @RequestParam(name = "publishing") Long publishingId) {
//        Magazine magazine = new Magazine(id, name, description, price, null, null);
//        DBManager.updateMagazine(magazine);

        magazine.setId(id);
        magazine.setName(name);
        magazine.setDescription(description);
        magazine.setPublishing(publishingService.getPublishingById(publishingId));
        magazine.setPrice(price);
        magazineService.updateNewMagazine(magazine);
        return "redirect:/magazines";
    }

    @GetMapping(value = "/delete/{magazineId}")
    String deleteMagazineById(@PathVariable(name = "magazineId") Long magazineId) {
//        DBManager.deleteMagazine(magazineId);

        magazineService.deleteMagazineById(magazineId);
        return "redirect:/magazines";
    }
}
