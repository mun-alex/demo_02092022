package kz.bitlab.demo.controllers;

import kz.bitlab.demo.services.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private MagazineService magazineService;

    @GetMapping(value = "/")
    String getIndex(Model model) {
//        model.addAttribute("magazineList", DBManager.getAllMagazines());
        model.addAttribute("magazineList", magazineService.getAllMagazines());
        return "index";
    }
}
