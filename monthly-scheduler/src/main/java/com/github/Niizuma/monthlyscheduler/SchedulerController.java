package com.github.Niizuma.monthlyscheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// Import the correct Event class
import com.github.Niizuma.monthlyscheduler.model.Event;

@Controller
public class SchedulerController {

    private final EventService eventService;

    // Constructor Injection
    @Autowired
    public SchedulerController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/scheduler")
    public String monthlyScheduler(Model model) {
        List<Event> events = eventService.findAllForCurrentMonth();
        model.addAttribute("events", events);
        return "scheduler";
    }

    @PostMapping("/events")
    public String addEvent(@ModelAttribute Event event, BindingResult result) {
        if (result.hasErrors()) {
            return "add-event";
        }
        eventService.save(event);
        return "redirect:/scheduler";
    }
}
