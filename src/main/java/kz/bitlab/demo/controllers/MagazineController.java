package kz.bitlab.demo.controllers;

import kz.bitlab.demo.db.DBManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/magazines")
public class MagazineController {

    @GetMapping
    String getIndex(Model model) {
        model.addAttribute("magazineList", DBManager.getAllMagazines());
        return "magazines";
    }
}
