package edu.nahom.products.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.nahom.products.data.UsersRepository;
import edu.nahom.products.models.UserEntity;

@Controller
public class UserAdminController {

    private final UsersRepository usersRepository;

    public UserAdminController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    // Display all users
    @GetMapping("/admin/users")
    public String showUsers(Model model) {
        model.addAttribute("users", usersRepository.findAll());
        return "userAdmin";
    }

    // Display edit page for one user
    @GetMapping("/admin/users/edit/{id}")
    public String showEditUser(@PathVariable int id, Model model) {

        Optional<UserEntity> user = usersRepository.findById(id);

        if (user.isEmpty()) {
            return "redirect:/admin/users";
        }

        model.addAttribute("user", user.get());
        return "editUser";
    }

    // Update role and enabled status
    @PostMapping("/admin/users/edit")
    public String editUser(
            @RequestParam int id,
            @RequestParam String role,
            @RequestParam boolean enabled) {

        Optional<UserEntity> existingUser = usersRepository.findById(id);

        if (existingUser.isPresent()) {
            UserEntity user = existingUser.get();

            user.setRole(role);
            user.setEnabled(enabled);

            usersRepository.save(user);
        }

        return "redirect:/admin/users";
    }

    // Display delete confirmation page
    @GetMapping("/admin/users/delete/{id}")
    public String showDeleteUser(@PathVariable int id, Model model) {

        Optional<UserEntity> user = usersRepository.findById(id);

        if (user.isEmpty()) {
            return "redirect:/admin/users";
        }

        model.addAttribute("user", user.get());
        return "confirmDeleteUser";
    }

    // Delete selected user
    @PostMapping("/admin/users/delete")
    public String deleteUser(@RequestParam int id) {

        usersRepository.deleteById(id);

        return "redirect:/admin/users";
    }
}
