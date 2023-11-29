package pw.testowanie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TaskController {
    private final List<Task> tasks = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        updateTaskCounts(model);
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @GetMapping("/tasks")
    public String sort(@RequestParam(name = "sortBy", required = false) String sortBy) {
        if (sortBy != null) {
            sortTasks(sortBy);
        }

        return "redirect:/";
    }

    @PostMapping("/addTask")
    public String addTask(@RequestParam String name,
                          @RequestParam String details,
                          @RequestParam String user,
                          @RequestParam Priority priority) {
        Task task = new Task(name, details, user, priority);
        tasks.add(task);
        return "redirect:/";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable long id) {
        tasks.removeIf(task -> task.getId() == id);
        return "redirect:/";
    }

    @GetMapping("/taskDetails/{id}")
    public String taskDetails(@PathVariable long id, Model model) {
        Task task = tasks.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
        model.addAttribute("task", task);
        return "taskDetails";
    }

    @PostMapping("/toggleTaskStatus/{id}")
    public String toggleTaskStatus(@PathVariable long id) {
        Task task = tasks.stream().filter(t -> t.getId() == id).findFirst().orElse(null);

        if (task != null) {
            if (task.getStatus() == Status.IN_PROGRESS) {
                task.setStatus(Status.COMPLETED);
            } else {
                task.setStatus(Status.IN_PROGRESS);
            }
        }

        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchTasks(@RequestParam(required = false) String userName,
                              @RequestParam(required = false) String taskName,
                              Model model) {
        List<Task> filteredTasks = tasks;

        if (userName != null && !userName.isEmpty()) {
            filteredTasks = filterTasksByUserName(filteredTasks, userName);
        }

        if (taskName != null && !taskName.isEmpty()) {
            filteredTasks = filterTasksByTaskName(filteredTasks, taskName);
        }

        model.addAttribute("tasks", filteredTasks);
        return "index";
    }

    private List<Task> filterTasksByUserName(List<Task> tasks, String userName) {
        return tasks.stream()
                .filter(task -> task.getUser().toLowerCase().contains(userName.toLowerCase()))
                .collect(Collectors.toList());
    }

    private List<Task> filterTasksByTaskName(List<Task> tasks, String taskName) {
        return tasks.stream()
                .filter(task -> task.getName().toLowerCase().contains(taskName.toLowerCase()))
                .collect(Collectors.toList());
    }


    private void sortTasks(String sortBy) {
        if ("name".equals(sortBy)) {
            tasks.sort(Comparator.comparing(task -> task.getName().toLowerCase()));
        } else if ("user".equals(sortBy)) {
            tasks.sort(Comparator.comparing(task -> task.getUser().toLowerCase()));
        } else if ("priority".equals(sortBy)) {
            tasks.sort(Comparator.comparing(Task::getPriority));
        } else if("status".equals(sortBy)){
            tasks.sort(Comparator.comparing(Task::getStatus));
        }
    }

    private void updateTaskCounts(Model model) {
        long totalTasks = tasks.size();
        long completedTasks = tasks.stream().filter(task -> task.getStatus() == Status.COMPLETED).count();
        long inProgressTasks = tasks.stream().filter(task -> task.getStatus() == Status.IN_PROGRESS).count();

        model.addAttribute("totalTasks", totalTasks);
        model.addAttribute("completedTasks", completedTasks);
        model.addAttribute("inProgressTasks", inProgressTasks);
    }

    public void addTaskDirectly(Task task) {
        this.tasks.add(task);
    }

    public List<Task> getTasks(){
        return tasks;
    }

    public Task getTaskById(long id) {
        return tasks.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

}
