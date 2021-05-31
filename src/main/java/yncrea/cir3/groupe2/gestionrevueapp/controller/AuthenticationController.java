package yncrea.cir3.groupe2.gestionrevueapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import yncrea.cir3.groupe2.gestionrevueapp.domain.message.FlashMessage;
import yncrea.cir3.groupe2.gestionrevueapp.domain.message.FlashMessageLevel;
import yncrea.cir3.groupe2.gestionrevueapp.domain.security.User;
import yncrea.cir3.groupe2.gestionrevueapp.form.UserForm;
import yncrea.cir3.groupe2.gestionrevueapp.repository.UserRepository;

import javax.validation.Valid;
import java.util.Objects;

@Controller
public class AuthenticationController {
    @Autowired
    private UserRepository users;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/login")
    public String login(Model model) {
        return "authentication/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        UserForm form = new UserForm();
        model.addAttribute("user", form);

        return "authentication/register";
    }

    @PostMapping("/register")
    public String registerAction(@Valid @ModelAttribute("user") UserForm form, BindingResult result, Model model, RedirectAttributes attributes) {
        boolean passwordMatch = Objects.equals(form.getPassword(), form.getPassword2());

        if (result.hasErrors() || !passwordMatch) {
            model.addAttribute("user", form);
            if (!passwordMatch) {
                model.addAttribute("passwordShouldMatch", true);
            }

            return "authentication/register";
        }

        // create new user
        User user = new User();
        user.setUsername(form.getUsername());
        user.setEmail(form.getEmail());
        user.setPassword(encoder.encode(form.getPassword()));

        // save user
        try {
            users.save(user);
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("user", form);
            model.addAttribute("message", new FlashMessage("L'adresse email ou le nom de l'utilisateur est déjà utilisé.", FlashMessageLevel.ERROR));
            return "authentication/register";
        }

        // add flash message
        attributes.addFlashAttribute("message", new FlashMessage("Votre compte a été créée, vous pouvez désormais vous connecter !", FlashMessageLevel.SUCCESS));

        return "redirect:/login";
    }
}
