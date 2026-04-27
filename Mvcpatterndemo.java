import java.util.Scanner;

public class MVCPatternDemo {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        EmployeeView       view       = new EmployeeView();
        EmployeeController controller = new EmployeeController(view);

        // Seed sample data
        controller.addEmployee("Alice Johnson", "alice@company.com");
        controller.addEmployee("Bob Smith",     "bob@company.com");
        controller.addEmployee("Carol White",   "carol@company.com");

        int choice;
        while (true) {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║   Employee MVC System        ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║  1. Add Employee             ║");
            System.out.println("║  2. Edit Employee            ║");
            System.out.println("║  3. Display Employee by ID   ║");
            System.out.println("║  4. Display All Employees    ║");
            System.out.println("║  5. Delete Employee          ║");
            System.out.println("║  0. Exit                     ║");
            System.out.println("╚══════════════════════════════╝");
            choice = readInt("  Choose an option: ");

            switch (choice) {
                case 0:
                    System.out.println("\nGoodbye!");
                    return;

                case 1: {
                    String name  = readLine("  Name  : ");
                    String email = readLine("  Email : ");
                    controller.addEmployee(name, email);
                    break;
                }
                case 2: {
                    int id = readInt("  Employee ID to edit: ");
                    System.out.println("  Leave blank to keep current value.");
                    String name  = readLine("  New Name  : ");
                    String email = readLine("  New Email : ");
                    controller.editEmployee(id, name, email);
                    break;
                }
                case 3: {
                    int id = readInt("  Employee ID: ");
                    controller.displayEmployee(id);
                    break;
                }
                case 4:
                    controller.displayAllEmployees();
                    break;

                case 5: {
                    int id = readInt("  Employee ID to delete: ");
                    controller.deleteEmployee(id);
                    break;
                }
                default:
                    System.out.println("  Invalid option. Try again.");
            }
        }
    }

    // ── Helpers ──────────────────────────────────────────────────────────────

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                return n;
            } catch (NumberFormatException e) {
                System.out.println("  Invalid. Enter a number.");
            }
        }
    }
}
