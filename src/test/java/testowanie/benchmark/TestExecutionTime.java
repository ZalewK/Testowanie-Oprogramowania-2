//package testowanie.benchmark;
//
//import pw.testowanie.Priority;
//import pw.testowanie.Status;
//import pw.testowanie.Task;
//import pw.testowanie.TaskController;
//import testowanie.benchmark.PerformanceTestUtils;
//
//public class TestExecutionTime {
//
//    public static void main(String[] args) {
//        TaskController taskController = new TaskController();
//
//        // Przykład dla metody addTask
//        PerformanceTestUtils.measureExecutionTime(() ->
//                        taskController.addTask("New Test Task", "Details", "User", Priority.MEDIUM),
//                "addTask");
//
//        // Załóżmy, że mamy już dodane zadanie o id 1 dla testów delete i toggle
//        final long taskId = 1;
//
//        // Przykład dla metody deleteTask
//        PerformanceTestUtils.measureExecutionTime(() ->
//                        taskController.deleteTask(taskId),
//                "deleteTask");
//
//        // Przykład dla metody toggleTaskStatus
//        PerformanceTestUtils.measureExecutionTime(() ->
//                        taskController.toggleTaskStatus(taskId),
//                "toggleTaskStatus");
//
//        PerformanceTestUtils.measureExecutionTime(() ->
//                        taskController.sort("name"),  // Przykładowy parametr sortowania
//                "sortTasks");
//
//        PerformanceTestUtils.measureExecutionTime(() ->
//                        new Task("Task Name", "Task Details", "User", Priority.MEDIUM),
//                "Task Constructor");
//
//        Task task = new Task("Task Name", "Task Details", "User", Priority.MEDIUM);
//        PerformanceTestUtils.measureExecutionTime(() ->
//                        task.setName("New Task Name"),
//                "setName");
//
//        Task task1 = new Task("Task Name", "Task Details", "User", Priority.MEDIUM);
//        PerformanceTestUtils.measureExecutionTime(() ->
//                        task1.setDetails("New Task Details"),
//                "setDetails");
//
//        Task task3 = new Task("Task Name", "Task Details", "User", Priority.MEDIUM);
//        PerformanceTestUtils.measureExecutionTime(() ->
//                        task3.setUser("New User"),
//                "setUser");
//
//        Task task4 = new Task("Task Name", "Task Details", "User", Priority.MEDIUM);
//        PerformanceTestUtils.measureExecutionTime(() ->
//                        task4.setPriority(Priority.HIGH),
//                "setPriority");
//
//        Task task5 = new Task("Task Name", "Task Details", "User", Priority.MEDIUM);
//        PerformanceTestUtils.measureExecutionTime(() ->
//                        task5.setStatus(Status.COMPLETED),
//                "setStatus");
//
//    }
//
//}
//
//
