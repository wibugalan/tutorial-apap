package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.service.RoleService;
import apap.tutorial.cineplux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/add")
    private String addUserFormPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getAuthorities().toString().equals("[ADMIN]")) {
            UserModel user = new UserModel();
            List<RoleModel> listRole = roleService.getListRole();
            model.addAttribute("user", user);
            model.addAttribute("listRole", listRole);
            return "form-add-user";
        }

        return "access-denied";
    }

    @PostMapping(value = "/addUser")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model) {
        boolean cond = userService.cekEmaul(user.getEmail());
        if (cond) {
            userService.addUser(user);
            model.addAttribute("user", user);
            return "redirect:/";
        }
        return "emaildigunakan";

    }

    @GetMapping(value = "/viewall")
    private String viewAllUser(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getAuthorities().toString().equals("[ADMIN]")) {
            List<UserModel> listUser = userService.getAll();
            model.addAttribute("listUser", listUser);
            return "list-user";
        }
        return "access-denied";
    }

    @GetMapping("/delete/{id}")
    public String deleteBioskopForm(
            @PathVariable String id,
            Model model
    ) {
        UserModel user = userService.getById(id);
        model.addAttribute("id", user.getId());
        model.addAttribute("user", user);
        return "form-delete-user";
    }

    @PostMapping("/delete")
    public String deleteBioskopSubmit(
            @ModelAttribute UserModel user,
            Model model
    ) {
        model.addAttribute("nama", user.getNama());
        userService.deleteUser(user);
        return "delete-user";
    }
}
