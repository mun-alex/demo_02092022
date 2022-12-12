package kz.bitlab.demo.controllers;

import kz.bitlab.demo.db.DBManager;
import kz.bitlab.demo.models.Magazine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    String getIndex(Model model) {
        model.addAttribute("magazineList", DBManager.getAllMagazines());
        return "index";
    }

    @PostMapping(value = "/add-magazine")
    String addNewMagazine(@RequestParam(name = "magazineName") String name,
                          @RequestParam(name = "magazineDescription") String description,
                          @RequestParam(name = "magazinePrice") double price) {
        Magazine magazine = new Magazine(null, name, description, price);
        DBManager.addMagazine(magazine);
        return "redirect:/";
    }
}
