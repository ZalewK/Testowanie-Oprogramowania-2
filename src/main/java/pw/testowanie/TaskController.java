package pw.testowanie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {
    private final List<Task> tasks = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @PostMapping("/addTask")
    public String addTask(@RequestParam String name, @RequestParam String details) {
        Task task = new Task(name, details);
        tasks.add(task);
        return "redirect:/";
    }
    

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable long id) {
        tasks.removeIf(task -> task.getId() == id);
        return "redirect:/";
    }

    @GetMapping("/taskDetails/{id}")
    public String taskDetails(@PathVariable long id, @RequestParam(required = false) String details, Model model) {
        Task task = tasks.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
        model.addAttribute("task", task);
        return "taskDetails";
    }

}
