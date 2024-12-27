import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {
    static class Task {
        String description;
        boolean isDone;

        Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        void markAsDone() {
            this.isDone = true;
        }

        @Override
        public String toString() {
            return (isDone ? "[Done] " : "[Not Done] ") + description;
        }
    }

    static class TodoList {
        private ArrayList<Task> tasks;

        TodoList() {
            tasks = new ArrayList<>();
        }

        void addTask(String description) {
            tasks.add(new Task(description));
            System.out.println("Task added: " + description);
        }

        void markTaskAsDone(int index) {
            if (index >= 0 && index < tasks.size()) {
                tasks.get(index).markAsDone();
                System.out.println("Task marked as done.");
            } else {
                System.out.println("Invalid task index.");
            }
        }

        void viewTasks() {
            if (tasks.isEmpty()) {
                System.out.println("No tasks to display.");
            } else {
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }
            }
        }

        void deleteTask(int index) {
            if (index >= 0 && index < tasks.size()) {
                tasks.remove(index);
                System.out.println("Task deleted.");
            } else {
                System.out.println("Invalid task index.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList todoList = new TodoList();
        int choice;

        while (true) {
            System.out.println("\n----- To-Do List Menu -----");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Done");
            System.out.println("3. View Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character after int input

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String taskDescription = scanner.nextLine();
                    todoList.addTask(taskDescription);
                    break;

                case 2:
                    System.out.print("Enter task index to mark as done: ");
                    int markIndex = scanner.nextInt() - 1;
                    scanner.nextLine();  // Consume newline
                    todoList.markTaskAsDone(markIndex);
                    break;

                case 3:
                    todoList.viewTasks();
                    break;

                case 4:
                    System.out.print("Enter task index to delete: ");
                    int deleteIndex = scanner.nextInt() - 1;
                    scanner.nextLine();  // Consume newline
                    todoList.deleteTask(deleteIndex);
                    break;

                case 5:
                    System.out.println("Exiting application...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}

