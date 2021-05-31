package yncrea.cir3.groupe2.gestionrevueapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import yncrea.cir3.groupe2.gestionrevueapp.form.ProjetForm;
import yncrea.cir3.groupe2.gestionrevueapp.repository.ProjetRepository;

@Controller
public class IndexController {
    @Autowired
    private ProjetRepository projetRepository;

    @GetMapping({"/",""})
    public String index(Model model, @PageableDefault(page = 0,size = 10) Pageable pageable){
        ProjetForm form = new ProjetForm();

        model.addAttribute("projet",projetRepository.findAll(pageable));
        model.addAttribute("form", form);

        return "index/index";
    }

    @GetMapping("/user-info")
    public String userInfo() {
        return "index/user-info";
    }

}
