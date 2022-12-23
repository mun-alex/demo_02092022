package kz.bitlab.demo.controllers;

import kz.bitlab.demo.repositories.PublishingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/publishings")
public class PublishingController {
    @Autowired
    private PublishingRepository publishingRepository;

//    @GetMapping
//    String getAllPublishings(Model model) {
//        model.addAttribute("publishingList", publishingRepository.findAll());
//        return
//    }
}
