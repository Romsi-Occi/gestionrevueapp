package yncrea.cir3.groupe2.gestionrevueapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import yncrea.cir3.groupe2.gestionrevueapp.domain.Projet;
import yncrea.cir3.groupe2.gestionrevueapp.form.ProjetForm;
import yncrea.cir3.groupe2.gestionrevueapp.repository.ProjetRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/projet")
public class ProjetController {

    @Autowired
    private ProjetRepository projet;

    @GetMapping({"/","/list"})
    public String list(Model model)
    {
        model.addAttribute("projet", projet.findAll());
        return "projet/list";
    }

    @GetMapping({"/add","edit/{id}"})
    public String add(@PathVariable(required = false) Long id, Model model)
    {
        ProjetForm form = new ProjetForm();
        model.addAttribute("projet", form);

        if (id!=null)
        {
            Projet p = projet.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));

            form.setId(p.getId());
            form.setTitle(p.getTitle());
            form.setDescription(p.getDescription());
        }

        return "projet/add";
    }

    @PostMapping("/add")
    public String addAction(@Valid @ModelAttribute("projet") ProjetForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("project", form);
            return "projet/add";
        }

        Projet p = new Projet();

        if (form.getId() != null) {
            p = projet.findById(form.getId()).orElseThrow(() -> new RuntimeException("Not found"));
        }

        p.setTitle(form.getTitle());
        projet.save(p);

        return "redirect:/projet/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(HttpServletRequest request, @PathVariable Long id) {
        projet.deleteById(id);
        String redirect ="/projet/list";
        String referer = request.getHeader("Referer");
        if (referer != null)
        {
            redirect = referer;
        }
        return "redirect:" + referer;
    }
}
