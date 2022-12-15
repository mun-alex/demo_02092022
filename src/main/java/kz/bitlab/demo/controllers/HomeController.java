package kz.bitlab.demo.controllers;

import kz.bitlab.demo.db.DBManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    String getIndex(Model model) {
        model.addAttribute("magazineList", DBManager.getAllMagazines());
        return "index";
    }
}
