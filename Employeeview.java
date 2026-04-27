import java.util.List;

public class EmployeeView {

    public void printEmployeeDetails(Employee e) {
        System.out.println("\n┌─────────────────────────────┐");
        System.out.println("│      Employee Details       │");
        System.out.println("├─────────────────────────────┤");
        System.out.println("│  ID    : " + e.getId());
        System.out.println("│  Name  : " + e.getName());
        System.out.println("│  Email : " + e.getEmail());
        System.out.println("└─────────────────────────────┘");
    }

    public void printAllEmployees(List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("\n  (No employees on record)");
            return;
        }
        System.out.println("\n╔══════╦══════════════════════╦════════════════════════════╗");
        System.out.println("║  ID  ║  Name                ║  Email                     ║");
        System.out.println("╠══════╬══════════════════════╬════════════════════════════╣");
        for (Employee e : employees) {
            System.out.printf("║ %4d ║ %-20s ║ %-26s ║%n",
                    e.getId(), e.getName(), e.getEmail());
        }
        System.out.println("╚══════╩══════════════════════╩════════════════════════════╝");
    }

    public void showMessage(String msg) {
        System.out.println("\n  >> " + msg);
    }
}
