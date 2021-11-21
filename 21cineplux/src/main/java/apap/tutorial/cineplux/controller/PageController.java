package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(
            Model model
    ) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel user = userService.getByUsername(auth.getName());
        model.addAttribute("id", user.getId());
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/password/{id}")
    public String ubahPassword(
            @PathVariable String id,
            Model model
    ) {
        UserModel user = userService.getById(id);
        model.addAttribute("user", user);
        model.addAttribute("passwordLama", false);
        model.addAttribute("passwordBaru", false);
        return "password";
    }

    @PostMapping("/password")
    public String ubahPassword(
            @ModelAttribute UserModel user,
            @RequestParam(value = "passLama") String passLama,
            @RequestParam(value = "passLamaForm") String passLamaForm,
            @RequestParam(value = "passBaru") String passBaru,
            Model model
    ) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean cond = passwordEncoder.matches(passLamaForm, passLama);
        if (cond){
            if (passBaru.equals(user.getPassword())) {
                userService.addUser(user);
            }
            else {
                model.addAttribute("passwordLama", false);
                model.addAttribute("passwordBaru", true);
                user.setPassword(passLama);
                model.addAttribute("user", user);
                return "password";
            }
        }
        else {
            model.addAttribute("passwordLama", true);
            model.addAttribute("passwordBaru", false);
            user.setPassword(passLama);
            model.addAttribute("user", user);
            return "password";
        }
        return "redirect:/";
    }
}
