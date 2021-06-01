package yncrea.cir3.groupe2.gestionrevueapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import yncrea.cir3.groupe2.gestionrevueapp.domain.Projet;
import yncrea.cir3.groupe2.gestionrevueapp.domain.Review;
import yncrea.cir3.groupe2.gestionrevueapp.form.ProjetForm;
import yncrea.cir3.groupe2.gestionrevueapp.form.ReviewForm;
import yncrea.cir3.groupe2.gestionrevueapp.repository.ProjetRepository;
import yncrea.cir3.groupe2.gestionrevueapp.repository.ReviewRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewRepository reviews;

    @Autowired
    private ProjetRepository projets;

    @GetMapping({"", "/", "/list"})
    public String list(Model model) {
        model.addAttribute("review", reviews.findAll());
        return "review/list";
    }

    @GetMapping({"/add","edit/{id}"})
    public String add(@PathVariable(required = false) Long id, Model model)
    {
        ReviewForm form = new ReviewForm();
        model.addAttribute("review", form);

        if (id!=null)
        {
            Review r = reviews.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
            r.computeControlPoints();

            form.setId(r.getId());
            form.setTitle(r.getTitle());
            form.setHighest_CVSS(r.getHighest_CVSS());
            form.setNoncompliances(r.getNoncompliances());
            form.setParent_review(r.getParent_review());

        }

        return "review/add";
    }

    @PostMapping("/add")
    public String addAction(@Valid @ModelAttribute("review") ProjetForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("review", form);
            return "review/add";
        }

        Review r = new Review();

        if (form.getId() != null) {
            r = reviews.findById(form.getId()).orElseThrow(() -> new RuntimeException("Not found"));
        }

        r.setTitle(form.getTitle());
        reviews.save(r);

        return "redirect:/review/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(HttpServletRequest request, @PathVariable Long id) {
        reviews.deleteById(id);
        String redirect ="/review/list";
        String referer = request.getHeader("Referer");
        if (referer != null)
        {
            redirect = referer;
        }
        return "redirect:" + referer;
    }
}

