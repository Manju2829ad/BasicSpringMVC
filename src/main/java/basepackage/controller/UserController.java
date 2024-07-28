package basepackage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import basepackage.model.User;
import basepackage.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "index"; // Corresponds to /static/index.html
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request) {
        User user = userService.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            request.getSession().setAttribute("user", user);
            return "redirect:/home"; // Redirects to /home endpoint
        }

        request.setAttribute("error", "Invalid credentials");
        return "index"; // Return to login page with error
    }

    @GetMapping("/home")
    public String showProfilePage(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            request.setAttribute("user", user);
            return "home"; // Corresponds to /static/home.html
        }

        return "redirect:/login"; // Redirect to login if no user found
    }
}
