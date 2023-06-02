package bookstore.avn.avnbookstore.controller;

import bookstore.avn.avnbookstore.services.UserService;
import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {return "user/login";}

    @GetMapping("register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            bindingResult.getFieldError().forEach(error -> model.addAttribute(error.getField()+"error", error.getDefaultMessage()));
            return "user/register";
        }
    }
}
