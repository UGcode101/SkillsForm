package org.LaunchCode.skilltracker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SkillsController {

    @GetMapping("")
    public String index() {
        return "redirect:/index.html"; // Redirects to static index.html
    }

    @GetMapping("/form")
    public String form() {
        return "redirect:/form.html"; // Redirects to static form.html
    }

    @PostMapping("/form")
    @ResponseBody
    public String submitForm(@RequestParam String name, @RequestParam String first, @RequestParam String second, @RequestParam String third) {
        return "<html><body>" +
                "<h1>" + name + "'s Favorite Languages</h1>" +
                "<ol>" +
                "<li>" + first + "</li>" +
                "<li>" + second + "</li>" +
                "<li>" + third + "</li>" +
                "</ol></body></html>"; // Returns HTML content directly
    }
}