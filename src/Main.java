import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee fullTimeEmployee1 = new FullTimeEmployee("Manoj", 101, 20000.0);
        payrollSystem.addEmployee(fullTimeEmployee1);
        payrollSystem.displayEmployee();

        FullTimeEmployee fullTimeEmployee2 = new FullTimeEmployee("Manish", 102, 25000.0);
        payrollSystem.addEmployee(fullTimeEmployee2);
        payrollSystem.displayEmployee();
    }
}

abstract class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee Details:\nEmployee_name: " + name + "\nEmployee_id: " + id + "\nEmployee_salary: " + calculateSalary();
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

class PayrollSystem {
    private ArrayList<Employee> employeeArrayList;

    public PayrollSystem() {
        employeeArrayList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeArrayList.add(employee);
        System.out.println("Employee Mr. " + employee.getName() + " added successfully");
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeArrayList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeArrayList.remove(employeeToRemove);
            System.out.println("Employee removed successfully");
        }
    }

    public void displayEmployee() {
        for (Employee employee : employeeArrayList) {
            System.out.println(employee);
        }
    }
}
