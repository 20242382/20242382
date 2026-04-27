import java.util.ArrayList;
import java.util.List;

public class EmployeeController {
    private List<Employee> employees = new ArrayList<>();
    private EmployeeView   view;
    private int            nextId = 1;

    public EmployeeController(EmployeeView view) {
        this.view = view;
    }

    // Add
    public void addEmployee(String name, String email) {
        employees.add(new Employee(nextId++, name, email));
        view.showMessage("Employee added successfully.");
    }

    // Edit
    public boolean editEmployee(int id, String newName, String newEmail) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                if (!newName.isEmpty())  e.setName(newName);
                if (!newEmail.isEmpty()) e.setEmail(newEmail);
                view.showMessage("Employee updated successfully.");
                return true;
            }
        }
        view.showMessage("Employee with ID " + id + " not found.");
        return false;
    }

    // Display one
    public boolean displayEmployee(int id) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                view.printEmployeeDetails(e);
                return true;
            }
        }
        view.showMessage("Employee with ID " + id + " not found.");
        return false;
    }

    // Display all
    public void displayAllEmployees() {
        view.printAllEmployees(employees);
    }

    // Delete
    public boolean deleteEmployee(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.remove(i);
                view.showMessage("Employee deleted.");
                return true;
            }
        }
        view.showMessage("Employee with ID " + id + " not found.");
        return false;
    }

    public int getCount() { return employees.size(); }
}
