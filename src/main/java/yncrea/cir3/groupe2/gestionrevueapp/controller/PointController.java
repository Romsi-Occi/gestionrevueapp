package yncrea.cir3.groupe2.gestionrevueapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import yncrea.cir3.groupe2.gestionrevueapp.domain.ControlPoint;
import yncrea.cir3.groupe2.gestionrevueapp.domain.Projet;
import yncrea.cir3.groupe2.gestionrevueapp.form.ControlPointForm;
import yncrea.cir3.groupe2.gestionrevueapp.form.ProjetForm;
import yncrea.cir3.groupe2.gestionrevueapp.repository.PointRepository;
import yncrea.cir3.groupe2.gestionrevueapp.repository.ReviewRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.LinkedHashSet;
import java.util.Set;

@Controller
@RequestMapping("/point")
public class PointController {

    @Autowired
    private ReviewRepository reviews;

    @Autowired
    private PointRepository points;

    @GetMapping({"", "/", "/list"})
    public String list(Model model) {
        model.addAttribute("point", points.findAll());
        return "point/list";
    }

    @GetMapping({"/add","edit/{id}"})
    public String add(@PathVariable(required = false) Long id, Model model)
    {
        ProjetForm form = new ProjetForm();
        model.addAttribute("point", form);

        if (id!=null)
        {
            ControlPoint p = points.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));

            form.setId(p.getId());
            form.setTitle(p.getTitle());
            form.setDescription(p.getDescription());
        }

        return "point/add";
    }

    @PostMapping("/add")
    public String addAction(@Valid @ModelAttribute("point") ProjetForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("point", form);
            return "point/add";
        }

        ControlPoint p = new ControlPoint();

        if (form.getId() != null) {
            p = points.findById(form.getId()).orElseThrow(() -> new RuntimeException("Not found"));
        }

        p.setTitle(form.getTitle());
        points.save(p);

        return "redirect:/point/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(HttpServletRequest request, @PathVariable Long id) {
        points.deleteById(id);
        String redirect ="/point/list";
        String referer = request.getHeader("Referer");
        if (referer != null)
        {
            redirect = referer;
        }
        return "redirect:" + referer;
    }
}
